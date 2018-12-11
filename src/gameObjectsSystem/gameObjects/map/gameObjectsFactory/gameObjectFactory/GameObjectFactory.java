package gameObjectsSystem.gameObjects.map.gameObjectsFactory.gameObjectFactory;

import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.MapPoint;
import lib.coords.CartesianCoords;
import lib.coords.IsometricCoords;

import java.awt.*;
import java.lang.reflect.Constructor;

public class GameObjectFactory {
    public static GameObject create(GameObjectData data) throws Exception {
        GameObjectFactory factory = new GameObjectFactory(data);

        return factory.create();
    }

    private GameObjectFactory(GameObjectData data) {
        this.name = data.name;
        this.game = data.game;
        this.offsets = data.offsets;
        this.mapPoint = data.mapPoint;
        this.topSibling = data.topSibling;
        this.leftSibling = data.leftSibling;
    }

    private GameObject create() throws Exception {
        GameObject gameObject = this.createBase();

        gameObject.setInitialMapPoint(this.mapPoint);

        CartesianCoords initialCoords = this.calcInitialCoords(gameObject, this.offsets);

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

    private CartesianCoords calcInitialCoords(GameObject gameObject, Point offsets) {
        return InitialCoordsCalculator.calc(gameObject, offsets, this.leftSibling, this.topSibling);
    }

    private Game game;
    private String name;
    private MapPoint mapPoint;
    private Point offsets;

    private GameObject topSibling;
    private GameObject leftSibling;
}
