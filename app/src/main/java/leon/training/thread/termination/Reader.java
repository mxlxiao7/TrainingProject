package leon.training.thread.termination;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/1/13.
 */
public class Reader extends Thread {

    private Buffer buff;

    public Reader(Buffer buff) {
        this.buff = buff;
    }

    @Override
    public void run() {
        try {
            buff.read();//可以收到中断的异常，从而有效退出
        } catch (InterruptedException e) {
            Utils.msg("我不读了");
        }
        Utils.msg("读结束");
    }
}
