package leon.training.function.multipleextends;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/7/7.
 */

class SuperClass implements Interface1{

    public static final int value = 3;

    static {
        Utils.msg("SuperClass init");
    }
}
