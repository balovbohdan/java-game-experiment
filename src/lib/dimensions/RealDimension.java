package lib.dimensions;

/**
 * Real dimension represents sizes of game object's tile bounding rect.
 */
public class RealDimension {
    public RealDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int width;
    public int height;
}
