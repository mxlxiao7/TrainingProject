package leon.training.designpattern.create.factory.method;

import leon.training.utils.Utils;

/**
 * Author:maxiaolong
 * Date:2016/10/28
 * Time:11:50
 * Email:mxlxiao7@sina.com
 */
public class BMW320 implements BMW {

    public BMW320() {
        Utils.msg("BMW320 - create()");
    }

    @Override
    public void doAction() {
        Utils.msg("BMW320 - doAction()");
    }
}
