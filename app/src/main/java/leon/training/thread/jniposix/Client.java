package leon.training.thread.jniposix;

/**
 * Created by maxiaolong on 2017/5/25.
 */

class Client {

    static {
        System.loadLibrary("native-c");
    }

    /**
     *
     */
    public static native void initJni();

    /**
     *
     */
    public static native void destroyJni();

    /**
     *
     */
    public static native void pthread();


}
