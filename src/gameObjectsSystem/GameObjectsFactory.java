package gameObjectsSystem;

import game.Game;
import gameObjectsSystem.gameObjects.map.Map;
import gameObjectsSystem.gameObjects.player.Player;

public class GameObjectsFactory {
    public static GameObjects create(Game game) {
        GameObjects gameObjects = new GameObjects();

        gameObjects.add(new Map(game));
        gameObjects.add(new Player(game));

        return gameObjects;
    }
}
