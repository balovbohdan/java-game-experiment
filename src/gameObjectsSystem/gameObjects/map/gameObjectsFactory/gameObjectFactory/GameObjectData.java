package gameObjectsSystem.gameObjects.map.gameObjectsFactory.gameObjectFactory;

import game.Game;
import gameObjectsSystem.GameObject;
import gameObjectsSystem.MapPoint;
import lib.gameObjectPosition.offsets.RealOffsets;

public class GameObjectData {
    public Game game;
    public String name;
    public MapPoint mapPoint;
    public GameObject leftSibling;
    public GameObject topSibling;
    public RealOffsets offsets;
}
