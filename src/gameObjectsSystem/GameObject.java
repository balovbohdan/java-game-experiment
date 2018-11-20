package gameObjectsSystem;

import java.awt.Graphics;
import java.awt.Component;

public abstract class GameObject extends Component {
    public abstract void update();
    public abstract void render(Graphics graphics);
}