package leon.training.designpattern.structure.bridge;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/5.
 */

public class Street extends AbstractRoad {
    @Override
    void run() {
        super.run();
        aCar.run();
        Utils.msg("在市区街道行驶");
    }
}
