package leon.training.thread.cylicbarrier;

import android.util.Log;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import leon.training.algorithm.Utils;

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
        Log.e("maxiaolong", "[并发任务-" + name + "]  开始执行");

        for (int i = 0; i < 5; i++) {    //模拟耗时的任务
            Utils.msg("[并发任务-" + i + "-" + name + "]  开始执行完毕，通知障碍器");
            Log.e("maxiaolong", "[并发任务-" + i + "-" + name + "]  开始执行完毕，通知障碍器");
        }
        try {
            //每执行完一项任务就通知障碍器
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
