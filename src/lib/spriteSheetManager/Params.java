package lib.spriteSheetManager;

public abstract class Params {
    public Params(int width, int height, int colsQty) {
        this.width = width;
        this.height = height;
        this.colsQty = colsQty;
    }

    int getColsQty() {
        return this.colsQty;
    }

    int getItemWidth() {
        return this.width;
    }

    int getItemHeight() {
        return this.height;
    }

    private int width;
    private int height;

    private int colsQty;
}
