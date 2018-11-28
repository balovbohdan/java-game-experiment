package gameObjectsSystem.gameObjects.grass;

import game.Game;
import gameObjectsSystem.GameObject;
import lib.coords.Coords;
import lib.coords.IsometricCoords;

import java.awt.*;

public class Grass extends GameObject {
    public Grass(Game game) {
        super(game);
    }

    public IsometricCoords getCoords() {
        return new IsometricCoords(0, 0);
    }

    public Dimension getDimension() {
        return new Dimension(299, 240);
    }

    public void update() {

    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(0, 0, 170, 170);
    }
}
