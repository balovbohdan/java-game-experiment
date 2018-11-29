package gameObjectsSystem;

import java.awt.*;
import java.util.ArrayList;

public class GameObjects {
    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
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

    private ArrayList<GameObject> gameObjects = new ArrayList<>();
}