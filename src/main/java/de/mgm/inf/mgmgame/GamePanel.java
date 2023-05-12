package de.mgm.inf.mgmgame;

import de.mgm.inf.mgmgame.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{

    public GamePanel(){
        this.setSize(this.SCALED_WIDTH,this.SCALED_HEIGHT);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyMap);
        this.setFocusable(true);
    }

    KeyMap keyMap = new KeyMap();
    Player player = new Player(this, keyMap);
    boolean running = false;
    final int FPS = 60;
    Thread gameThread;

    Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension RESOURCE_DIMENSION = new Dimension(640,360);
    @SuppressWarnings("FieldCanBeLocal")
    private final double DEFAULT_ASPECT_RATIO = 16.0 / 9.0;
    private final double SCREEN_ASPECT_RATIO = this.screenResolution.getWidth() / this.screenResolution.getHeight();
    private final int SCALED_WIDTH = (int) (this.getScale() * this.RESOURCE_DIMENSION.getWidth());
    private final int SCALED_HEIGHT = (int) (this.getScale() * this.RESOURCE_DIMENSION.getHeight());

    public double getScale() {
        if (this.SCREEN_ASPECT_RATIO < this.DEFAULT_ASPECT_RATIO){
            return this.screenResolution.getWidth()/ this.RESOURCE_DIMENSION.getWidth();
        } else {
            return this.screenResolution.getHeight()/ this.RESOURCE_DIMENSION.getHeight();
        }
    }

    public Dimension getOffset(){
        double width = this.screenResolution.getWidth() - this.SCALED_WIDTH;
        double height = this.screenResolution.getHeight() - this.SCALED_HEIGHT;
        return new Dimension((int) (width/2), (int) (height/2));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Dimension offset = getOffset();
        //g2.clearRect((int) offset.getWidth(), (int) offset.getHeight(), SCALED_WIDTH, SCALED_HEIGHT);
        //g2.translate(offset.getWidth(), offset.getHeight());
        player.draw(g2);
    }

    private void paintScaledImage(Graphics2D g2d, String path, int x, int y) {
        g2d.drawImage(scaleImage(path), x, y, null);
    }

    private BufferedImage scaleImage (String path){
        BufferedImage image = ImageUtils.load(path);
        BufferedImage scaledImage = new BufferedImage(SCALED_WIDTH,SCALED_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        double scale = getScale();
        final AffineTransform at = AffineTransform.getScaleInstance(scale, scale);
        final AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return ato.filter(image, scaledImage);
    }

    public void startGameThread(){
        this.gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        running = true;
        double drawInterval = 1000000000.0/this.FPS;
        double lastUpdateTime = 0;

        while (running) {
            double currentTime = System.nanoTime();

            if (currentTime > lastUpdateTime + drawInterval) {
                update();
                repaint();
                lastUpdateTime = currentTime;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
}
