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

        this.spriteSheet = Grass.createSpriteSheet(this);
    }

    public Grass(Game game, IsometricCoords initialCoords) {
        super(game, initialCoords);

        this.spriteSheet = Grass.createSpriteSheet(this);
    }

    public IsometricCoords getCoords() {
        return this.getInitialCoords();
    }

    public Dimension getDimension() {
        return new Dimension(256, 150);
    }

    public void update() {}

    public void render(Graphics graphics) {
        Image image = this.spriteSheet.getItem();

        int x = this.getX();
        int y = this.getY();

        graphics.drawImage(image, x, y, null);
    }

    public Point getChainingOffsets() {
        return new Point(0, -76);
    }

    private int getX() {
        IsometricCoords coords = this.getCoords();

        return coords.getX();
    }

    private int getY() {
        IsometricCoords coords = this.getCoords();

        return coords.getY();
    }

    private static SpriteSheet createSpriteSheet(Grass grass) {
        try {
            return new SpriteSheet(grass);
        } catch (IOException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    private SpriteSheet spriteSheet;
}
