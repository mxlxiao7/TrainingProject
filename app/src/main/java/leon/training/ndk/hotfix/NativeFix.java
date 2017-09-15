package leon.training.ndk.hotfix;

import java.lang.reflect.Method;

/**
 * Created by leon on 2017/9/14.
 */

public class NativeFix {

    static {
        System.loadLibrary("native-fix");
    }

    public static native void init(int api);

    public static native void replaceMethod(Method src, Method res);
}
