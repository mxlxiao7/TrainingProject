package leon.training.ndk;

import leon.training.algorithm.Utils;

/**
 * Created by leon on 2017/8/25.
 */

public class JniLog {

    /**
     * 在手机上显示
     *
     * @param msg
     */
    public static void showMessage(String msg) {
        Utils.msg(msg);
    }
}
