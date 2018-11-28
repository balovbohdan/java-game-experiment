package gameObjectsSystem.gameObjects.grass;

import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.gameObjects.grass.spriteSheet.SpriteSheet;
import lib.coords.IsometricCoords;

import java.awt.*;
import java.io.IOException;

public class Grass extends GameObject {
    public Grass(Game game) {
        super(game);

        this.spriteSheet = Grass.createSpriteSheet();
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
        Image image = this.spriteSheet.getItem();

        int x = 0;
        int y = 0;

        graphics.drawImage(image, x, y, null);
    }

    private static SpriteSheet createSpriteSheet() {
        try {
            return new SpriteSheet();
        } catch (IOException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    private SpriteSheet spriteSheet;
}
