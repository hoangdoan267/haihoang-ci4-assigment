package com.company.views;

import com.company.models.GameObject;

import java.awt.*;

/**
 * Created by Trà Đá on 5/5/2016.
 */
public interface GameDrawer {
    void paint(GameObject gameObject, Graphics graphics);
}
