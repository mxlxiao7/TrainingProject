package leon.training.thread.countdownlatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import leon.training.utils.Utils;

/**
 *
 * 主线任务阻塞等待许多前置条件任务执行完毕，再执行主线任务
 * 原理:AQS的实现
 *
 */
public class CountDownLatchDemo {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);//两个工人的协作
        Worker worker1 = new Worker("zhang san", 5000, latch);
        Worker worker2 = new Worker("li si", 8000, latch);
        worker1.start();//
        worker2.start();//
        latch.await();//等待所有工人完成工作
        Utils.msg("all work done at " + sdf.format(new Date()));
    }


    static class Worker extends Thread {
        String workerName;
        int workTime;
        CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        public void run() {
            Utils.msg("Worker " + workerName + " do work begin at " + sdf.format(new Date()));
            doWork();//工作了
            Utils.msg("Worker " + workerName + " do work complete at " + sdf.format(new Date()));
            latch.countDown();//工人完成工作，计数器减一
        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}