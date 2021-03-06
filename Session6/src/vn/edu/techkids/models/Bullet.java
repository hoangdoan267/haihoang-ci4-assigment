package vn.edu.techkids.models;

public class Bullet extends GameObject {
    public static final int DEFAULT_WIDTH = 13;
    public static final int DEFAULT_HEIGHT = 33;
    public static final int DAMAGE_DEFAULT =1;
    public static int damage = DAMAGE_DEFAULT;


    public Bullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    public Bullet(int x, int y, int width, int height, int damage) {
        super(x, y, width, height);
        this.damage = damage;
    }

    public static int getDamage() {
        return damage;
    }

    public static void setDamage(int a) {
        damage += a;
    }

}
