package gameObjectsSystem.gameObjects.map;

import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.GameObjects;
import gameObjectsSystem.gameObjects.grass.Grass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

class GameObjectsFactory {
    static GameObjects create(Game game) {
        GameObjects gameObjects = new GameObjects();

        ArrayList<String> gameObjectsNames = GameObjectsFactory.fetchGameObjectsNames();

        for (String gameObjectName : gameObjectsNames) {
            try {
                GameObject gameObject = GameObjectsFactory.findGameObject(game, gameObjectName);

                gameObjects.add(gameObject);
            } catch (Exception exception) {
                System.out.println("Failed to look for game object.");
                System.out.println(exception.getMessage());
            }
        }

        return gameObjects;
    }

    private static GameObject findGameObject(Game game, String name) throws Exception {
        String packageName = name.toLowerCase();
        String className = "gameObjectsSystem.gameObjects." + packageName + "." + name;

        Class<?> clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor(game.getClass());
        Object ob = constructor.newInstance(game);

        return (GameObject) ob;
    }

    private static ArrayList<String> fetchGameObjectsNames() {
        try {
            String configSrc = GameObjectsFactory.getConfigSrc();
            File file = new File(configSrc);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<String> content = new ArrayList<>();

            String line;

            while ((line = bufferedReader.readLine()) != null)
                content.add(line);

            return content;
        } catch (IOException exception) {
            return new ArrayList<>();
        }
    }

    private static String getConfigSrc() {
        return "assets/configs/maps/def.map";
    }
}
