package leon.training.function.multipleextends;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/7/7.
 */

class Client {

    /**
     *
     * 1.如果SubClass中存在value字段，则引用目标类字段值，
     *
     * 2.如果有一个同名字段同时出现在C的接口和父类中，且自己没有该字段，那编译器将可能拒绝编译
     */
    public static void m1() {
        Utils.msg(SubClass.value + "");
    }

}
