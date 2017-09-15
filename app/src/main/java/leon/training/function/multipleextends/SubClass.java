package leon.training.function.multipleextends;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/7/7.
 */

class SubClass extends SuperClass implements Interface2{

    public static int value = 4;

    static {
        Utils.msg("SubClass init");
    }


    public static void main(){

    }
}
