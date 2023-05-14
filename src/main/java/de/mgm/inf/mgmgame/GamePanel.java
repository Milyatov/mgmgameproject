package de.mgm.inf.mgmgame;

import de.mgm.inf.mgmgame.entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    static GamePanel panel;

    public static GamePanel getInstance() {
        if(panel == null) {
            panel = new GamePanel();
        }
        return panel;
    }

    private GamePanel(){
        panel = this;
        this.setSize(SCALED_WIDTH, SCALED_HEIGHT);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyMap);
        this.setFocusable(true);
        this.player = new Player(this, keyMap);
        this.sceneManager = new SceneManager();
        this.sceneManager.changeLevel(1);
    }

    KeyMap keyMap = new KeyMap();
    Player player;
    SceneManager sceneManager;
    boolean running = false;
    final int FPS = 60;
    Thread gameThread;

    private static final Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Dimension RESOURCE_DIMENSION = new Dimension(640,360);
    @SuppressWarnings("FieldCanBeLocal")
    private static final double DEFAULT_ASPECT_RATIO = 16.0 / 9.0;
    private static final double SCREEN_ASPECT_RATIO = screenResolution.getWidth() / screenResolution.getHeight();
    final static int SCALED_WIDTH = (int) (getScale() * RESOURCE_DIMENSION.getWidth());
    final static int SCALED_HEIGHT = (int) (getScale() * RESOURCE_DIMENSION.getHeight());

    public static Dimension getScreenResolution() {
        return screenResolution;
    }

    public static Dimension getResourceDimension() {
        return RESOURCE_DIMENSION;
    }

    public static double getScale() {
        if (SCREEN_ASPECT_RATIO < DEFAULT_ASPECT_RATIO){
            return screenResolution.getWidth()/ RESOURCE_DIMENSION.getWidth();
        } else {
            return screenResolution.getHeight()/ RESOURCE_DIMENSION.getHeight();
        }
    }

    public static Dimension getOffset(){
        double width = screenResolution.getWidth() - SCALED_WIDTH;
        double height = screenResolution.getHeight() - SCALED_HEIGHT;
        return new Dimension((int) (width/2), (int) (height/2));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        //Dimension offset = getOffset();
        //g2.clearRect((int) offset.getWidth(), (int) offset.getHeight(), SCALED_WIDTH, SCALED_HEIGHT);
        //g2.translate(offset.getWidth(), offset.getHeight());

        //This is just a test image, it should be replaced with a real map
        sceneManager.draw(g2, player.getWorldX(), player.getWorldY());
        player.draw(g2);

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
