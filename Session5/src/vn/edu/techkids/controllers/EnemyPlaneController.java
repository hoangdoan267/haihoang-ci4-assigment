package vn.edu.techkids.controllers;

import vn.edu.techkids.models.*;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlaneController extends SingleController implements Colliable {

    private EnemyBulletControllerManager enemyBulletControllerManager;
    private int count = 0;
    private int times = 0;

    public EnemyPlaneController(EnemyPlane gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 2;

        enemyBulletControllerManager = new EnemyBulletControllerManager();
        CollisionPool.getInst().add(this);
    }

    public EnemyPlaneController(EnemyPlane gameObject, GameDrawer gameDrawer, int angle) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 2;
        this.gameVector.dx = 3;
        enemyBulletControllerManager = new EnemyBulletControllerManager();
        CollisionPool.getInst().add(this);

    }

    /* TODO override run */

    @Override
    public void run() {
        super.run();
        this.enemyBulletControllerManager.run();

        count++;
        times++;
        if(GameConfig.getInst().durationInSeconds(count) >= 2) {
            count = 0;
            if(times % 2 == 0){
                /*EnemyBullet enemyBullet = new EnemyBullet(
                        gameObject.getX() + gameObject.getWidth() / 2 - EnemyBullet.WIDTH/2,
                        gameObject.getY() + gameObject.getHeight(),
                        EnemyBullet.WIDTH,
                        EnemyBullet.HEIGHT
                );
                ImageDrawer imageDrawer = new ImageDrawer("resources/enemy_bullet.png");
                EnemyBulletController enemyBulletController = new EnemyBulletController(
                        enemyBullet,
                        imageDrawer
                );
                enemyBulletController.setDamage(1);
                this.enemyBulletControllerManager.add(enemyBulletController);*/

            //}else{
                EnemyBullet enemyBullet = new EnemyBullet(
                        gameObject.getX() + gameObject.getWidth() / 2 - EnemyBullet.WIDTH/2,
                        gameObject.getY() + gameObject.getHeight(),
                        EnemyBullet.WIDTH,
                        EnemyBullet.HEIGHT
                );
                ImageDrawer imageDrawer = new ImageDrawer("resources/enemy_bullet.png");
                EnemyBulletController enemyBulletController = new EnemyBulletController(
                        enemyBullet,
                        imageDrawer,
                        2
                );
                enemyBulletController.setDamage(3);
                this.enemyBulletControllerManager.add(enemyBulletController);
            }

        }

        if(!GameConfig.getInst().isInScreen(this.gameObject)){
            this.gameObject.setAlive(false);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.enemyBulletControllerManager.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlaneController){
            Plane plane = (Plane)c.getGameObject();
            System.out.println(plane.getHp());
            plane.decreaseHP();
        }
    }
}
