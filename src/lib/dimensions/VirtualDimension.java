package lib.dimensions;

/**
 * Virtual dimension represents sizes of game object at pseudo-3d game world.
 */
public class VirtualDimension {
    public VirtualDimension(int width, int length, int height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }

    public int getHeight() {
        return this.height;
    }

    public int width;
    public int length;
    public int height;
}
