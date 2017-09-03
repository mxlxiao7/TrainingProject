package leon.training.thread.deadlock;


import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/5/25.
 */

class Client {

    public static void main() {
        Object locka = new Object();
        Object lockb = new Object();

        new Thread(new SyncThread(locka, lockb)).start();
        new Thread(new SyncThread(lockb, locka)).start();
    }
}


class SyncThread implements Runnable {
    private Object obj1;
    private Object obj2;

    public SyncThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        work();
    }

    private void work() {
        try {
            for (int i = 0; i < 1000; i++) {
                String name = Thread.currentThread().getName();
                Utils.msg(name + " working... " + i);
                synchronized (obj1) {
                    Thread.sleep(10);
                    synchronized (obj2) {
                        System.out.println(name + "  " + obj2);
                        Thread.sleep(1 * 1000);
                    }
                }
                Utils.msg(name + " finished execution.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}