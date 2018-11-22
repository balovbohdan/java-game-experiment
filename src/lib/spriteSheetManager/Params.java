package lib.spriteSheetManager;

public abstract class Params {
    public abstract int getColsQty();
    public abstract int getRowsQty();

    public int getItemWidth() {
        return 240;
    }

    public int getItemHeight() {
        return 240;
    }
}
