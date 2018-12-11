package lib.map;

import gameObjectsSystem.MapPoint;

import java.awt.*;

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

    public Point getOffsets() {
        return this.offsets;
    }

    public void setOffsets(Point offsets) {
        this.offsets = offsets;
    }

    private String name;
    private MapPoint mapPoint;

    private Point offsets = new Point(0, 0);
}
