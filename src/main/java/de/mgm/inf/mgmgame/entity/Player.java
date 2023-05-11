package de.mgm.inf.mgmgame.entity;

import de.mgm.inf.mgmgame.GamePanel;
import de.mgm.inf.mgmgame.ImageUtils;
import de.mgm.inf.mgmgame.KeyMap;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyMap keyMap;

    public Player(GamePanel gamePanel, KeyMap keyMap){
        this.gamePanel = gamePanel;
        this.keyMap = keyMap;
        this.setDefaultValues();
    }

    public void setDefaultValues(){
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        direction = "down";
    }

    public void update(){
        if (KeyMap.isPressed(KeyEvent.VK_S)){
            this.y += speed;
            this.direction = "down";
        } else if (KeyMap.isPressed(KeyEvent.VK_A)){
            this.x -= speed;
            this.direction = "left";
        } else if (KeyMap.isPressed(KeyEvent.VK_W)){
            this.y -= speed;
            this.direction = "up";
        } else if (KeyMap.isPressed(KeyEvent.VK_D)){
            this.x += speed;
            this.direction = "right";
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = ImageUtils.load("images/player/CJ_%s.png".formatted(direction));
        g2.drawImage(image, x, y, (int) (gamePanel.getScale() * image.getWidth()), (int) (gamePanel.getScale() * image.getHeight()), null);
    }
}
