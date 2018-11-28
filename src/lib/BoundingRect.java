package lib;

import lib.coords.CartesianCoords;
import lib.coords.IsometricCoords;

import java.awt.*;
import javax.swing.*;

public class BoundingRect {
    public BoundingRect(IsometricCoords coords, Dimension dimension, JFrame jframe) {
        this.jframe = jframe;
        this.dimension = dimension;
        this.coords = coords;
    }

    public int getTop() {
        return this.coords.getY();
    }

    public int getLeft() {
        return this.coords.getX();
    }

    public int getRight() {
        int rectLeft = this.getLeft();
        int rectWidth = this.getWidth();
        int jframeWidth = this.getJFrameWidth();

        return jframeWidth - rectLeft - rectWidth;
    }

    public int getBottom() {
        int rectTop = this.getTop();
        int rectHeight = this.getHeight();
        int jframeHeight = this.getJFrameHeight();

        return jframeHeight - rectTop - rectHeight;
    }

    public int getWidth() {
        return (int) this.dimension.getWidth();
    }

    public int getHeight() {
        return (int) this.dimension.getHeight();
    }

    private int getJFrameWidth() {
        return this.jframe.getWidth();
    }

    private int getJFrameHeight() {
        return this.jframe.getHeight();
    }

    private IsometricCoords coords;
    private JFrame jframe;
    private Dimension dimension;
}
