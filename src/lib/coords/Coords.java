package lib.coords;

import java.awt.*;

public class Coords {
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void updateX(double dx, double speed) {
        this.x += dx * speed;
    }

    public void updateY(double dy, double speed) {
        this.y += dy * speed;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void addOffsets(Point offset) {
        this.x += offset.getX();
        this.y += offset.getY();
    }

    public IsometricCoords toIsometric() {
        int x = this.x - this.y;
        int y = (this.x + this.y) / 2;

        return new IsometricCoords(x, y);
    }

    public CartesianCoords toCartesian() {
        int doubleY = 2 * this.y;

        int x = (doubleY + this.x) / 2;
        int y = (doubleY - this.x) / 2;

        return new CartesianCoords(x, y);
    }

    private int x;
    private int y;
}
