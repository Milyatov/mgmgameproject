package de.mgm.inf.mgmgame.entity;

import de.mgm.inf.mgmgame.GamePanel;
import de.mgm.inf.mgmgame.KeyMap;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyMap keyMap;
    int counter = 0;
    String path = "images/player/CJ_";
    public final int screenX;
    public final int screenY;


    public Player(GamePanel gamePanel, KeyMap keyMap){
        this.gamePanel = gamePanel;
        this.keyMap = keyMap;
        this.screenX = (int) (GamePanel.getScreenResolution().getWidth() / 2)-30;
        this.screenY = (int) (GamePanel.getScreenResolution().getHeight() / 2)-48;

        this.setDefaultValues();

        this.states.put("down", new State(path, 8, "down", ""));
        this.states.put("up", new State(path, 8, "up", ""));
        this.states.put("left", new State(path, 8, "left", ""));
        this.states.put("right", new State(path, 8, "right", ""));
        this.states.put("down_idle", new State(path, 10, "down", "idle_"));
        this.states.put("up_idle", new State(path, 10, "up", "idle_"));
        this.states.put("left_idle", new State(path, 10, "left", "idle_"));
        this.states.put("right_idle", new State(path, 10, "right", "idle_"));

        this.currentState = this.states.get("down");
    }

    public void setDefaultValues(){
        this.setWorldX((int) (GamePanel.getScreenResolution().getWidth() / 2) - 50);
        this.setWorldY((int) (GamePanel.getScreenResolution().getHeight() / 2) - 70);
        this.speed = 7;
        this.hitbox = new Dimension(20, 40);
        this.currentState = states.get("down_idle");
    }

    public void update(){
        if (KeyMap.isPressed(KeyEvent.VK_S)){
            this.setWorldY(this.getWorldY() + speed);
            this.currentState = states.get("down");
        } else if (KeyMap.isPressed(KeyEvent.VK_A)){
            this.setWorldX(this.getWorldX() - speed);
            this.currentState = states.get("left");
        } else if (KeyMap.isPressed(KeyEvent.VK_W)){
            this.setWorldY(this.getWorldY() - speed);
            this.currentState = states.get("up");
        } else if (KeyMap.isPressed(KeyEvent.VK_D)){
            this.setWorldX(getWorldX() + speed);
            this.currentState = states.get("right");
        } else {
            this.currentState = states.get(this.currentState.getDirection()+ "_idle");
        }


        counter++;
        if (counter % 5 == 0){
            this.currentState.currentSpriteNumber = (this.currentState.currentSpriteNumber + 1) % this.currentState.getSpritesNumber();
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = this.currentState.getCurrentSprite();
        g2.drawImage(image, screenX, screenY, (int) (GamePanel.getScale() * image.getWidth()), (int) (GamePanel.getScale() * image.getHeight()), null);
    }
}
