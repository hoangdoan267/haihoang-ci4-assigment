package com.company.controllers;

import com.company.models.Bullet;
import com.company.models.GameObject;
import com.company.views.GameDrawer;
import com.company.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Trà Đá on 5/5/2016.
 */
public class BulletController extends SingleController {

    public static final int SPEED = 15;
    public BulletController(Bullet gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dy = -SPEED;
    }

    public void BulletEnemy(){
        gameVector.dy = 10;
    }

}
