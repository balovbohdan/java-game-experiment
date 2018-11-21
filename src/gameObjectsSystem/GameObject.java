package gameObjectsSystem;

import game.Game;

import java.awt.Graphics;
import java.awt.Component;

public abstract class GameObject extends Component {
    public abstract void update();
    public abstract void render(Graphics graphics);

    public GameObject(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }

    private Game game;
}