package gameObjectsSystem.gameObjects.map.gameObjectsFactory.gameObjectFactory;

import gameObjectsSystem.GameObject;
import gameObjectsSystem.MapPoint;
import lib.coords.IsometricCoords;

import java.awt.*;

class InitialCoordsCalculator {
    static IsometricCoords calc(GameObject gameObject, GameObject prevGameObject) {
        InitialCoordsCalculator calculator = new InitialCoordsCalculator(gameObject, prevGameObject);

        return calculator.calc();
    }

    private InitialCoordsCalculator(GameObject gameObject, GameObject prevGameObject) {
        this.gameObject = gameObject;
        this.prevGameObject = prevGameObject;
        this.initialMapPoint = gameObject.getInitialMapPoint();
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

        Dimension gameObjectDimension = this.gameObject.getDimension();

        int width = (int) gameObjectDimension.getWidth();
        int height = (int) gameObjectDimension.getHeight();

        int row = this.getRow();
        int col = this.getCol();

        int x = (int) Math.round((width + xOffset) * col + this.extraXOffset);
        int y = (int) Math.round((height + yOffset) * row);

        return new IsometricCoords(x, y);
    }

    /**
     * Extra 'X' offset is needed to 'close'
     * empty space between isometric tiles.
     */
    private int calcExtraXOffset() {
        Dimension gameObjectDimension = this.gameObject.getDimension();

        int width = (int) gameObjectDimension.getWidth();

        int row = this.getRow();

        return row % 2 == 0
            ? -width / 2
            : 0;
    }

    private int getRow() {
        return this.initialMapPoint.getRow();
    }

    private int getCol() {
        return this.initialMapPoint.getCol();
    }

    private int extraXOffset;

    private GameObject gameObject;
    private MapPoint initialMapPoint;
    private GameObject prevGameObject;
}
