package lib.eventsManagers.keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardEventsManager extends KeyAdapter {
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        this.activateKey(keyCode);
    }

    public void keyReleased(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        this.deactivateKey(keyCode);
    }

    public KeyboardMap getKeyboardMap() {
        return this.keyboardMap;
    }

    private void activateKey(int keyCode) {
        this.keyboardMap.activateKey(keyCode);
    }

    private void deactivateKey(int keyCode) {
        this.keyboardMap.deactivateKey(keyCode);
    }

    private KeyboardMap keyboardMap = new KeyboardMap();
}
