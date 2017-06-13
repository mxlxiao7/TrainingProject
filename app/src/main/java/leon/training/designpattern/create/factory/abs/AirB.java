package leon.training.designpattern.create.factory.abs;

import leon.training.algorithm.Utils;

/**
 * Author:maxiaolong
 * Date:2016/10/28
 * Time:11:52
 * Email:mxlxiao7@sina.com
 */
public class AirB implements Air {

    public AirB() {
        Utils.msg("AirB - create()");
    }


    @Override
    public void doAction() {
        Utils.msg("AirA - doAction()");
    }

}
