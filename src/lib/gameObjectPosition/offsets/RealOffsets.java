package lib.gameObjectPosition.offsets;

/**
 * Offsets based on "real" game object's dimension.
 * Real dimension represents sizes of game object's tile bounding rect.
 */
public class RealOffsets extends Offsets {
    public RealOffsets(int x, int y) {
        super(x, y);
    }
}