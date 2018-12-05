package lib.map;

import gameObjectsSystem.MapPoint;

public class ConfigItem {
    public ConfigItem(MapPoint mapPoint, String name) {
        this.mapPoint = mapPoint;
        this.name = name;
    }

    public MapPoint getMapPoint() {
        return this.mapPoint;
    }

    public String getName() {
        return this.name;
    }

    private String name;
    private MapPoint mapPoint;
}
