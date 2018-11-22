package game.window;

import gameObjectsSystem.GameObjects;

import java.awt.Graphics;

class Renderer {
    static void render(Graphics graphics, GameObjects gameObjects) {
        Renderer renderer = new Renderer(graphics, gameObjects);

        renderer.render();
    }

    private Renderer(Graphics graphics, GameObjects gameObjects) {
        this.graphics = graphics;
        this.gameObjects = gameObjects;
    }

    private void render() {
        this.gameObjects.render(this.graphics);
    }

    private Graphics graphics;
    private GameObjects gameObjects;
}