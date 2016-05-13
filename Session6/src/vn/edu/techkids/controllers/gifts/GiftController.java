package vn.edu.techkids.controllers.gifts;

import vn.edu.techkids.controllers.Colliable;
import vn.edu.techkids.controllers.CollisionPool;
import vn.edu.techkids.controllers.SingleController;
import vn.edu.techkids.controllers.enemyplanes.EnemyPlaneController;
import vn.edu.techkids.controllers.enemyplanes.EnemyPlaneControllerManager;
import vn.edu.techkids.controllers.plane.PlaneController;
import vn.edu.techkids.models.GameObject;
import vn.edu.techkids.models.GameVector;
import vn.edu.techkids.models.Gift;
import vn.edu.techkids.models.Plane;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Trà Đá on 5/10/2016.
 */
public class GiftController extends SingleController implements Colliable{



    public GiftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    public GiftController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer);
        this.gameVector = gameVector;
        CollisionPool.getInst().add(this);
    }


    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlaneController){
            Plane plane=(Plane)c.getGameObject();

            EnemyPlaneControllerManager.getInst().clear();

        }
    }

}
