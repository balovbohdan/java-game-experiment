package gameObjectsSystem.gameObjects.map.gameObjectsFactory.gameObjectFactory;

import gameObjectsSystem.GameObject;
import lib.coords.CartesianCoords;
import lib.gameObjectDimensions.RealDimension;
import lib.gameObjectPosition.offsets.RealChainingOffsets;
import lib.gameObjectPosition.offsets.RealOffsets;

class InitialCoordsCalculator {
    static CartesianCoords calc(GameObject gameObject, RealOffsets offsets, GameObject leftSibling, GameObject topSibling) {
        InitialCoordsCalculator calculator = new InitialCoordsCalculator(gameObject, offsets, leftSibling, topSibling);

        return calculator.calc();
    }

    private InitialCoordsCalculator(GameObject gameObject, RealOffsets offsets, GameObject leftSibling, GameObject topSobling) {
        this.gameObject = gameObject;
        this.offsets = offsets;
        this.leftSibling = leftSibling;
        this.topSibling = topSobling;
    }

    private CartesianCoords calc() {
        CartesianCoords coords = this.calcCoords();

        coords.addOffsets(this.offsets);

        return this.addChainingOffsets(coords);
    }

    private CartesianCoords addChainingOffsets(CartesianCoords coords) {
        RealChainingOffsets chainingOffsets = this.gameObject.getChainingOffsets();

        coords.addOffsets(chainingOffsets);

        return coords;
    }

    private CartesianCoords calcCoords() {
        int x = (int) this.calcX();
        int y = (int) this.calcY();

        return new CartesianCoords(x, y);
    }

    private double calcX() {
        if (this.leftSibling == null)
            return 0;

        RealDimension dimension = this.leftSibling.getRealDimension();

        int x = this.leftSibling
            .getCoords()
            .toCartesian()
            .getX();

        double width = dimension.getWidth();

        return width + x;
    }

    private double calcY() {
        if (this.topSibling == null)
            return 0;

        RealDimension dimension = this.topSibling.getRealDimension();

        int y = this.topSibling
            .getCoords()
            .toCartesian()
            .getY();

        double height = dimension.getHeight();

        return height + y;
    }

    private GameObject leftSibling;
    private GameObject topSibling;

    private GameObject gameObject;
    private RealOffsets offsets;
}
