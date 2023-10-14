package edu.square.utils.UIUtils;
import java.awt.event.*;
public class KeyManager implements KeyListener{
    private boolean[] keys;

    public KeyManager() {
        keys = new boolean[256];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public boolean KeyPressed(int keycode) {
        return keys[keycode];

    }

    public boolean KeyReleased(int keycode) {
        return keys[keycode];
    }

    public boolean getkeyvalue(int e){
        return keys[e];
    }
}
