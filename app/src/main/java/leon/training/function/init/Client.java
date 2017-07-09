package leon.training.function.init;

import leon.training.algorithm.Utils;

/**
 * Created by leon on 2017/7/7.
 */

class Client {

    /**
     * 通过子类引用父类的静态字段，不会导致子类初始化
     */
    public static void m1() {
        Utils.msg(SubClass.value + "");
    }

    /**
     * 通过数组定义来引用类，不会引起此类初始化
     */
    public static void m2() {
        SuperClass[] sca = new SuperClass[10];
    }

    /**
     * 常量在编译阶段存如常量池，布置上并没有直接引用到定义类的常量，不会触发定义类的初始化
     */
    public static void m3() {
        Utils.msg(SubClass.str);
    }

    /**
     * 对照m3
     */
    public static void m4() {
        Utils.msg(SubClass.val+"");
    }

}
