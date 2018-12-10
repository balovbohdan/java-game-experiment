package gameObjectsSystem.gameObjects.map.gameObjectsFactory.gameObjectFactory;

import gameObjectsSystem.GameObject;
import lib.coords.CartesianCoords;

import java.awt.*;

class InitialCoordsCalculator {
    static CartesianCoords calc(GameObject gameObject, GameObject leftSibling, GameObject topSibling) {
        InitialCoordsCalculator calculator = new InitialCoordsCalculator(gameObject, leftSibling, topSibling);

        return calculator.calc();
    }

    private InitialCoordsCalculator(GameObject gameObject, GameObject leftSibling, GameObject topSobling) {
        this.gameObject = gameObject;
        this.leftSibling = leftSibling;
        this.topSibling = topSobling;
    }

    private CartesianCoords calc() {
        return this.calcCoordsWithOffsets();
    }

    private CartesianCoords calcCoordsWithOffsets() {
        double x = this.calcX();
        double y = this.calcY();

        Point chainingOffsets = this.gameObject.getChainingOffsets();

        double xOffset = chainingOffsets.getX();
        double yOffset = chainingOffsets.getY();

        int xWithOffset = (int) Math.round(x + xOffset);
        int yWithOffset = (int) Math.round(y + yOffset);

        return new CartesianCoords(xWithOffset, yWithOffset);
    }

    private double calcX() {
        if (this.leftSibling == null)
            return 0;

        Dimension dimension = this.leftSibling.getDimension();

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

        Dimension dimension = this.topSibling.getDimension();

        int y = this.topSibling
            .getCoords()
            .toCartesian()
            .getY();

        double height = dimension.getHeight();

        return height + y;
    }

    private GameObject gameObject;
    private GameObject leftSibling;
    private GameObject topSibling;
}
