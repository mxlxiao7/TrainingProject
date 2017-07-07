package leon.training.function.init;

import leon.training.algorithm.Utils;

/**
 * Created by leon on 2017/7/7.
 */

public class SubClass extends SuperClass {

    public static final String str = "hello world";

    public static int val = 129;


    static {
        Utils.msg("SubClass init");
    }

}
