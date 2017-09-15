package leon.training.designpattern.structure.proxy;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/4/20.
 */

public class RealSubject implements IProxy {

    @Override
    public void doAction() {
        Utils.msg("RealSubject - doAction()");
    }

}
