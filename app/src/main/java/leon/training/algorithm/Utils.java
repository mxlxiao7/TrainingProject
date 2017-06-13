package leon.training.algorithm;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by maxiaolong on 2016/11/28.
 */

public class Utils {

    public static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void msg(String s) {
        Log.d("TLOG", s);
        EventBus.getDefault().post(s);
    }
}
