package gameObjectsSystem.gameObjects;

import gameObjectsSystem.GameObject;

import java.awt.Graphics;

public class Player extends GameObject {
    public void update() {
        this.x += this.dx;
        this.y += this.dy;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 100, 100);
    }

    private int dx = 1;
    private int dy = 1;

    private int x = 0;
    private int y = 0;
}
