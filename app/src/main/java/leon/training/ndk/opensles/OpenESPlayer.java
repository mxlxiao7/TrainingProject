package leon.training.ndk.opensles;

/**
 * Created by leon on 2017/9/5.
 */

public class OpenESPlayer {

    static {
        System.loadLibrary("avilib");
    }

    /**
     * 播放
     * @param filePath
     */
    public static native void play(String filePath);

    /**
     * 停止
     */
    public static native void stop();
}
