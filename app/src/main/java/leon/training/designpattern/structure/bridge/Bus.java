package leon.training.designpattern.structure.bridge;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/5.
 */

public class Bus extends AbstractCar {
    @Override
    void run() {
        super.run();
        Utils.msg("公交车");
    }
}
