package leon.training;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by maxiaolong on 2017/5/25.
 */

public class TApplication extends Application {

    private RefWatcher refWatcher;


    @Override
    public void onCreate() {
        super.onCreate();

        if (Global.isDebug()) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().build());
        }
        refWatcher = LeakCanary.install(this);
    }


    public static RefWatcher getRefWatcher(Context context) {
        TApplication application = (TApplication) context.getApplicationContext();
        return application.refWatcher;
    }

}