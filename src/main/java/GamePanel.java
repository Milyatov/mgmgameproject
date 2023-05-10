import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    public GamePanel(){
        this.setSize(this.SCALED_WIDTH,this.SCALED_HEIGHT);
        this.setDoubleBuffered(true);
    }
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
        Graphics2D g2d = (Graphics2D) g;
        String path = "images/UI_Log_in_screen.png";
        paintScaledImage(g2d, path);
    }

    private void paintScaledImage(Graphics2D g2d, String path) {
        Image image = ImageUtils.load(path);
        BufferedImage scaledImage = new BufferedImage(SCALED_WIDTH, SCALED_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = scaledImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2.drawImage(image, 0, 0, SCALED_WIDTH, SCALED_HEIGHT, null);
        g2.dispose();
        Dimension offset = getOffset();
        g2d.translate(offset.getWidth(), offset.getHeight());
        g2d.drawImage(scaledImage, 0, 0, null);
    }
}
