package vn.edu.techkids.controllers.enemyplanes;

import vn.edu.techkids.controllers.enemybullets.EnemyBulletController;
import vn.edu.techkids.controllers.enemybullets.EnemyBulletType;

/**
 * Created by Trà Đá on 5/11/2016.
 */
public class EnemyDiagonalShotBehavior implements EnemyShotBehavior {
    @Override
    public EnemyBulletController doShot(int x, int y) {
        EnemyBulletController enemyBulletController = EnemyBulletController.create(EnemyBulletType.DIAGONAL,x,y);

        return enemyBulletController;
    }
}
