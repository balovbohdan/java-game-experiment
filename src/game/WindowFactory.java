package game;

import game.game.Game;
import javax.swing.JFrame;

public class WindowFactory {
    public static Window create(Game game) {
        WindowFactory windowFactory = new WindowFactory(game);

        return windowFactory.create();
    }

    private WindowFactory(Game game) {
        this.game = game;
    }

    private Window create() {
        Window window = WindowFactory.createWindow();

        Canvas canvas = this.createCanvas();

        window.add(canvas);

        return window;
    }

    private Canvas createCanvas() {
        return new Canvas(this.game);
    }

    private static Window createWindow() {
        Window window = new Window();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        window.setResizable(false);

        return window;
    }

    private Game game;
}