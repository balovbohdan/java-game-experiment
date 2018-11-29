package lib.spriteSheetManager;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheetManager {
    public SpriteSheetManager(String src, Params params) throws IOException {
        this.params = params;
        this.image = SpriteSheetManager.loadImage(src);
    }

    public Image getItem(int id) {
        int itemWidth = this.getItemWidth();
        int itemHeight = this.getItemHeight();

        int x = this.calcItemXCoord(id);
        int y = this.calcItemYCoord(id);

        return this.getSubimage(x, y, itemWidth, itemHeight);
    }

    private Image getSubimage(int x, int y, int width, int height) {
        return this.image.getSubimage(x, y, width, height);
    }

    private int calcItemXCoord(int itemId) {
        int colsQty = this.getColsQty();
        int itemWidth = this.getItemWidth();

        return itemId % colsQty * itemWidth;
    }

    private int calcItemYCoord(int itemId) {
        int colsQty = this.getColsQty();

        return itemId / colsQty;
    }

    private int getColsQty() {
        return this.params.getColsQty();
    }

    private int getItemWidth() {
        return this.params.getItemWidth();
    }

    private int getItemHeight() {
        return this.params.getItemHeight();
    }

    private static BufferedImage loadImage(String src) throws IOException {
        File file = new File(src);

        return ImageIO.read(file);
    }

    private Params params;
    private BufferedImage image;
}
