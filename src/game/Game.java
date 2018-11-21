package game;

import game.window.Window;
import game.window.WindowFactory;
import gameObjectsSystem.GameObjects;
import gameObjectsSystem.GameObjectsFactory;
import lib.eventsManagers.keyboard.KeyboardMap;
import lib.gameLoop.GameController;

public class Game implements GameController {
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

    public KeyboardMap getKeyboardMap() {
        return this.window.getKeyboardMap();
    }

    private Window createWindow() {
        return WindowFactory.create(this);
    }

    private GameObjects createGameObjects() {
        return GameObjectsFactory.create(this);
    }

    private Window window = this.createWindow();
    private GameObjects gameObjects = this.createGameObjects();
}
