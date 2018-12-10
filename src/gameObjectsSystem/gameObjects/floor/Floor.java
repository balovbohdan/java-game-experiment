package gameObjectsSystem.gameObjects.floor;

import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.gameObjects.floor.spriteSheet.SpriteSheet;
import lib.coords.CartesianCoords;
import lib.coords.IsometricCoords;

import java.awt.*;
import java.io.IOException;

public class Floor extends GameObject {
    public Floor(Game game) {
        super(game);

        this.spriteSheet = Floor.createSpriteSheet(this);
    }

    public Floor(Game game, CartesianCoords initialCoords) {
        super(game, initialCoords);

        this.spriteSheet = Floor.createSpriteSheet(this);
    }

    public IsometricCoords getCoords() {
        return this.getInitialCoords();
    }

    public Dimension getDimension() {
        return new Dimension(128, 64);
    }

    public void update() {}

    public void render(Graphics graphics) {
        Image image = this.spriteSheet.getItem();

        int x = this.getX();
        int y = this.getY();

        graphics.drawImage(image, x, y, null);
    }

    public Point getChainingOffsets() {
        return new Point(-32, 0);
    }

    private int getX() {
        IsometricCoords coords = this.getCoords();

        return coords.getX();
    }

    private int getY() {
        IsometricCoords coords = this.getCoords();

        return coords.getY();
    }

    private static SpriteSheet createSpriteSheet(Floor floor) {
        try {
            return new SpriteSheet(floor);
        } catch (IOException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    private SpriteSheet spriteSheet;
}
