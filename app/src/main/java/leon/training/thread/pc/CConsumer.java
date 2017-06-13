package leon.training.thread.pc;

/**
 * Created by maxiaolong on 2017/1/13.
 */

public class CConsumer extends Thread {
    private CInfo info = null;

    public CConsumer(CInfo info) {
        this.info = info;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            this.info.get();
        }
    }

}
