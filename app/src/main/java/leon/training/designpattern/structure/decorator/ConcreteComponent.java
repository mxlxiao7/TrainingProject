package leon.training.designpattern.structure.decorator;

import android.util.Log;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:12
 * Email:mxlxiao7@sina.com
 */
public class ConcreteComponent implements IComponent {


    @Override
    public void doSomething() {
        Log.e("maxioalong", "ConcreteComponent -- doSomething()");
    }




}
