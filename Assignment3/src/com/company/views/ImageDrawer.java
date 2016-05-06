package com.company.views;

import com.company.models.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Trà Đá on 5/5/2016.
 */
public class ImageDrawer implements GameDrawer {
    private Image image;

    public ImageDrawer(String url){
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void paint(GameObject gameObject, Graphics graphics) {
        graphics.drawImage(this.image, gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(), null);

    }
}
