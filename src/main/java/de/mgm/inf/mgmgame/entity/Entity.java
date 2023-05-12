package de.mgm.inf.mgmgame.entity;

import java.util.HashMap;

public class Entity {

    int x, y, speed;

    protected HashMap<String, State> states = new HashMap<>();

    State currentState;
}
