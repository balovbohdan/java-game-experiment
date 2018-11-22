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
        int colsQty = this.params.getColsQty();
        int itemWidth = this.params.getItemWidth();

        int x = id % colsQty * itemWidth;
        int y = id / colsQty;

        return this.getSubimage(x, y);
    }

    private Image getSubimage(int x, int y) {
        int width = this.params.getItemWidth();
        int height = this.params.getItemHeight();

        return this.image.getSubimage(x, y, width, height);
    }

    private static BufferedImage loadImage(String src) throws IOException {
        File file = new File(src);

        return ImageIO.read(file);
    }

    private Params params;
    private BufferedImage image;
}
