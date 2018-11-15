package window;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    Canvas(JFrame jframe) {
        this.jframe = jframe;
    }

    public void paint(Graphics graphics) {
        int frameWidth = this.getFrameWidth();
        int frameHeight = this.getFrameHeight();

        graphics.drawRect(0, 0, frameWidth, frameHeight);
    }

    private int getFrameWidth() {
        return this.jframe.getWidth();
    }

    private int getFrameHeight() {
        return this.jframe.getHeight();
    }

    private JFrame jframe;
}
