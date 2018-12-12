package gameObjectsSystem.gameObjects.cube;

import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.gameObjects.cube.spriteSheet.SpriteSheet;
import lib.dimensions.RealDimension;
import lib.dimensions.VirtualDimension;
import lib.coords.CartesianCoords;
import lib.coords.IsometricCoords;

import java.awt.*;
import java.io.IOException;

public class Cube extends GameObject {
    public Cube(Game game) {
        super(game);

        this.spriteSheet = Cube.createSpriteSheet(this);
    }

    public Cube(Game game, CartesianCoords initialCoords) {
        super(game, initialCoords);

        this.spriteSheet = Cube.createSpriteSheet(this);
    }

    public IsometricCoords getCoords() {
        return this.getInitialCoords();
    }

    public RealDimension getRealDimension() {
        return new RealDimension(128,128);
    }

    public VirtualDimension getVirtualDimension() {
        return new VirtualDimension(64, 64, 64);
    }

    public void update() {}

    public void render(Graphics graphics) {
        Image image = this.spriteSheet.getItem();

        int x = this.getX();
        int y = this.getY();

        graphics.drawImage(image, x, y, null);
    }

    public Point getChainingOffsets() {
        return new Point(-32, -32);
    }

    private int getX() {
        IsometricCoords coords = this.getCoords();

        return coords.getX();
    }

    private int getY() {
        IsometricCoords coords = this.getCoords();

        return coords.getY();
    }

    private static SpriteSheet createSpriteSheet(Cube cube) {
        try {
            return new SpriteSheet(cube);
        } catch (IOException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    private SpriteSheet spriteSheet;
}
