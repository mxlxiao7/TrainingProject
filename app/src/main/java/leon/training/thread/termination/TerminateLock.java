package leon.training.thread.termination;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/1/16.
 */

public class TerminateLock {
    public static void doAction() {
        Buffer buff = new Buffer();
        final Writer writer = new Writer(buff);
        final Reader reader = new Reader(buff);
        writer.start();
        reader.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (; ; ) {
                    if (System.currentTimeMillis() - start > 5 * 1000) {
                        Utils.msg("不等了，尝试中断");
                        reader.interrupt();  //此处中断读操作
                        break;
                    }
                }
            }
        }).start();
    }
}
