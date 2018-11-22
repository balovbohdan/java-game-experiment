package gameObjectsSystem.gameObjects.player.spriteSheet;

import lib.spriteSheetManager.SpriteSheetManager;

import java.awt.Image;
import java.io.IOException;

public class SpriteSheet {
    public SpriteSheet() throws IOException {

    }

    public Image getItem() {
        return this.manager.getItem(0);
    }

    private static SpriteSheetManager createManager() throws IOException {
        String src = SpriteSheet.getSrc();
        Params params = SpriteSheet.createParams();

        return new SpriteSheetManager(src, params);
    }

    private static String getSrc() {
        return "assets/images/sprite-sheets/crusader/walk.png";
    }

    private static Params createParams() {
        return new Params();
    }

    private SpriteSheetManager manager = SpriteSheet.createManager();
}