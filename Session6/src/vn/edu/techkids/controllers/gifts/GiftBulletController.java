package vn.edu.techkids.controllers.gifts;

import vn.edu.techkids.controllers.Colliable;
import vn.edu.techkids.controllers.CollisionPool;
import vn.edu.techkids.controllers.SingleController;
import vn.edu.techkids.controllers.bullets.BulletController;
import vn.edu.techkids.controllers.plane.PlaneController;
import vn.edu.techkids.models.Bullet;
import vn.edu.techkids.models.GameObject;
import vn.edu.techkids.models.GameVector;
import vn.edu.techkids.models.Plane;
import vn.edu.techkids.views.GameDrawer;

/**
 * Created by Trà Đá on 5/13/2016.
 */
public class GiftBulletController extends SingleController implements Colliable {

    public GiftBulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    public GiftBulletController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer, gameVector);
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlaneController){

            Bullet.setDamage(2);
            BulletController.SPEED += 2;

        }
    }
}
