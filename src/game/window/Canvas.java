package game.window;

import game.Game;
import gameObjectsSystem.GameObjects;

import javax.swing.JPanel;
import java.awt.Graphics;

class Canvas extends JPanel {
    Canvas(Game game) {
        this.game = game;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        GameObjects gameObjects = this.getGameObjects();

        Canvas.renderGameObjects(graphics, gameObjects);
    }

    private static void renderGameObjects(Graphics graphics, GameObjects gameObjects) {
        Renderer.render(graphics, gameObjects);
    }

    private GameObjects getGameObjects() {
        return this.game.getGameObjects();
    }

    private Game game;
}