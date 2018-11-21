package game.window;

import lib.eventsManagers.keyboard.KeyboardEventsManager;
import lib.eventsManagers.keyboard.KeyboardMap;

import javax.swing.JFrame;

public class Window extends JFrame {
    Window() {
        this.init();
    }

    public KeyboardMap getKeyboardMap() {
        return this.keyboardEventsManager.getKeyboardMap();
    }

    private void init() {
        this.addKeyListener(this.keyboardEventsManager);
    }

    private KeyboardEventsManager keyboardEventsManager = new KeyboardEventsManager();
}