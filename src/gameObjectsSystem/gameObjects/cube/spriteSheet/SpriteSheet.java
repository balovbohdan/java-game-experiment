package gameObjectsSystem.gameObjects.cube.spriteSheet;

import gameObjectsSystem.gameObjects.cube.Cube;
import lib.gameObjectDimensions.RealDimension;
import lib.spriteSheetManager.SpriteSheetManager;

import java.awt.*;
import java.io.IOException;

public class SpriteSheet {
    public SpriteSheet(Cube cube) throws IOException {
        this.manager = SpriteSheet.createManager(cube);
    }

    public Image getItem() {
        return this.manager.getItem(0);
    }

    private static SpriteSheetManager createManager(Cube cube) throws IOException {
        String src = SpriteSheet.getSrc();
        Params params = SpriteSheet.createParams(cube);

        return new SpriteSheetManager(src, params);
    }

    private static String getSrc() {
        return "assets/images/sprite-sheets/cubes/cube.png";
    }

    private static Params createParams(Cube cube) {
        RealDimension dimension = cube.getRealDimension();

        int width = dimension.getWidth();
        int height = dimension.getHeight();

        return new Params(width, height);
    }

    private SpriteSheetManager manager;
}
