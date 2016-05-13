package vn.edu.techkids.controllers.bullets;

import vn.edu.techkids.controllers.Colliable;
import vn.edu.techkids.controllers.CollisionPool;
import vn.edu.techkids.controllers.SingleController;
import vn.edu.techkids.controllers.enemybullets.EnemyBulletController;
import vn.edu.techkids.controllers.enemyplanes.EnemyPlaneController;
import vn.edu.techkids.models.*;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 4/29/2016.
 */
public class BulletController extends SingleController implements Colliable {

    public static int SPEED = 15;


    public BulletController(Bullet gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dy = -SPEED;
        CollisionPool.getInst().add(this);
    }

    public BulletController(Bullet gameObject, ImageDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer);
        this.gameVector = gameVector;
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
        if (c instanceof EnemyPlaneController) {
            EnemyPlane enemyPlane = (EnemyPlane) c.getGameObject();
            enemyPlane.decreaseHP(Bullet.getDamage());
            if (enemyPlane.getHp() <= 0) {
                enemyPlane.setAlive(false);
            }
            gameObject.setAlive(false);
        }

        if (c instanceof EnemyBulletController) {
            EnemyBullet enemyBullet = (EnemyBullet)c.getGameObject();
            enemyBullet.setAlive(false);
            gameObject.setAlive(false);
        }

    }
}







