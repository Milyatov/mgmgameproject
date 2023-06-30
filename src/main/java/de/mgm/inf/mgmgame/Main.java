package de.mgm.inf.mgmgame;

import de.mgm.inf.mgmgame.logIn.LogInScreen;
import de.mgm.inf.mgmgame.logIn.PlayerIDScreen;

import javax.swing.JFrame;
import java.awt.*;

public class Main {
    public static JFrame window = new JFrame();
    static LogInScreen loginScreen = new LogInScreen();
    static PlayerIDScreen playerIDScreen = new PlayerIDScreen();
    static GamePanel game = GamePanel.getInstance();

    public static void main(String[] args) {

        startLogIn();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("MGM Game");
        window.setBackground(Color.white);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setUndecorated(true);
        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }

    public static void startGame(){
        window.getContentPane().removeAll();
        window.add(game);
        window.revalidate();
        game.startGameThread();
        game.requestFocus();
    }

    public static void startLogIn(){
        window.add(loginScreen);
    }
    public static void startPlayerID(){
        window.getContentPane().removeAll();
        window.add(playerIDScreen);
        window.revalidate();
        window.repaint();
    }
}
