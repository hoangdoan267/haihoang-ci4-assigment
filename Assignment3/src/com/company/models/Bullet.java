package com.company.models;

/**
 * Created by Trà Đá on 5/5/2016.
 */
public class Bullet extends GameObject {

    public static final int DEFAULT_WIDTH = 13;
    public static final int DEFAULT_HEIGHT = 33;

    public Bullet(int x, int y, int width, int height) {
        super(x, y, height, width);
    }
}
