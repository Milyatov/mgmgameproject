package de.mgm.inf.mgmgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyMap extends KeyAdapter {

    static final boolean[] keys = new boolean[Short.MAX_VALUE];

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public static boolean isPressed(int code) {
        return keys[code];
    }
}
