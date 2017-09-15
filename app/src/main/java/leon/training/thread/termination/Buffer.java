package leon.training.thread.termination;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import leon.training.utils.Utils;


/**
 * Created by maxiaolong on 2017/1/13.
 */
public class Buffer {
    private Lock locker = new ReentrantLock();

    public Buffer() {

    }

    public void write() {
        locker.lock();
        try {
            long startTime = System.currentTimeMillis();
            Utils.msg("开始往这个buff写入数据…");
            for (;;)// 模拟要处理很长时间
            {
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
                    break;
                }
            }
            Utils.msg("终于写完了");
        } finally {
            locker.unlock();
        }
    }

    public void read() throws InterruptedException {
        locker.lockInterruptibly();// 注意这里，可以响应中断
        try {
            Utils.msg("从这个buff读数据");
        } finally {
            locker.unlock();
        }
    }
}
