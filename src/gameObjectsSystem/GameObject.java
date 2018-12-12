package gameObjectsSystem;

import game.Game;
import lib.BoundingRect;
import lib.gameObjectDimensions.RealDimension;
import lib.gameObjectDimensions.VirtualDimension;
import lib.coords.CartesianCoords;
import lib.coords.IsometricCoords;
import lib.gameObjectPosition.offsets.RealChainingOffsets;

import javax.swing.*;
import java.awt.*;

public abstract class GameObject {
    public abstract void update();
    public abstract void render(Graphics graphics);
    public abstract IsometricCoords getCoords();

    public abstract RealDimension getRealDimension();
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
        RealDimension dimension = this.getRealDimension();
        JFrame jframe = (JFrame) this.getWindow();

        return new BoundingRect(coords, dimension, jframe);
    }

    public RealChainingOffsets getChainingOffsets() {
        return new RealChainingOffsets(0, 0);
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
        RealChainingOffsets offsets = this.getChainingOffsets();

        initialCoords.addOffsets(offsets);

        return initialCoords.toIsometric();
    }

    private IsometricCoords createInitialCoords() {
        RealChainingOffsets offsets = this.getChainingOffsets();

        int x = offsets.getX();
        int y = offsets.getY();

        return new IsometricCoords(x, y);
    }

    private Window getWindow() {
        return this.game.getWindow();
    }

    private Game game;
    private IsometricCoords initialCoords;
}