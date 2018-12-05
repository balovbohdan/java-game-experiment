package gameObjectsSystem;

import game.Game;
import lib.BoundingRect;
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

    public GameObject(Game game, IsometricCoords initialCoords) {
        this.game = game;
        this.initialCoords = this.prepareInitialCoords(initialCoords);
    }

    public BoundingRect getBoundingRect() {
        IsometricCoords coords = this.getCoords();
        Dimension dimension = this.getDimension();
        JFrame jframe = (JFrame) this.getWindow();

        return new BoundingRect(coords, dimension, jframe);
    }

    public void setInitialTilePosition(int row, int col) {
        this.initialTilePosition = new Point(col, row);
    }

    public Point getInitialTilePosition() {
        return this.initialTilePosition;
    }

    public void setInitialCoords(IsometricCoords initialCoords) {
        this.initialCoords = this.prepareInitialCoords(initialCoords);
    }

    public Point getChainingOffsets() {
        return new Point(0, 0);
    }

    protected Game getGame() {
        return this.game;
    }

    protected IsometricCoords getInitialCoords() {
        return this.initialCoords;
    }

    private IsometricCoords prepareInitialCoords(IsometricCoords initialCoords) {
        Point offsets = this.getChainingOffsets();

        initialCoords.addOffsets(offsets);

        return initialCoords;
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
    private Point initialTilePosition = new Point(0, 0);
}