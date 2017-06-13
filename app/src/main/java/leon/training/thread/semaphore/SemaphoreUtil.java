package leon.training.thread.semaphore;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/1/16.
 */

public class SemaphoreUtil {

    public static void exe() {
        new SemaphoreUtil().doAction();
    }

    //采用新特性来启动和管理线程——内部使用线程池
    private ExecutorService exec = Executors.newCachedThreadPool();
    //只允许5个线程同时访问
    private Semaphore semp = new Semaphore(5);

    public void doAction() {
        //模拟10个客户端访问
        for (int index = 0; index < 10; index++) {
            final int num = index + 1;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        //获取许可
                        semp.acquire();
                        Utils.msg("线程" + Thread.currentThread().getName() + "获得许可：" + num);
                        //模拟耗时的任务
                        Thread.sleep(5 * 1000);
                        //释放许可
                        semp.release();
//                        Utils.msg("线程" + Thread.currentThread().getName() + "释放许可：" + num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        //关闭线程池
        exec.shutdown();
    }

}
