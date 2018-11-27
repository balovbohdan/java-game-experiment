package gameObjectsSystem;

import game.Game;

import java.awt.Graphics;

public abstract class GameObject {
    public abstract void update();
    public abstract void render(Graphics graphics);

    public GameObject(Game game) {
        this.game = game;
    }

    protected Game getGame() {
        return this.game;
    }

    private Game game;
}