package com.company;
/*huynq.work@gmail.com*/
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Trà Đá on 4/24/2016.
 */

public class GameWindow extends Frame implements Runnable{
    Image backgroundImage;
    Image planeImage;
    Plane plane1;
    Plane plane2;
    PlaneEnemy plane3;


    Thread thread;
    Image backBufferImage;
    public GameWindow(){
        this.setVisible(true);
        this.setSize(400, 600);



        try{
            backgroundImage = ImageIO.read(new File("resources/background.png"));
            Image plane1Image = ImageIO.read(new File("resources/plane4.png"));
            Image plane2Image = ImageIO.read(new File("resources/plane2.png"));
            Image plane3Image = ImageIO.read(new File("resources/plane1.png"));
            Image bulletImage = ImageIO.read(new File("resources/bullet.png"));
            plane1 = new Plane(plane1Image, 100,500);
            plane2 = new Plane(plane2Image, 200, 500);
            plane3 = new PlaneEnemy(plane3Image, 100, 10);

        }catch(IOException e){
            e.printStackTrace();
        }

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        plane1.dy = -5;

                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.dy = 5;

                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.dx = +5 ;

                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.dx = -5;

                        break;
                    case KeyEvent.VK_SPACE:
                        plane1.shot();
                        break;
                }

                switch(e.getKeyCode()){
                    case KeyEvent.VK_W:
                        plane2.dy = -5;

                        break;
                    case KeyEvent.VK_S:
                        plane2.dy = 5;

                        break;
                    case KeyEvent.VK_D:
                        plane2.dx = +5 ;

                        break;
                    case KeyEvent.VK_A:
                        plane2.dx = -5;

                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        plane1.dy = 0;

                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.dy = 0;

                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.dx = 0 ;

                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.dx = 0;

                        break;
                }

                switch(e.getKeyCode()){
                    case KeyEvent.VK_W:
                        plane2.dy = 0;

                        break;
                    case KeyEvent.VK_S:
                        plane2.dy = 0;

                        break;
                    case KeyEvent.VK_D:
                        plane2.dx = 0 ;

                        break;
                    case KeyEvent.VK_A:
                        plane2.dx = 0;

                        break;
                }
            }
        });
        /*
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
            */
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {

        if(backBufferImage == null){
            backBufferImage = new BufferedImage(400, 600, 1);

        }
        Graphics backBufferGraphics = backBufferImage.getGraphics();
        backBufferGraphics.drawImage(backgroundImage, 0, 0, null);
        plane1.paint(backBufferGraphics);
        plane2.paint(backBufferGraphics);
        plane3.paint(backBufferGraphics);

        g.drawImage(backBufferImage, 0, 0, null);
    }
    @Override
    public void run(){
        long count =0;
        while(true){

            try{
               /* Point mousePoint = MouseInfo.getPointerInfo().getLocation();
                if(mousePoint.x -5 >plane2.x){
                    plane2.dx = 5;
                }else if(mousePoint.x +5 <plane2.x){
                    plane2.dx =-5;
                }else{
                    plane2.dx =0;
                }

                if(mousePoint.y -5>plane2.y){
                    plane2.dy = 5;
                }else if(mousePoint.y +5<plane2.y){
                    plane2.dy = -5;
                }else{
                    plane2.dy =0;
                }*/
                plane1.run();
                plane2.run();
                plane3.run();

                repaint();
                Thread.sleep(17);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
