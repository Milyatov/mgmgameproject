import javax.swing.JFrame;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("MGM Game");
        window.setBackground(Color.BLACK);
        window.add(new GamePanel());
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setUndecorated(true);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
