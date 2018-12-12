package gameObjectsSystem.gameObjects.grass.spriteSheet;

import gameObjectsSystem.gameObjects.grass.Grass;
import lib.spriteSheetManager.SpriteSheetManager;

import java.awt.*;
import java.io.IOException;

public class SpriteSheet {
    public SpriteSheet(Grass grass) throws IOException {
        this.manager = SpriteSheet.createManager(grass);
    }

    public Image getItem() {
        return this.manager.getItem(0);
    }

    private static SpriteSheetManager createManager(Grass grass) throws IOException {
        String src = SpriteSheet.getSrc();
        Params params = SpriteSheet.createParams(grass);

        return new SpriteSheetManager(src, params);
    }

    private static String getSrc() {
        return "assets/images/sprite-sheets/grass/grass.png";
    }

    private static Params createParams(Grass grass) {
        Dimension dimension = grass.getRealDimension();

        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        return new Params(width, height);
    }

    private SpriteSheetManager manager;
}
