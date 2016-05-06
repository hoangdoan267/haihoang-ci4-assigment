package com.company.controllers;

import com.company.models.Bullet;
import com.company.models.GameObject;
import com.company.models.Plane;
import com.company.views.GameDrawer;
import com.company.views.ImageDrawer;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Trà Đá on 5/6/2016.
 */
public class EnemyController extends SingleController {
    private Vector<BulletController> bulletControllerVector;

    public EnemyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.bulletControllerVector = new Vector<BulletController>();
    }

    public int getX(){
        return gameObject.getX();
    }
    public int getY(){
        return gameObject.getY();
    }
    public int getWidth(){
        return gameObject.getWidth();
    }
    public int getHeight(){
        return gameObject.getHeight();
    }

    public void move(){
        gameVector.dy =1;
    }

    public static EnemyController enemyController;
    public static EnemyController getEnemyController(){
        if(enemyController == null) {
            Random random = new Random();
            Plane plane = new Plane(100, 0, 60, 50);
            ImageDrawer planeDrawer = new ImageDrawer("resources/plane1.png");
            enemyController = new EnemyController(plane, planeDrawer);
        }
        return enemyController;
    }

    public void shot(){
        if(this.bulletControllerVector.size() < 100) {
            Bullet bullet = new Bullet(
                    gameObject.getX() + gameObject.getWidth() / 2 - Bullet.DEFAULT_WIDTH / 2,
                    gameObject.getY() + gameObject.getHeight(),
                    Bullet.DEFAULT_WIDTH,
                    Bullet.DEFAULT_HEIGHT
            );

            ImageDrawer bulletDrawer = new ImageDrawer("resources/bullet.png");
            BulletController bulletController = new BulletController(
                    bullet,
                    bulletDrawer
            );
            this.bulletControllerVector.add(bulletController);
        }
    }

    @Override
    public void run() {
        super.run();
        for(BulletController bulletController : bulletControllerVector){
            bulletController.BulletEnemy();
            bulletController.run();
        }
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for(BulletController bulletController : bulletControllerVector){
            bulletController.paint(graphics);
        }

    }
}
