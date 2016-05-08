package vn.edu.techkids.controllers;

import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlaneControllerManager extends ControllerManager {

    private int count = 0;
    private int times =0;

    private EnemyPlaneControllerManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;

        if(GameConfig.getInst().durationInSeconds(count) > 2) {
            count = 0;
            times++;
            if(times % 2 ==0){
                /*for (int x = 40; x < GameConfig.getInst().getScreenWidth() - 40; x += 100) {
                    EnemyPlane enemyPlane= new EnemyPlane(x, 0, 32, 32);
                    ImageDrawer imageDrawer =
                            new ImageDrawer("resources/plane1.png");
                    EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
                            enemyPlane,
                            imageDrawer
                    );
                    this.singleControllerVector.add(enemyPlaneController);
                }*/
            //}else{
                EnemyPlane enemyPlane1 = new EnemyPlane(0, 0, 32 , 32);
                ImageDrawer imageDrawer1 = new ImageDrawer("resources/enemy_plane_white_1.png");

                EnemyPlaneController enemyPlaneController1 = new EnemyPlaneController(
                        enemyPlane1,
                        imageDrawer1,
                        2
                );
                this.singleControllerVector.add(enemyPlaneController1);

            }//
        }

    }

    private static EnemyPlaneControllerManager inst;
    public static EnemyPlaneControllerManager getInst() {
        if(inst == null) {
            inst = new EnemyPlaneControllerManager();
        }

        return inst;
    }
}
