package leon.training.function.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

import leon.training.utils.Utils;

/**
 * 传输数据  list, String, Map , 基本数据类型 ,
 */
public class AIDLService extends Service {

    private static final String TAG = AIDLService.class.getSimpleName();
    private final List<Controler> mControlers = new ArrayList();


    public AIDLService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "AIDLService-onCreate()");

    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "AIDLService-onBind()");
        return new IService();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "AIDLService-onDestroy()");
    }

    public class IService extends IServieInterface.Stub {

        @Override
        public String getServiceName() throws RemoteException {
            return "This is Lambert Server";
        }

        @Override
        public Info getInfo() throws RemoteException {
            return new Info("Service Info");
        }

        @Override
        public void registControler(Controler c) throws RemoteException {
            if (c != null) {
                mControlers.add(c);
            }
        }

        @Override
        public void unRegistControler(Controler c) throws RemoteException {
            if (c != null) {
                mControlers.remove(c);
            }
        }

        @Override
        public void doTask() throws RemoteException {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < mControlers.size(); j++) {
                            Controler c = mControlers.get(j);
                            c.start();
                        }


                        for (int i = 1; i < 10; i++) {
                            for (int j = 0; j < mControlers.size(); j++) {
                                Controler c = mControlers.get(j);
                                c.action(i);
                            }
                            Thread.sleep(1000);
                        }

                        for (int j = 0; j < mControlers.size(); j++) {
                            Controler c = mControlers.get(j);
                            c.stop();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
