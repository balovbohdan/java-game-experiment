package gameObjectsSystem;

import game.Game;
import lib.BoundingRect;
import lib.coords.CartesianCoords;
import lib.coords.Coords;
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
    }

    public BoundingRect getBoundingRect() {
        IsometricCoords coords = this.getCoords();
        Dimension dimension = this.getDimension();
        JFrame jframe = (JFrame) this.getWindow();

        return new BoundingRect(coords, dimension, jframe);
    }

    protected Game getGame() {
        return this.game;
    }

    private Window getWindow() {
        return this.game.getWindow();
    }

    private Game game;
}