package leon.training.designpattern.mvp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import leon.training.utils.Utils;

/**
 * @author maxiaolong3
 * @version V1.0
 * @description:
 * @date 2018/2/7 下午5:04
 */
public class MVPPresenter implements MVPContract.Presenter {

    private MVPContract.View mView;

    private HandlerThread myHandlerThread;

    private Handler handler;


    public MVPPresenter(MVPContract.View view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        //创建一个线程,线程名字：handler-thread
        myHandlerThread = new HandlerThread("handler-thread");
        //开启一个线程
        myHandlerThread.start();
        //在这个线程中创建一个handler对象
        handler = new Handler(myHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //这个方法是运行在 handler-thread 线程中的 ，可以执行耗时操作
                Utils.msg("消息： " + msg.what + "  线程： " + Thread.currentThread().getName());
            }
        };
    }

    @Override
    public void stop() {
        myHandlerThread.quit();
    }

    @Override
    public void delayPost(long delay) {
        //在主线程给handler发送消息
        handler.sendEmptyMessage(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //在子线程给handler发送数据
                handler.sendEmptyMessage(2);
            }
        }).start();
    }

    @Override
    public void msg(final String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Utils.msg(msg);
            }
        });
    }
}
