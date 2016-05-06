package com.company.controllers;

import com.company.models.GameObject;
import com.company.models.GameVector;
import com.company.views.GameDrawer;

import java.awt.*;

/**
 * Created by Trà Đá on 5/5/2016.
 */
public class SingleController implements Controller {
    protected GameObject gameObject;
    protected GameDrawer gameDrawer;
    protected GameVector gameVector;

    public SingleController(GameObject gameObject, GameDrawer gameDrawer){
        this.gameDrawer = gameDrawer;
        this.gameObject = gameObject;
        this.gameVector = new GameVector();

    }



    @Override
    public void run() {
        this.gameObject.move(this.gameVector);
    }

    @Override
    public void paint(Graphics graphics) {
        this.gameDrawer.paint(this.gameObject, graphics);
    }
}
