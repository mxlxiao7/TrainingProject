package leon.training.function.volatiletest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/7/7.
 */

class Client {

    public static volatile int race = 0;

    public static final int THREADS_COUNT = 20;

    /**
     *
     */
    public static void increase() {
        race++;
    }


    /**
     *
     */
    public static void m1() {

        final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                    cdl.countDown();
                    Utils.msg("线程" + index + "执行完毕");
                }
            }).start();
        }

        try {
            cdl.await();
            Utils.msg("race = " + race);
        } catch (InterruptedException e) {

        }
    }


    public static void reset() {
        race = 0;
    }


    public static void main() {


        final AtomicInteger count = new AtomicInteger(20);

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            final int index = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                    count.decrementAndGet();
                    Utils.msg("线程" + index + "执行完毕");
                }
            });
            threads[i].start();
        }

        while (count.get() != 0) {
            Thread.yield();
        }

        Utils.msg("race = " + race);
    }


}
