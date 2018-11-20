package game.window;

import gameObjectsSystem.GameObject;
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
        this.gameObjects.forEach((GameObject gameObject) -> {
            gameObject.render(this.graphics);

            return true;
        });
    }

    private Graphics graphics;
    private GameObjects gameObjects;
}