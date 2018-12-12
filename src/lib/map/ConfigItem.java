package lib.map;

import gameObjectsSystem.MapPoint;
import lib.gameObjectPosition.offsets.RealOffsets;

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

    public RealOffsets getOffsets() {
        return this.offsets;
    }

    public void setOffsets(RealOffsets offsets) {
        this.offsets = offsets;
    }

    private String name;
    private MapPoint mapPoint;

    private RealOffsets offsets = new RealOffsets(0, 0);
}
