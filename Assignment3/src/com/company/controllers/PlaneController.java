package com.company.controllers;

import com.company.models.Bullet;
import com.company.models.GameObject;
import com.company.models.Plane;
import com.company.views.GameDrawer;
import com.company.views.ImageDrawer;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Trà Đá on 5/5/2016.
 */
public class PlaneController extends SingleController {

    public static  final int SPEED = 10;
    private static  final int MAX_BULLET_COUNT =100;

    private Vector<BulletController> bulletControllerVector;

    public PlaneController(Plane gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.bulletControllerVector = new Vector<BulletController>();
    }

    public int getSize(){
        return bulletControllerVector.size();
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

    public void move(PlaneDirection planeDirection){
        switch(planeDirection){
            case UP:
                this.gameVector.dy = -SPEED;
                break;
            case DOWN:
                this.gameVector.dy = SPEED;
                break;
            case LEFT:
                this.gameVector.dx = -SPEED;
                break;
            case RIGHT:
                this.gameVector.dx = SPEED;
                break;
            case STOP_X:
                this.gameVector.dx = 0;
                break;
            case STOP_Y:
                this.gameVector.dy =0;
                break;
        }
    }

    public boolean target(EnemyController enemyController){
        for (int i =0 ; i< bulletControllerVector.size() ; i++){
            if (bulletControllerVector.get(i).gameObject.getX() > enemyController.getX()  && bulletControllerVector.get(i).gameObject.getX() < enemyController.getX() + enemyController.getWidth() ){
                {
                    if (bulletControllerVector.get(i).gameObject.getY() > enemyController.getY() && bulletControllerVector.get(i).gameObject.getY() < enemyController.getY() +enemyController.getHeight()  ) return true;
                }
            }
        }

        return false;
    }

    public void shot(){
        if(this.bulletControllerVector.size() < MAX_BULLET_COUNT) {
            Bullet bullet = new Bullet(
                    gameObject.getX() + gameObject.getWidth() / 2 - Bullet.DEFAULT_WIDTH / 2,
                    gameObject.getY(),
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

    private static PlaneController planeController1;
    private static PlaneController planeController2;
    public static PlaneController getPlaneController1(){
        if(planeController1 == null){
            Plane plane = new Plane(100, 500, 70, 60);
            ImageDrawer planeDrawer = new ImageDrawer("resources/plane4.png");
            planeController1 = new PlaneController(
                    plane,
                    planeDrawer
            );

        }
        return planeController1;
    }
    public static PlaneController getPlaneController2(){
        if(planeController2 == null){
            Plane plane = new Plane(200, 500, 70, 60);
            ImageDrawer planeDrawer = new ImageDrawer("resources/plane2.png");
            planeController2 = new PlaneController(
                    plane,
                    planeDrawer
            );

        }
        return planeController2;
    }
}
