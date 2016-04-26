package com.company;

import java.awt.*;

/**
 * Created by Trà Đá on 4/26/2016.
 */
public class PlaneEnemy extends Plane {
    public PlaneEnemy(Image img, int x, int y){
        super(img, x, y);
    }

    public void run(){
        y+=5;

    }
}
