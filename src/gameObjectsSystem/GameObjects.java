package gameObjectsSystem;

import java.util.ArrayList;
import java.util.function.Function;

public class GameObjects {
    public void forEach(Function<GameObject, Boolean> callback) {
        for (GameObject gameObject : this.gameObjects)
            callback.apply(gameObject);
    }

    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void add(GameObjects gameObjects) {
        ArrayList<GameObject> gameObjectsRaw = gameObjects.getGameObjects();

        this.gameObjects.addAll(gameObjectsRaw);
    }

    public void update() {
        for (GameObject gameObject : this.gameObjects)
            gameObject.update();
    }

    private ArrayList<GameObject> getGameObjects() {
        return this.gameObjects;
    }

    private ArrayList<GameObject> gameObjects = new ArrayList<>();
}