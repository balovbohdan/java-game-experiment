package gameObjectsSystem;

import gameObjectsSystem.gameObjects.Player;

public class GameObjectsFactory {
    public static GameObjects create(){
        GameObjects gameObjects = new GameObjects();

        gameObjects.add(new Player());

        return gameObjects;
    }
}
