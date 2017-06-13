package leon.training.designpattern.structure.adapter;

import leon.training.algorithm.Utils;

/**
 *
 * 适配对象
 *
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:14:18
 * Email:mxlxiao7@sina.com
 */
public class Adapter extends Adaptee implements ITarget {

    @Override
    public void sampleOperation2() {
        Utils.msg("Adapter -- sampleOperation2()");
    }

}
