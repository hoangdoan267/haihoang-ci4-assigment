package vn.edu.techkids.controllers.enemybullets;


import vn.edu.techkids.controllers.Colliable;
import vn.edu.techkids.controllers.CollisionPool;
import vn.edu.techkids.controllers.plane.PlaneController;
import vn.edu.techkids.controllers.SingleController;
import vn.edu.techkids.models.*;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {



    public EnemyBulletController(EnemyBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 5;
        CollisionPool.getInst().add(this);
    }

    public EnemyBulletController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer, gameVector);
        CollisionPool.getInst().add(this);
    }

    @Override
    public void run() {
        super.run();
        if (!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
        }
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof PlaneController) {
            Plane plane = (Plane) c.getGameObject();
            EnemyBullet enemyBullet = (EnemyBullet)gameObject;
            plane.decreaseHP(enemyBullet.getDamage());
            if (plane.getHp() <= 0) {
                plane.setAlive(false);
            }
        }

    }

    public static EnemyBulletController create(EnemyBulletType enemyBulletType, int x, int y){
        EnemyBullet enemyBullet = new EnemyBullet(x,y, EnemyBullet.WIDTH, EnemyBullet.HEIGHT, 1);
        EnemyBulletController enemyBulletController = null;
        GameVector gameVector = null;
        switch(enemyBulletType){
            case DIRECT:
                ImageDrawer direct = new ImageDrawer("resources/enemy_bullet.png");
                gameVector = new GameVector(0,3);
                enemyBulletController = new EnemyBulletController(enemyBullet, direct, gameVector);
                break;
            case DIAGONAL:
                ImageDrawer diagonal = new ImageDrawer("resources/enemy_bullet.png");
                gameVector = new GameVector(-2,2);
                enemyBulletController = new EnemyBulletController(enemyBullet, diagonal, gameVector);
                break;
        }

        return enemyBulletController;
    }

}
