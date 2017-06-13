package leon.training.designpattern.create.single;

/**
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:15:37
 * Email:mxlxiao7@sina.com
 */
public class SingleInstance2 {

    private static volatile SingleInstance2 sSingleInstance;

    private SingleInstance2() {

    }

    public SingleInstance2 getInstance() {
        if (sSingleInstance == null) {
            synchronized (SingleInstance2.class) {
                if (sSingleInstance == null) {
                    sSingleInstance = new SingleInstance2();
                }
            }
        }
        return sSingleInstance;
    }


}
