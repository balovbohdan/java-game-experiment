package gameObjectsSystem;

public class MapPoint {
    public MapPoint(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    private int row;
    private int col;
}
