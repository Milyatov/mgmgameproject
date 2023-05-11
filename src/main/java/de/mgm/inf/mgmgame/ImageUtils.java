package de.mgm.inf.mgmgame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class ImageUtils {
    private ImageUtils() {}

    private static final HashMap<String, BufferedImage> CACHE = new HashMap<>();

    public static BufferedImage load(String path) {
        if(CACHE.containsKey(path)) {
            return CACHE.get(path);
        }

        URL url = ImageUtils.class.getClassLoader().getResource(path);
        if(url == null) {
            throw new IllegalStateException("Image at " + path + " doesn't exist!");
        }

        try {
            CACHE.put(path, ImageIO.read(url));
            return CACHE.get(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
