package leon.training.function.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/5/31.
 */

public class DisableReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Utils.msg("StaBroadcast=>" + intent.getAction().toString());
    }
}
