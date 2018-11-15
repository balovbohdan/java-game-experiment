package window;

import javax.swing.JFrame;
import java.util.ArrayList;

public class Window {
    public Window() {
        this.jframe = Window.createJFrame();
    }

    public void show() {
        this.jframe.setVisible(true);
    }

    public void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    private static JFrame createJFrame() {
        JFrame jframe = new JFrame();
        Canvas canvas = new Canvas(jframe);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);

        jframe.setResizable(false);
//        jframe.setUndecorated(true);

        jframe.add(canvas);

        return jframe;
    }

    private JFrame jframe;
    private ArrayList<GameObject> gameObjects = new ArrayList<>();
}
