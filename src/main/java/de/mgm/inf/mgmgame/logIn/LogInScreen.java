package de.mgm.inf.mgmgame.logIn;

import de.mgm.inf.mgmgame.GamePanel;
import de.mgm.inf.mgmgame.ImageUtils;
import de.mgm.inf.mgmgame.Main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class LogInScreen extends JPanel{

    BufferedImage background = ImageUtils.load("images/UI_Log_in_screen.png");

    public LogInScreen() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.printf("%d, %d %n", e.getX(), e.getY());
                if (e.getX() > 635 && e.getX() < 880 && e.getY() > 525 && e.getY() < 595){
                    System.out.println("nice");
                    Main.startPlayerID();
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, (int) (0 + GamePanel.getOffset().getHeight()), GamePanel.SCALED_WIDTH, GamePanel.SCALED_HEIGHT, null);
    }
}
