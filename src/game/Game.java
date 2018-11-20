package game;

import game.window.Window;
import game.window.WindowFactory;
import gameObjectsSystem.GameObjects;
import gameObjectsSystem.GameObjectsFactory;
import gameObjectsSystem.gameObjects.Player;
import lib.gameLoop.GameController;

public class Game implements GameController {
    public Game() {
        this.gameObjects.add(new Player());
    }

    public GameObjects getGameObjects() {
        return this.gameObjects;
    }

    public void updateGameObjects() {
        this.gameObjects.update();
    }

    public void renderGameObjects() {
        this.window.repaint();
    }

    public void showWindow() {
        this.window.setVisible(true);
    }

    private Window window = WindowFactory.create(this);
    private GameObjects gameObjects = GameObjectsFactory.create();
}
