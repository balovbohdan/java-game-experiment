package gameObjectsSystem.gameObjects.grass;

import game.Game;
import gameObjectsSystem.GameObject;

import java.awt.*;

public class Grass extends GameObject {
    public Grass(Game game) {
        super(game);
    }

    public void update() {

    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(0, 0, 170, 170);
    }
}
