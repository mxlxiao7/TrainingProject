package leon.training.thread.cylicbarrier;

import android.util.Log;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/1/14.
 */

public class LastTask extends Thread {
    public void run() {
        Utils.msg("......终于要执行最后的任务了......");
    }
}
