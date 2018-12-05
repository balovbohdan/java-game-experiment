package gameObjectsSystem.gameObjects.map.gameObjectsFactory.gameObjectFactory;

import game.Game;
import gameObjectsSystem.GameObject;
import lib.coords.IsometricCoords;

import java.lang.reflect.Constructor;

public class GameObjectFactory {
    public static GameObject create(GameObjectData data) throws Exception {
        GameObjectFactory factory = new GameObjectFactory(data);

        return factory.create();
    }

    private GameObjectFactory(GameObjectData data) {
        this.row = data.row;
        this.col = data.col;
        this.name = data.name;
        this.game = data.game;
        this.prevGameObject = data.prevGameObject;
    }

    private GameObject create() throws Exception {
        GameObject gameObject = this.createBase();

        gameObject.setInitialTilePosition(this.row, this.col);

        IsometricCoords initialCoords = this.calcInitialCoords(gameObject);

        gameObject.setInitialCoords(initialCoords);

        return gameObject;
    }

    private GameObject createBase() throws Exception {
        String packageName = this.name.toLowerCase();
        String className = "gameObjectsSystem.gameObjects." + packageName + "." + this.name;

        Class<?> Clazz = Class.forName(className);
        Constructor constructor = Clazz.getConstructor(this.game.getClass());
        Object ob = constructor.newInstance(this.game);

        return (GameObject) ob;
    }

    private IsometricCoords calcInitialCoords(GameObject gameObject) {
        return InitialCoordsCalculator.calc(gameObject, this.prevGameObject);
    }

    private int row;
    private int col;

    private Game game;
    private String name;
    private GameObject prevGameObject;
}
