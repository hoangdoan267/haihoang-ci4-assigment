package vn.edu.techkids.models;

/**
 * Created by qhuydtvt on 4/29/2016.
 */
public class Plane extends GameObject {

    public Plane(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    private int blood;

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }
}
