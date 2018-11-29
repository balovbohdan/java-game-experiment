package gameObjectsSystem.gameObjects.player.spriteSheet;

import gameObjectsSystem.gameObjects.player.Player;
import lib.spriteSheetManager.SpriteSheetManager;

import java.awt.*;
import java.io.IOException;

public class SpriteSheet {
    public SpriteSheet(Player player) throws IOException {
        this.manager = SpriteSheet.createManager(player);
    }

    public Image getItem() {
        return this.manager.getItem(0);
    }

    private static SpriteSheetManager createManager(Player player) throws IOException {
        String src = SpriteSheet.getSrc();
        Params params = SpriteSheet.createParams(player);

        return new SpriteSheetManager(src, params);
    }

    private static String getSrc() {
        return "assets/images/sprite-sheets/crusader/walk.png";
    }

    private static Params createParams(Player player) {
        Dimension dimension = player.getDimension();

        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        return new Params(width, height);
    }

    private SpriteSheetManager manager;
}
