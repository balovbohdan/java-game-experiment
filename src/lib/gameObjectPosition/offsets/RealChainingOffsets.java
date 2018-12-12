package lib.gameObjectPosition.offsets;

/**
 * Chaining offsets helps to find so called "chaining point".
 * Chaining point is:
 * 1) top-left tile corner at cartesian coordinates system;
 * 2) top-center tile corner at isometric coordinates system.
 *
 * Do notice!
 * This chaining offsets class based on "real" dimension of game object.
 * You can find details at superclass.
 */
public class RealChainingOffsets extends RealOffsets {
    public RealChainingOffsets(int x, int y) {
        super(x, y);
    }
}
