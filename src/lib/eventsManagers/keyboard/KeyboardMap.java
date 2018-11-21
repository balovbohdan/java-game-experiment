package lib.eventsManagers.keyboard;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyboardMap {
    public Boolean is_w() {
        return this.isKeyActive(KeyEvent.VK_W);
    }

    public Boolean is_s() {
        return this.isKeyActive(KeyEvent.VK_S);
    }

    public Boolean is_a() {
        return this.isKeyActive(KeyEvent.VK_A);
    }

    public Boolean is_d() {
        return this.isKeyActive(KeyEvent.VK_D);
    }

    void activateKey(int keyCode) {
        String keyCodeConverted = KeyboardMap.convertKeyCode(keyCode);

        this.map.put(keyCodeConverted, true);
    }

    void deactivateKey(int keyCode) {
        String keyCodeConverted = KeyboardMap.convertKeyCode(keyCode);

        this.map.remove(keyCodeConverted);
    }

    private Boolean isKeyActive(int keyCode) {
        String keyCodeConverted = KeyboardMap.convertKeyCode(keyCode);

        return this.map.containsKey(keyCodeConverted);
    }

    private static String convertKeyCode(int keyCode) {
        return Integer.toString(keyCode);
    }

    private HashMap<String, Boolean> map = new HashMap<>();
}