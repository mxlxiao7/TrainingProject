package leon.training.function.init;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/7/7.
 */

class SuperClass{

    public static int value = 123;

    static {

        Utils.msg("SuperClass init");

    }

}
