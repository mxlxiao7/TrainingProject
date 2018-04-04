package leon.training.designpattern.aop.dynamic.aspectJ;

import leon.training.utils.Utils;

/**
 * @author maxiaolong3
 * @version V1.0
 * @description:
 * @date 2018/4/4 下午4:14
 */
public class DebugLog {

    private DebugLog() {
    }

    /**
     * Send a debug log message
     *
     * @param tag     Source of a log message.
     * @param message The message you would like logged.
     */
    public static void log(String tag, String message) {
        Utils.msg(message);
    }
}
