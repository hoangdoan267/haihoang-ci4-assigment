package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Trà Đá on 4/25/2016.
 */
public class Plane {
    public int x;
    public int y;
    public int dx;
    public int dy;
    private final int WIDTH = 70;
    private final int HEIGHT = 60;
    private Image image;

    Bullet bullet;


    public void paint(Graphics g){
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
        if(bullet != null){
            bullet.paint(g);
        }
    }

    public void run(){
        if(check_corner() ==true){
            x+= dx;
            y+= dy;
            if(bullet != null){
                bullet.run();
            }

        }

    }

    public void move(Movement m){
        /*switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                dy = -5;

                break;
            case KeyEvent.VK_DOWN:
                dy = 5;

                break;
            case KeyEvent.VK_RIGHT:
                dx = +5 ;

                break;
            case KeyEvent.VK_LEFT:
                dx = -5;

                break;
        }*/
        if(m.dx >0){
            dx =5;
        }else if(m.dx <0){
            dx = -5;
        }else{
            dx =0;
        }

        if(m.dy >0){
            dy =5;
        }else if(m.dy >0){
            dy =-5;
        }else{
            dy =0;
        }
    }

    public void stop(KeyEvent e){

        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                dy = 0;

                break;
            case KeyEvent.VK_DOWN:
                dy = 0;

                break;
            case KeyEvent.VK_RIGHT:
                dx = 0 ;

                break;
            case KeyEvent.VK_LEFT:
                dx = 0;

                break;
        }

    }

    public boolean check_corner(){
        boolean i = true;
        if( (x+dx)< -25 || (x+dx)>355|| (y+dy)> 530 || (y+dy) <33){
            i = false;
        }

        return i;
    }

   /* public void setImage(Image img){
        if(img != null && this.image == null){
            this.image = img;
        }

    }*/

    public Plane(Image img, int a, int b){
        this.image = img;
        x = a;
        y =b;
    }

    public void shot(){
        try {
            this.bullet = new Bullet(this.x + WIDTH/2-6, this.y, ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
