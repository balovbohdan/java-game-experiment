package gameObjectsSystem.gameObjects.player;

import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.gameObjects.player.spriteSheet.SpriteSheet;
import lib.coords.CartesianCoords;
import lib.coords.Coords;
import lib.coords.IsometricCoords;
import lib.gameObjectDimensions.RealDimension;
import lib.gameObjectDimensions.VirtualDimension;
import lib.eventsManagers.keyboard.KeyboardMap;

import java.awt.*;
import java.io.IOException;

public class Player extends GameObject {
    public Player(Game game) {
        super(game);

        this.keyboardMap = game.getKeyboardMap();
        this.spriteSheet = Player.createSpriteSheet(this);
        this.coordsManager = Player.createCoordsManager(this);
    }

    public Player(Game game, CartesianCoords initialCoords) {
        super(game, initialCoords);

        this.keyboardMap = game.getKeyboardMap();
        this.coordsManager = new CoordsManager(this, initialCoords);
    }

    int getSpeed() {
        return 2;
    }

    public IsometricCoords getCoords() {
        return this.coordsManager.getCoords();
    }

    public RealDimension getRealDimension() {
        return new RealDimension(299, 240);
    }

    public VirtualDimension getVirtualDimension() {
        return new VirtualDimension(64, 64, 64);
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

    private static SpriteSheet createSpriteSheet(Player player) {
        try {
            return new SpriteSheet(player);
        } catch (IOException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

    private static CoordsManager createCoordsManager(Player player) {
        return new CoordsManager(player);
    }

    private KeyboardMap keyboardMap;
    private CoordsManager coordsManager;
    private SpriteSheet spriteSheet;
}
