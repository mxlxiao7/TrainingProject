package leon.training.designpattern.create.factory.abs;

import leon.training.algorithm.Utils;

/**
 * Author:maxiaolong
 * Date:2016/10/28
 * Time:11:52
 * Email:mxlxiao7@sina.com
 */
public class Porsche911 implements Porsche {

    public Porsche911() {
        Utils.msg("Porsche911 - create()");
    }

    @Override
    public void doAction() {
        Utils.msg("Porsche911 - doAction()");
    }
}
