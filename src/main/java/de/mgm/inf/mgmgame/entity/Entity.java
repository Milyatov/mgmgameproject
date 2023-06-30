package de.mgm.inf.mgmgame.entity;

import de.mgm.inf.mgmgame.GameObject;

import java.awt.*;
import java.util.HashMap;

public class Entity extends GameObject {

    int speed;
    Dimension hitbox;

    protected HashMap<String, State> states = new HashMap<>();

    State currentState;

    public Dimension getHitbox(){
        return this.hitbox;
    }
}
