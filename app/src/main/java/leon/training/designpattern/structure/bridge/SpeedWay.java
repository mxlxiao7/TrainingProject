package leon.training.designpattern.structure.bridge;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/5.
 */

public class SpeedWay extends AbstractRoad {
    @Override
    void run() {
        super.run();
        aCar.run();
        Utils.msg("在高速公路行驶");
    }
}
