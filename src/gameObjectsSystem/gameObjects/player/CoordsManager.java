package gameObjectsSystem.gameObjects.player;

import lib.BoundingRect;
import lib.coords.CartesianCoords;
import lib.coords.IsometricCoords;
import lib.eventsManagers.keyboard.KeyboardMap;

class CoordsManager {
    CoordsManager(Player player) {
        this.player = player;
        this.keyboardMap = player.getKeyboardMap();
        this.coords = new CartesianCoords(0, 0);
    }

    CoordsManager(Player player, CartesianCoords initialCoords){
        this.player = player;
        this.keyboardMap = player.getKeyboardMap();
        this.coords = initialCoords;
    }

    IsometricCoords getCoords() {
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
        return this.keyboardMap.is_w()
            && !this.isAtTopBorder()
            && !this.isAtRightBorder();
    }

    private Boolean needMoveToSouth() {
        return this.keyboardMap.is_s()
            && !this.isAtBottomBorder()
            && !this.isAtLeftBorder();
    }

    private Boolean needMoveToWest() {
        return this.keyboardMap.is_a()
            && !this.isAtTopBorder()
            && !this.isAtLeftBorder();
    }

    private Boolean needMoveToEast() {
        return this.keyboardMap.is_d()
            && !this.isAtRightBorder()
            && !this.isAtBottomBorder();
    }

    private Boolean isAtTopBorder() {
        BoundingRect boundingRect = this.getPlayerBoundingRect();

        int top = boundingRect.getTop();

        return top <= 0;
    }

    private Boolean isAtBottomBorder() {
        BoundingRect boundingRect = this.getPlayerBoundingRect();

        int bottom = boundingRect.getBottom();

        return bottom <= 0;
    }

    private Boolean isAtLeftBorder() {
        BoundingRect boundingRect = this.getPlayerBoundingRect();

        int left = boundingRect.getLeft();

        return left <= 0;
    }

    private Boolean isAtRightBorder() {
        BoundingRect boundingRect = this.getPlayerBoundingRect();

        int right = boundingRect.getRight();

        return right <= 0;
    }

    private void updateXCoord() {
        double playerSpeed = this.getPlayerSpeed();

        this.coords.updateX(this.dx, playerSpeed);
    }

    private void updateYCoord() {
        double playerSpeed = this.getPlayerSpeed();

        this.coords.updateY(this.dy, playerSpeed);
    }

    private BoundingRect getPlayerBoundingRect() {
        return this.player.getBoundingRect();
    }

    private double getPlayerSpeed() {
        return this.player.getSpeed();
    }

    private Player player;
    private KeyboardMap keyboardMap;

    private double dx = 0;
    private double dy = 0;

    private CartesianCoords coords;
}
