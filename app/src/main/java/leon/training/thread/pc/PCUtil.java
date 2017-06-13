package leon.training.thread.pc;

/**
 * Created by maxiaolong on 2017/1/16.
 */

public class PCUtil {

    public static void doAction() {
        CInfo info = new CInfo(); // 实例化Info对象
        CProducer pro = new CProducer(info); // 生产者
        CConsumer con = new CConsumer(info); // 消费者
        new Thread(pro).start();
        //启动了生产者线程后，再启动消费者线程
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(con).start();
    }
}
