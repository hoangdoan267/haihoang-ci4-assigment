package vn.edu.techkids.controllers.gifts;

import vn.edu.techkids.controllers.ControllerManager;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.models.Gift;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Trà Đá on 5/10/2016.
 */
public class GiftControllerManager extends ControllerManager {

    private GiftControllerManager() {
        super();
    }

    private int count = 0;
    private int times = 0;

    @Override
    public void run() {

        super.run();
        count++;
        if(GameConfig.getInst().durationInSeconds(count)>2){
            count = 0;
            times++;
            if(times % 2 == 0){
                Gift gift =new Gift(400, 400, 30, 30);
                ImageDrawer bomDrawer = new ImageDrawer("resources/gift_bomb.png");

                GiftController giftController = new GiftController(gift, bomDrawer);
                this.singleControllerVector.add(giftController);
            }else{
                Gift gift =new Gift(400, 500, 30, 30);
                ImageDrawer bulletDrawer = new ImageDrawer("resources/bullet.png");
                GiftBulletController giftBulletController = new GiftBulletController(gift, bulletDrawer);
                this.singleControllerVector.add(giftBulletController);
            }
            count = 0;

        }

    }

    private static GiftControllerManager inst;

    public static GiftControllerManager getInst() {
        if(inst ==  null){
            inst = new GiftControllerManager();
        }
        return inst;
    }
}
