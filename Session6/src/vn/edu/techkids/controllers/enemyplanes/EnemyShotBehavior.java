package vn.edu.techkids.controllers.enemyplanes;

import vn.edu.techkids.controllers.enemybullets.EnemyBulletController;

/**
 * Created by Trà Đá on 5/9/2016.
 */
public interface EnemyShotBehavior {
    /**
     * Created by Trà Đá on 5/9/2016.
     */

        EnemyBulletController doShot(int x, int y);

}
