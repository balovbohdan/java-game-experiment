package gameObjectsSystem.gameObjects.player;

import lib.coords.Coords;
import lib.coords.CartesianCoords;
import lib.eventsManagers.keyboard.KeyboardMap;

class CoordsManager {
    CoordsManager(Player player) {
        this.player = player;
        this.keyboardMap = player.getKeyboardMap();
    }

    Coords getCoords() {
        return this.coords.toIsometric();
    }

    void updateCoords() {
        this.resetDirectionVectors();
        this.updateDirectionVectors();

        this.updateXCoord();
        this.updateYCoord();
    }

    private void updateDirectionVectors() {
        if (this.needMoveToNorth())
            this.dy = -1;
        else if (this.needMoveToSouth())
            this.dy = 1;

        if (this.needMoveToWest())
            this.dx = -1;
        else if (this.needMoveToEast())
            this.dx = 1;
    }

    private void resetDirectionVectors() {
        this.dx = 0;
        this.dy = 0;
    }

    private Boolean needMoveToNorth() {
        return this.keyboardMap.is_w();
    }

    private Boolean needMoveToSouth() {
        return this.keyboardMap.is_s();
    }

    private Boolean needMoveToWest() {
        return this.keyboardMap.is_a();
    }

    private Boolean needMoveToEast() {
        return this.keyboardMap.is_d();
    }

    private void updateXCoord() {
        double playerSpeed = this.getPlayerSpeed();

        this.coords.updateX(this.dx, playerSpeed);
    }

    private void updateYCoord() {
        double playerSpeed = this.getPlayerSpeed();

        this.coords.updateY(this.dy, playerSpeed);
    }

    private double getPlayerSpeed() {
        return this.player.getSpeed();
    }

    private Player player;
    private KeyboardMap keyboardMap;

    private double dx = 0;
    private double dy = 0;

    private CartesianCoords coords = new CartesianCoords(0, 0);
}
