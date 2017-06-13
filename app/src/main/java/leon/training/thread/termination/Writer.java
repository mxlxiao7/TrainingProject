package leon.training.thread.termination;

/**
 * Created by maxiaolong on 2017/1/13.
 */

public class Writer extends Thread {
    private Buffer buff;

    public Writer(Buffer buff) {
        this.buff = buff;
    }

    @Override
    public void run() {
        buff.write();
    }
}
