package game.game;

import game.Window;
import game.WindowFactory;
import gameObjectsSystem.GameObjects;
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
    private GameObjects gameObjects = new GameObjects();
}
