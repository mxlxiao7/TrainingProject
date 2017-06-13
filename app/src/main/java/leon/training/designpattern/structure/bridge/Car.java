package leon.training.designpattern.structure.bridge;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/5/5.
 */

public class Car extends AbstractCar {
    @Override
    void run() {
        super.run();
        Utils.msg("小汽车");
    }
}
