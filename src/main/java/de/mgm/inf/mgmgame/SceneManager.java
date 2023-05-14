package de.mgm.inf.mgmgame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SceneManager {
    private static final String path = "images/maps/level_";

    public SceneManager() {

    }

    public BufferedImage getImage(String path) {
        return ImageUtils.load(path);
    }

    public void draw(Graphics2D g2, int activeLevel, int x, int y){
        g2.drawImage(getImage(path + activeLevel + ".png"),
                GamePanel.getOffset().width - x,
                GamePanel.getOffset().height - y,
                GamePanel.SCALED_WIDTH,
                GamePanel.SCALED_HEIGHT,
                null);
    }
}
