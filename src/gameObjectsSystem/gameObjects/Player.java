package gameObjectsSystem.gameObjects;

import game.Game;
import gameObjectsSystem.GameObject;
import lib.eventsManagers.keyboard.KeyboardMap;

import java.awt.Graphics;

public class Player extends GameObject {
    public Player(Game game) {
        super(game);
    }

    public void update() {
        KeyboardMap keyboardMap = this.getKeyboardMap();

        Boolean is_w = keyboardMap.is_w();
        Boolean is_s = keyboardMap.is_s();
        Boolean is_a = keyboardMap.is_a();
        Boolean is_d = keyboardMap.is_d();

        if (is_w)
            this.y -= this.dy;

        if (is_s)
            this.y += this.dy;

        if (is_a)
            this.x -= this.dx;

        if (is_d)
            this.x += this.dx;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 100, 100);
    }

    private KeyboardMap getKeyboardMap() {
        Game game = this.getGame();

        return game.getKeyboardMap();
    }

    private int dx = 1;
    private int dy = 1;

    private int x = 0;
    private int y = 0;
}
