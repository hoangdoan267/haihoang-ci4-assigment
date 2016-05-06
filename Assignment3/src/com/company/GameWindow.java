package com.company;
/*huynq.work@gmail.com*/
import com.company.controllers.EnemyController;
import com.company.controllers.PlaneController;
import com.company.controllers.PlaneDirection;

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
    Thread thread;
    Image backBufferImage;

    PlaneController planeController1;
    PlaneController planeController2;
    EnemyController enemyController1;

    int count = 0;

    public GameWindow(){

        planeController1 = PlaneController.getPlaneController1();
        planeController2 = PlaneController.getPlaneController2();
        enemyController1 = EnemyController.getEnemyController();

        this.setVisible(true);
        this.setSize(400, 600);

        try{
            backgroundImage = ImageIO.read(new File("resources/background.png"));

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
                System.out.println("Shoot!!");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                PlaneDirection planeDirection = PlaneDirection.NONE;
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        planeDirection = PlaneDirection.UP;
                        break;
                    case KeyEvent.VK_DOWN:
                        planeDirection = PlaneDirection.DOWN;
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeDirection = PlaneDirection.RIGHT;

                        break;
                    case KeyEvent.VK_LEFT:
                        planeDirection = PlaneDirection.LEFT;

                        break;
                }
                planeController1.move(planeDirection);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                PlaneDirection planeDirection = PlaneDirection.NONE;
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        planeDirection = PlaneDirection.STOP_Y;
                        break;
                    case KeyEvent.VK_DOWN:
                        planeDirection = PlaneDirection.STOP_Y;
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeDirection = PlaneDirection.STOP_X;
                        break;
                    case KeyEvent.VK_LEFT:
                        planeDirection = PlaneDirection.STOP_X;
                        break;
                    case KeyEvent.VK_SPACE:
                        planeController1.shot();
                        break;
                }
                planeController1.move(planeDirection);

            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                planeController2.shot();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

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
        planeController1.paint(backBufferGraphics);
        planeController2.paint(backBufferGraphics);
        enemyController1.paint(backBufferGraphics);

        g.drawImage(backBufferImage, 0, 0, null);

        if(count % 120 == 0){
            enemyController1.shot();
        }
        count++;
    }
    @Override
    public void run(){
        long count =0;
        while(true){

            try{

                if (planeController1.target(enemyController1) == true){
                    System.out.println("May bay 1 ban trung muc tieu");

                }

                if (planeController2.target(enemyController1) == true){
                    System.out.println("May bay 2 ban trung muc tieu");

                }

               Point mousePoint = MouseInfo.getPointerInfo().getLocation();
                mousePoint.x -= getLocationOnScreen().x;
                mousePoint.y -= getLocationOnScreen().y;

                PlaneDirection planeDirection = PlaneDirection.NONE;

                /*TODO Player 2 mouse controller */
                if(mousePoint.x - 5 > planeController2.getX() ) {
                    planeDirection = PlaneDirection.RIGHT;
                } else if(mousePoint.x + 5 < planeController2.getX()) {
                    planeDirection = PlaneDirection.LEFT;
                } else {
                    planeDirection =PlaneDirection.STOP_X ;
                }
                planeController2.move(planeDirection);

                if(mousePoint.y - 5 > planeController2.getY()) {
                    planeDirection = PlaneDirection.DOWN;
                } else if(mousePoint.y + 5 < planeController2.getY()) {
                    planeDirection = PlaneDirection.UP;
                } else {
                    planeDirection = PlaneDirection.STOP_Y;
                }
                planeController2.move(planeDirection);

                enemyController1.move();
                enemyController1.run();


                planeController1.run();
                planeController2.run();

                repaint();
                Thread.sleep(17);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
