package com.company;

import java.awt.*;

/**
 * Created by Trà Đá on 4/25/2016.
 */
public class Bullet {
    private int x;
    private int y;
    private Image image;

    public Bullet(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void run(){
        y -=5;
    }

    public void paint(Graphics g){
        g.drawImage(this.image, this.x, this.y, null);
    }


}
