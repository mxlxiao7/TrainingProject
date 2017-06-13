package leon.training.designpattern.create.factory.method;

/**
 * Author:maxiaolong
 * Date:2016/10/28
 * Time:13:18
 * Email:mxlxiao7@sina.com
 */
public class FactoryBMW320 implements IFactory {

    @Override
    public BMW createBMW() {
        return new BMW320();
    }
}
