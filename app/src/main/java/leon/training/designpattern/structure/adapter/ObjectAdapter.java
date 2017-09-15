package leon.training.designpattern.structure.adapter;

import leon.training.utils.Utils;

/**
 *
 * 对象适配器模式 ，采用委托的形式
 *
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:14:23
 * Email:mxlxiao7@sina.com
 */
public class ObjectAdapter implements ITarget{

    private final Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }


    @Override
    public void sampleOperation1() {
        adaptee.sampleOperation1();
    }

    @Override
    public void sampleOperation2() {
        Utils.msg("ObjectAdapter -- sampleOperation2()");
    }
}
