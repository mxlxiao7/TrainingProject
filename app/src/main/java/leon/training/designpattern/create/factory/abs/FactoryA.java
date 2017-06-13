package leon.training.designpattern.create.factory.abs;

/**
 * Author:maxiaolong
 * Date:2016/10/28
 * Time:13:18
 * Email:mxlxiao7@sina.com
 */
public class FactoryA implements IFactory {
    @Override
    public Porsche createPorsche() {
        return new Porsche911();
    }

    @Override
    public Air createAir() {
        return new AirA();
    }
}
