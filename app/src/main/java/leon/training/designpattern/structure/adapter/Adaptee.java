package leon.training.designpattern.structure.adapter;

import leon.training.utils.Utils;

/**
 * 源 （需要被适配的对象）
 * <p>
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:14:18
 * Email:mxlxiao7@sina.com
 */
public class Adaptee {

    public void sampleOperation1() {
        Utils.msg("Adaptee -- sampleOperation1()");
    }
}
