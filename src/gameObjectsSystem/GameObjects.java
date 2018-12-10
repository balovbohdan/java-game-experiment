package gameObjectsSystem;

import java.awt.*;
import java.util.ArrayList;

public class GameObjects {
    public static final int ROWS_QTY = 2;
    public static final int COLS_QTY = 20;

    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public GameObject getLeftSibling(MapPoint mapPoint) {
        int col = mapPoint.getCol();

        if (col == 0)
            return null;

        int siblingRow = mapPoint.getRow();
        int siblingCol = col - 1;

        MapPoint siblingMapPoint = new MapPoint(siblingRow, siblingCol);

        return this.get(siblingMapPoint);
    }

    public GameObject getTopSibling(MapPoint mapPoint) {
        int row = mapPoint.getRow();

        if (row == 0)
            return null;

        int siblingRow = row - 1;
        int siblingCol = mapPoint.getCol();

        MapPoint siblingMapPoint = new MapPoint(siblingRow, siblingCol);

        return this.get(siblingMapPoint);
    }

    public GameObject get(MapPoint mapPoint) {
        int index = GameObjects.mapPointToIndex(mapPoint);

        return this.get(index);
    }

    public GameObject get(int index) {
        return this.gameObjects.get(index);
    }

    public GameObject getLast() {
        int gameObjectsQty = this.gameObjects.size();

        if (gameObjectsQty == 0)
            return null;

        int lastIndex = gameObjectsQty - 1;

        return this.gameObjects.get(lastIndex);
    }

    public void update() {
        for (GameObject gameObject : this.gameObjects)
            gameObject.update();
    }

    public void render(Graphics graphics) {
        for (GameObject gameObject : this.gameObjects)
            gameObject.render(graphics);
    }

    private static int mapPointToIndex(MapPoint mapPoint) {
        int row = mapPoint.getRow();
        int col = mapPoint.getCol();

        return GameObjects.COLS_QTY * row + col;
    }

    private ArrayList<GameObject> gameObjects = new ArrayList<>();
}