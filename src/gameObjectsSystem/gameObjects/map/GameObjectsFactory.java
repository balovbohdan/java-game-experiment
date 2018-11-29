package gameObjectsSystem.gameObjects.map;

import configs.Config;
import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.GameObjects;
import lib.coords.IsometricCoords;
import lib.map.ConfigItem;
import lib.map.ConfigItems;
import lib.map.configParser.ConfigParser;

import java.awt.*;
import java.lang.reflect.Constructor;

class GameObjectsFactory {
    static GameObjects create(Game game) {
        GameObjectsFactory factory = new GameObjectsFactory(game);

        return factory.create();
    }

    private GameObjectsFactory(Game game) {
        this.game = game;
        this.gameObjects = new GameObjects();
    }

    private GameObjects create() {
        ConfigItems items = ConfigParser.parse("def", Config.MAPS_CONFIGS_ROOT);

        items.forEach((ConfigItem item) -> {
            try {
                int row = item.getRow();
                int col = item.getCol();

                String name = item.getName();

                System.out.println(row);

                GameObject gameObject = this.createGameObject(name, row, col);

                this.gameObjects.add(gameObject);

                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());

                return false;
            }
        });

        return this.gameObjects;
    }

    private GameObject createGameObject(String name, int row, int col) throws Exception {
        String packageName = name.toLowerCase();
        String className = "gameObjectsSystem.gameObjects." + packageName + "." + name;

        GameObject prevGameObject = this.getPrevGameObject();

        IsometricCoords initialCoords = GameObjectsFactory.calcInitialCoords(prevGameObject, row, col);

        Class<?> clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor(this.game.getClass(), IsometricCoords.class);
        Object ob = constructor.newInstance(this.game, initialCoords);

        return (GameObject) ob;
    }

    private GameObject getPrevGameObject() {
        return this.gameObjects.getLast();
    }

    private static IsometricCoords calcInitialCoords(GameObject prevGameObject, int row, int col) {
        int extraXOffset = row % 2 == 0
                ? -256 / 2
                : 0;

        if (prevGameObject == null)
            return new IsometricCoords(extraXOffset, 0);

        Point chainingOffsets = prevGameObject.getChainingOffsets();
        Dimension prevGameObjectDimension = prevGameObject.getDimension();

        double prevObjectWidth = prevGameObjectDimension.getWidth();
        double prevObjectHeight = prevGameObjectDimension.getHeight();

        double xOffset = chainingOffsets.getX();
        double yOffset = chainingOffsets.getY();

        int x = (int) Math.round((prevObjectWidth + xOffset) * col + extraXOffset);
        int y = (int) Math.round((prevObjectHeight + yOffset) * row);

        return new IsometricCoords(x, y);
    }

    private Game game;
    private GameObjects gameObjects;
}
