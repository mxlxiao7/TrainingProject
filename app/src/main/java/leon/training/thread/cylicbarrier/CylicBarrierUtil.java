package leon.training.thread.cylicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by maxiaolong on 2017/1/16.
 */

public class CylicBarrierUtil {
    public static void doAction() {
        CyclicBarrier cb = new CyclicBarrier(5, new LastTask());
        new SubTask("A", cb).start();
        new SubTask("B", cb).start();
        new SubTask("C", cb).start();
        new SubTask("D", cb).start();
        new SubTask("E", cb).start();
    }
}
