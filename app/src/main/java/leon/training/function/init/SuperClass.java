package leon.training.function.init;

import leon.training.algorithm.Utils;

/**
 * Created by leon on 2017/7/7.
 */

public class SuperClass{

    public static int value = 123;

    static {

        Utils.msg("SuperClass init");

    }

}
