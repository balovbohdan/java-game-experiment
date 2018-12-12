package gameObjectsSystem;

import game.Game;
import lib.BoundingRect;
import lib.coords.CartesianCoords;
import lib.coords.IsometricCoords;

import javax.swing.*;
import java.awt.*;

public abstract class GameObject {
    public abstract void update();
    public abstract void render(Graphics graphics);
    public abstract Dimension getDimension();
    public abstract IsometricCoords getCoords();

    public GameObject(Game game) {
        this.game = game;
        this.initialCoords = this.createInitialCoords();
    }

    public GameObject(Game game, CartesianCoords initialCoords) {
        this.game = game;
        this.initialCoords = this.prepareInitialCoords(initialCoords);
    }

    public BoundingRect getBoundingRect() {
        IsometricCoords coords = this.getCoords();
        Dimension dimension = this.getDimension();
        JFrame jframe = (JFrame) this.getWindow();

        return new BoundingRect(coords, dimension, jframe);
    }

    public void setInitialCoords(CartesianCoords initialCoords) {
        this.initialCoords = this.prepareInitialCoords(initialCoords);
    }

    /**
     * Chaining offsets helps to find so called "chaining point".
     * Chaining point is:
     * 1) top-left tile corner at cartesian coordinates system;
     * 2) top-center tile corner at isometric coordinates system.
     */
    public Point getChainingOffsets() {
        return new Point(0, 0);
    }

    protected Game getGame() {
        return this.game;
    }

    protected IsometricCoords getInitialCoords() {
        return this.initialCoords;
    }

    private IsometricCoords prepareInitialCoords(CartesianCoords initialCoords) {
        Point offsets = this.getChainingOffsets();

        initialCoords.addOffsets(offsets);

        return initialCoords.toIsometric();
    }

    private IsometricCoords createInitialCoords() {
        Point offsets = this.getChainingOffsets();

        int x = (int) offsets.getX();
        int y = (int) offsets.getY();

        return new IsometricCoords(x, y);
    }

    private Window getWindow() {
        return this.game.getWindow();
    }

    private Game game;
    private IsometricCoords initialCoords;
    private MapPoint initialTilePoint = new MapPoint(0, 0);
}