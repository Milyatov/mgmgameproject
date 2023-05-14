package de.mgm.inf.mgmgame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Function;

public class SceneManager {
    private static final String path = "images/maps/level_";
    private int activeLevel = 0;
    private BufferedImage image;

    private final Function<BufferedImage, Double> widthCoefficient = (i) -> i.getWidth() * 1.0 / GamePanel.getResourceDimension().width;
    private final Function<BufferedImage, Double> heightCoefficient = (i) -> i.getHeight() * 1.0 / GamePanel.getResourceDimension().height;

    public SceneManager() {}

    public BufferedImage getImage(String path) {
        return ImageUtils.load(path);
    }

    public void changeLevel(int level) {
        this.activeLevel = level;
        image = getImage(path + activeLevel + ".png");
        final double wc = widthCoefficient.apply(image) / 50;
        final double hc = heightCoefficient.apply(image) / 50;
        GamePanel.getInstance().player.setWorldX((int) (wc * GamePanel.getResourceDimension().width));
        GamePanel.getInstance().player.setWorldY((int) (hc * GamePanel.getResourceDimension().height));
    }

    public void draw(Graphics2D g2, int x, int y) {
        final double wc = widthCoefficient.apply(image);
        final double hc = heightCoefficient.apply(image);
        g2.drawImage(image,
                GamePanel.getOffset().width - x,
                GamePanel.getOffset().height - y,
                (int) (wc * GamePanel.SCALED_WIDTH),
                (int) (hc * GamePanel.SCALED_HEIGHT),
                null);
    }
}
