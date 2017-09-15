package leon.training.thread.cylicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/1/14.
 */

public class SubTask extends Thread {

    private String name;
    private CyclicBarrier cb;

    public SubTask(String name, CyclicBarrier cb) {
        this.name = name;
        this.cb = cb;
    }

    public void run() {
        Utils.msg("[并发任务-" + name + "]  开始执行");

        for (int i = 0; i < 5; i++) {    //模拟耗时的任务
            Utils.msg("[并发任务-" + i + "-" + name + "] 执行...");
        }
        try {
            Utils.msg("[并发任务-" + name + "] 通知障碍器");
            //每执行完一项任务就通知障碍器
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        Utils.msg("[并发任务-" + name + "]  任务完成");
    }
}
