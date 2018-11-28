package gameObjectsSystem.gameObjects.player;

import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.gameObjects.player.spriteSheet.SpriteSheet;
import lib.coords.Coords;
import lib.coords.IsometricCoords;
import lib.eventsManagers.keyboard.KeyboardMap;

import java.awt.*;
import java.io.IOException;

public class Player extends GameObject {
    public Player(Game game) {
        super(game);

        this.keyboardMap = game.getKeyboardMap();
        this.coordsManager = new CoordsManager(this);
    }

    int getSpeed() {
        return 2;
    }

    public IsometricCoords getCoords() {
        return this.coordsManager.getCoords();
    }

    public Dimension getDimension() {
        return new Dimension(299, 240);
    }

    public void update() {
        this.coordsManager.updateCoords();
    }

    public void render(Graphics graphics) {
        Image image = this.spriteSheet.getItem();
        Coords coords = this.getCoords();

        int x = coords.getX();
        int y = coords.getY();

        graphics.drawImage(image, x, y, null);
    }

    KeyboardMap getKeyboardMap() {
        return this.keyboardMap;
    }

    private static SpriteSheet createSpriteSheet() {
        try {
            return new SpriteSheet();
        } catch (IOException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    private KeyboardMap keyboardMap;
    private CoordsManager coordsManager;

    private SpriteSheet spriteSheet = Player.createSpriteSheet();
}
