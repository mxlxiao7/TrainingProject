package leon.training.designpattern.create.factory.abs;

import leon.training.utils.Utils;

/**
 * Author:maxiaolong
 * Date:2016/10/28
 * Time:11:52
 * Email:mxlxiao7@sina.com
 */
public class AirA implements Air {

    public AirA() {
        Utils.msg("AirA - create()");
    }

    @Override
    public void doAction() {
        Utils.msg("AirA - doAction()");
    }

}
