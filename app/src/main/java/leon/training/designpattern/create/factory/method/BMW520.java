package leon.training.designpattern.create.factory.method;

import leon.training.utils.Utils;

/**
 * Author:maxiaolong
 * Date:2016/10/28
 * Time:11:50
 * Email:mxlxiao7@sina.com
 */
public class BMW520 implements BMW {

    public BMW520(){
        Utils.msg("BMW520 - create()");
    }

    public void doAction() {
        Utils.msg("BMW520 - doAction()");
    }
}
