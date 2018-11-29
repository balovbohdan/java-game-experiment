package gameObjectsSystem.gameObjects.map;

import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.GameObjects;
import lib.coords.IsometricCoords;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;

class GameObjectsFactory {
    static GameObjects create(Game game) {
        GameObjectsFactory factory = new GameObjectsFactory(game);

        return factory.create();
    }

    private GameObjectsFactory(Game game) {
        this.game = game;
        this.gameObjects = new GameObjects();
        this.gameObjectsNames = GameObjectsFactory.fetchGameObjectsNames();;
    }

    private GameObjects create() {
        int rowsQty = this.getRowsQty();

        for (int row = 0; row < rowsQty; row++) {
            ArrayList<String> names = this.gameObjectsNames.get(row);

            int colsQty = names.size();

            for (int col = 0; col < colsQty; col++) {
                try {
                    String gameObjectName = this.gameObjectsNames.get(row).get(col);

                    GameObject gameObject = this.createGameObject(gameObjectName, row, col);

                    this.gameObjects.add(gameObject);
                } catch (Exception exception) {
                    System.out.println("Failed to look for game object.");
                    System.out.println(exception.getMessage());
                }
            }
        }

        return gameObjects;
    }

    private GameObject createGameObject(String name, int row, int col) throws Exception {
        String packageName = name.toLowerCase();
        String className = "gameObjectsSystem.gameObjects." + packageName + "." + name;

        GameObject prevGameObject = this.getPrevGameObject();

        IsometricCoords initialCoords = GameObjectsFactory.calcInitialCoords(prevGameObject, row, col);

        Class<?> clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor(this.game.getClass(), IsometricCoords.class);
        Object ob = constructor.newInstance(this.game, initialCoords);

        return (GameObject) ob;
    }

    private int getRowsQty() {
        return this.gameObjectsNames.size();
    }

    private GameObject getPrevGameObject() {
        return this.gameObjects.getLast();
    }

    private static IsometricCoords calcInitialCoords(GameObject prevGameObject, int row, int col) {
        int extraXOffset = row % 2 == 0
                ? -256 / 2
                : 0;

        if (prevGameObject == null)
            return new IsometricCoords(extraXOffset, 0);

        Point chainingOffsets = prevGameObject.getChainingOffsets();
        Dimension prevGameObjectDimension = prevGameObject.getDimension();

        double prevObjectWidth = prevGameObjectDimension.getWidth();
        double prevObjectHeight = prevGameObjectDimension.getHeight();

        double xOffset = chainingOffsets.getX();
        double yOffset = chainingOffsets.getY();

        int x = (int) Math.round((prevObjectWidth + xOffset) * col + extraXOffset);
        int y = (int) Math.round((prevObjectHeight + yOffset) * row);

        return new IsometricCoords(x, y);
    }

    private static ArrayList<ArrayList<String>> fetchGameObjectsNames() {
        try {
            String configSrc = GameObjectsFactory.getConfigSrc();
            File file = new File(configSrc);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder content = new StringBuilder();

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String linePrepared = line + "\r\n";

                content.append(linePrepared);
            }

            String lines[] = content.toString().split("\\r?\\n\\r?\\n");

            ArrayList<ArrayList<String>> names = new ArrayList<>();

            for (String item : lines) {
                String parts[] = item.split("\\r?\\n");
                ArrayList<String> partsPrepared = new ArrayList<>(Arrays.asList(parts));
                names.add(partsPrepared);
            }

            return names;
        } catch (IOException exception) {
            return new ArrayList<>();
        }
    }

    private static String getConfigSrc() {
        return "assets/configs/maps/def.map";
    }

    private Game game;
    private GameObjects gameObjects;
    private ArrayList<ArrayList<String>> gameObjectsNames;
}
