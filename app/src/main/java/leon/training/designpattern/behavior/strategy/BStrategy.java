package leon.training.designpattern.behavior.strategy;

import android.util.Log;

/**
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:14:53
 * Email:mxlxiao7@sina.com
 */
public class BStrategy implements IStrategy {

    @Override
    public void operate() {
        Log.e("maxiaolong", "B operate()");
    }
}
