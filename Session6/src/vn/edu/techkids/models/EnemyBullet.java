package vn.edu.techkids.models;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBullet extends GameObject {

    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;

    public static final int DAMAGE_DEFAULT =1;

    private int damage = DAMAGE_DEFAULT;

    public EnemyBullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public EnemyBullet(int x, int y, int width, int height, int damage) {
        this(x, y, width, height);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


}
