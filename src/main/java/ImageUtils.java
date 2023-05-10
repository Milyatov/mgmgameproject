import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ImageUtils {
    private ImageUtils() {}

    public static Image load(String path) {
        URL url = ImageUtils.class.getClassLoader().getResource(path);
        if(url == null) {
            throw new IllegalStateException("Image at " + path + " doesn't exist!");
        }

        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
