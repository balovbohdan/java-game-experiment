package gameObjectsSystem.gameObjects.map.gameObjectsFactory.gameObjectFactory;

import gameObjectsSystem.GameObject;
import gameObjectsSystem.gameObjects.TileDimension;
import lib.coords.IsometricCoords;

import java.awt.*;

class InitialCoordsCalculator {
    static IsometricCoords calc(GameObject gameObject, GameObject prevGameObject) {
        InitialCoordsCalculator calculator = new InitialCoordsCalculator(gameObject, prevGameObject);

        return calculator.calc();
    }

    private InitialCoordsCalculator(GameObject gameObject, GameObject prevGameObject) {
        Point initialTilePosition = gameObject.getInitialTilePosition();

        this.row = initialTilePosition.y;
        this.col = initialTilePosition.x;

        this.gameObject = gameObject;
        this.prevGameObject = prevGameObject;

        this.extraXOffset = this.calcExtraXOffset();
    }

    private IsometricCoords calc() {
        return this.prevGameObject == null
            ? this.calcIfFirstGameObject()
            : this.calcIfNotFirstGameObject();
    }

    private IsometricCoords calcIfFirstGameObject() {
        return new IsometricCoords(this.extraXOffset, 0);
    }

    private IsometricCoords calcIfNotFirstGameObject() {
        Point chainingOffsets = this.gameObject.getChainingOffsets();

        double xOffset = chainingOffsets.getX();
        double yOffset = chainingOffsets.getY();

        int x = (int) Math.round((TileDimension.WIDTH + xOffset) * this.col + this.extraXOffset);
        int y = (int) Math.round((TileDimension.HEIGHT + yOffset) * this.row);

        return new IsometricCoords(x, y);
    }

    /**
     * Extra 'X' offset is needed to 'close'
     * empty space between isometric tiles.
     */
    private int calcExtraXOffset() {
        return this.row % 2 == 0
            ? -TileDimension.WIDTH / 2
            : 0;
    }

    private int row;
    private int col;

    private int extraXOffset;

    private GameObject gameObject;
    private GameObject prevGameObject;
}
