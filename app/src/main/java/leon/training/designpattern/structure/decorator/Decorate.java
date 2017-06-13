package leon.training.designpattern.structure.decorator;

import android.util.Log;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:15
 * Email:mxlxiao7@sina.com
 */
public abstract class Decorate implements IComponent {

    private IComponent mComponent;

    public Decorate(IComponent component) {
        mComponent = component;

    }


    @Override
    public void doSomething() {
        mComponent.doSomething();
        Log.e("maxioalong", "Decorate -- doSomething()");
    }


}
