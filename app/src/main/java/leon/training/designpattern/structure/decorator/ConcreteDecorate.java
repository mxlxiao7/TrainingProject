package leon.training.designpattern.structure.decorator;

import android.util.Log;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:25
 * Email:mxlxiao7@sina.com
 */
public class ConcreteDecorate extends Decorate {


    public ConcreteDecorate(IComponent component) {
        super(component);
    }


    @Override
    public void doSomething() {
        super.doSomething();
        Log.e("maxioalong", "ConcreteDecorate -- doSomething()");
    }
}
