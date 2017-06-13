package leon.training.algorithm;

/**
 * Author:maxiaolong
 * Date:2016/11/3
 * Time:13:36
 * Email:mxlxiao7@sina.com
 */
public class Client implements Strategy {
    private Strategy strategy;

    public Client(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void sort(int[] data) {
        strategy.sort(data);
    }

    @Override
    public String getTip() {
        return strategy.getTip();
    }
}
