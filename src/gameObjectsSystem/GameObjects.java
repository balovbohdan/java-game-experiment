package gameObjectsSystem;

import java.awt.*;
import java.util.ArrayList;

public class GameObjects {
    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

//    public void add(GameObjects gameObjects) {
//        ArrayList<GameObject> gameObjectsRaw = gameObjects.getGameObjects();
//
//        this.gameObjects.addAll(gameObjectsRaw);
//    }

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