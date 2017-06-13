package leon.training.designpattern.create.single;

/**
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:15:37
 * Email:mxlxiao7@sina.com
 */
public class SingleInstance1 {

    private SingleInstance1() {

    }

    private static class InstanceHolder {
        private static SingleInstance1 sSingleInstance = new SingleInstance1();
    }


    public SingleInstance1 getInstance() {
        return InstanceHolder.sSingleInstance;
    }


}
