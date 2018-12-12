package gameObjectsSystem;

import game.Game;
import lib.BoundingRect;
import lib.dimensions.VirtualDimension;
import lib.coords.CartesianCoords;
import lib.coords.IsometricCoords;

import javax.swing.*;
import java.awt.*;

public abstract class GameObject {
    public abstract void update();
    public abstract void render(Graphics graphics);
    public abstract IsometricCoords getCoords();

    public abstract Dimension getRealDimension();
    public abstract VirtualDimension getVirtualDimension();

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
        Dimension dimension = this.getRealDimension();
        JFrame jframe = (JFrame) this.getWindow();

        return new BoundingRect(coords, dimension, jframe);
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

    public void setInitialCoords(CartesianCoords initialCoords) {
        this.initialCoords = this.prepareInitialCoords(initialCoords);
    }

    protected IsometricCoords getInitialCoords() {
        return this.initialCoords;
    }

    protected Game getGame() {
        return this.game;
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
}