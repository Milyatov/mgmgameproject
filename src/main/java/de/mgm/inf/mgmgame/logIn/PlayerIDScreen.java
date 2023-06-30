package de.mgm.inf.mgmgame.logIn;

import de.mgm.inf.mgmgame.GamePanel;
import de.mgm.inf.mgmgame.Main;

import javax.swing.*;

public class PlayerIDScreen extends JPanel{
    public JTextField textfield;
    public JLabel label;
    public JButton btn = new JButton("Start the Game!");

    public PlayerIDScreen() {
        this.btn.setSize(200, 30);
        this.btn.setBounds(GamePanel.SCALED_WIDTH / 2 - 50, GamePanel.SCALED_HEIGHT / 2 + 30, 100, 20);
        this.btn.addActionListener(e -> Main.startGame());
        this.textfield = new JTextField();
        this.textfield.setBounds(GamePanel.SCALED_WIDTH / 2 - 50, GamePanel.SCALED_HEIGHT / 2, 100, 20);
        this.textfield.setSize(100, 20);
        this.label = new JLabel();
        this.label.setText("Please enter your name!");
        this.label.setSize(150, 20);
        this.label.setBounds(GamePanel.SCALED_WIDTH / 2 - 60, GamePanel.SCALED_HEIGHT / 2 - 30, 200, 20);
        this.setSize(GamePanel.SCALED_WIDTH, GamePanel.SCALED_HEIGHT);
        this.setLayout(null);
        this.add(this.btn);
        this.add(this.textfield);
        this.add(this.label);
        this.setVisible(true);
    }
}
