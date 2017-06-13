package leon.training.designpattern.behavior.strategy;

/**
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:14:54
 * Email:mxlxiao7@sina.com
 */
public class Context implements IStrategy {

    private final IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }


    @Override
    public void operate() {
        strategy.operate();
    }
}
