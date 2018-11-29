package gameObjectsSystem.gameObjects.map;

import game.Game;
import game.window.Window;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.GameObjects;
import lib.coords.IsometricCoords;

import java.awt.*;

public class Map extends GameObject {
    public Map(Game game) {
        super(game);

        this.window = game.getWindow();
        this.gameObjects = GameObjectsFactory.create(game);
    }

    public IsometricCoords getCoords() {
        return new IsometricCoords(0, 0);
    }

    public Dimension getDimension() {
        return new Dimension(299, 240);
    }

    public void update() {
        this.gameObjects.update();
    }

    public void render(Graphics graphics) {
        int windowWidth = this.getWindowWidth();
        int windowHeight = this.getWindowHeight();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, windowWidth, windowHeight);

        this.gameObjects.render(graphics);
    }

    private int getWindowWidth() {
        return this.window.getWidth();
    }

    private int getWindowHeight() {
        return this.window.getHeight();
    }

    private Window window;
    private GameObjects gameObjects;
}
