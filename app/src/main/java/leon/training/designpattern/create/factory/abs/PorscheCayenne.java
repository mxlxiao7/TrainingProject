package leon.training.designpattern.create.factory.abs;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/4/19.
 */

public class PorscheCayenne implements Porsche {

    public PorscheCayenne() {
        Utils.msg("PorscheCayenne - create()");
    }

    @Override
    public void doAction() {
        Utils.msg("PorscheCayenne - doAction()");
    }
}
