package de.mgm.inf.mgmgame.entity;

import java.util.HashMap;

public class Entity {

    int worldX, worldY, speed;

    protected HashMap<String, State> states = new HashMap<>();

    State currentState;

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }
}
