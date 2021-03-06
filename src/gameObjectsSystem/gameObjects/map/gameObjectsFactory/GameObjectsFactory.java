package gameObjectsSystem.gameObjects.map.gameObjectsFactory;

import configs.Config;
import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.GameObjects;
import gameObjectsSystem.MapPoint;
import gameObjectsSystem.gameObjects.map.gameObjectsFactory.gameObjectFactory.GameObjectData;
import gameObjectsSystem.gameObjects.map.gameObjectsFactory.gameObjectFactory.GameObjectFactory;
import lib.map.ConfigItem;
import lib.map.ConfigItems;
import lib.map.configParser.ConfigParser;

public class GameObjectsFactory {
    public static GameObjects create(Game game) {
        GameObjectsFactory factory = new GameObjectsFactory(game);

        return factory.create();
    }

    private GameObjectsFactory(Game game) {
        this.game = game;
        this.gameObjects = new GameObjects();
    }

    private GameObjects create() {
        ConfigItems configItems = this.parseConfig();

        configItems.forEach(this::addToGameObjectsSafe);

        return this.gameObjects;
    }

    private ConfigItems parseConfig() {
        return ConfigParser.parse("def", Config.MAPS_CONFIGS_ROOT);
    }

    private Boolean addToGameObjectsSafe(ConfigItem configItem) {
        try {
            return this.addToGameObjects(configItem);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

    private Boolean addToGameObjects(ConfigItem configItem) throws Exception {
        GameObject gameObject = this.createGameObject(configItem);

        this.gameObjects.add(gameObject);

        return true;
    }

    private GameObject createGameObject(ConfigItem configItem) throws Exception {
        GameObjectData data = this.createGameObjectData(configItem);

        return GameObjectFactory.create(data);
    }

    private GameObjectData createGameObjectData(ConfigItem configItem) {
        MapPoint mapPoint = configItem.getMapPoint();

        GameObjectData data = new GameObjectData();

        data.name = configItem.getName();
        data.offsets = configItem.getOffsets();
        data.mapPoint = configItem.getMapPoint();

        data.game = this.game;

        data.topSibling = this.gameObjects.getTopSibling(mapPoint);
        data.leftSibling = this.gameObjects.getLeftSibling(mapPoint);

        return data;
    }

    private Game game;
    private GameObjects gameObjects;
}
