package leon.training.thread.cylicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 比如旅游场景，要等大家集合到一起，然后在一起想目的地出发
 * 原理:ReentrantLock + AQS的实现
 *
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
