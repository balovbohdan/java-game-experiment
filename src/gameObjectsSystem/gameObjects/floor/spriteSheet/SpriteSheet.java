package gameObjectsSystem.gameObjects.floor.spriteSheet;

import gameObjectsSystem.gameObjects.floor.Floor;
import lib.dimensions.RealDimension;
import lib.spriteSheetManager.SpriteSheetManager;

import java.awt.*;
import java.io.IOException;

public class SpriteSheet {
    public SpriteSheet(Floor floor) throws IOException {
        this.manager = SpriteSheet.createManager(floor);
    }

    public Image getItem() {
        return this.manager.getItem(0);
    }

    private static SpriteSheetManager createManager(Floor floor) throws IOException {
        String src = SpriteSheet.getSrc();
        Params params = SpriteSheet.createParams(floor);

        return new SpriteSheetManager(src, params);
    }

    private static String getSrc() {
        return "assets/images/sprite-sheets/floors/floor.png";
    }

    private static Params createParams(Floor floor) {
        RealDimension dimension = floor.getRealDimension();

        int width = dimension.getWidth();
        int height = dimension.getHeight();

        return new Params(width, height);
    }

    private SpriteSheetManager manager;
}
