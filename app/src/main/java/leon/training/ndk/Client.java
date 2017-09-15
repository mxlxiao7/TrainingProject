package leon.training.ndk;


import java.util.Arrays;
import java.util.Random;
import java.util.UUID;


import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/25.
 */

class Client {
    /*************************native start*********************************/
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("native-c");
    }

    /**
     * 读取属性
     *
     * @return
     */
    public native String getStringFromC1();

    public native static String getStringFromC2();

    public native String getStringFromCPlus();

    public native String readStringFromJava();

    public native String readStaticStringFromJava();

    /**
     * 修改属性
     */
    public native void modifyAtt();

    public native void modifyStaticAtt();


    /**
     * C访问Java方法
     */
    public native void invokeMethod();

    public native void invokeStaticMethod();

    /**
     * C调用Java构造方法
     */
    public native void invokeConstructMethod();

    /**
     * C调用Java父类方法
     */
    public native void invokeSuperMethod();

    /**
     * 中文字符问题
     *
     * @param name
     * @return
     */
    public native String chineseIssue(String name);

    /**
     * native 对数组排序
     *
     * @param arr
     */
    public native void arraySort(int[] arr);

    /**
     * native 对数组排序
     *
     * @param arr
     */
    public native int[] getArray(int num);

    /**
     * 优化局部引用
     */
    public native void localRef();

    /**
     * 优化全局引用
     */
    public native void globalRef();

    /**
     * 优化全局引用
     */
    public native void globalWeakRef();

    /**
     * 异常
     */
    public native void exception();


    /*************************native end**********************************/

    private static Client client = new Client();
    private String name = "Jack";
    private static String otherName = "Rose";
    private God god = new Jack();
    private String key = "jason";


    /**
     * 读取
     */
    public static void read() {
        Utils.msg("C => " + client.getStringFromC1());
        Utils.msg("C(static method) => " + client.getStringFromC2());
        Utils.msg("C++ => " + client.getStringFromCPlus());
    }

    public static void readJavaAtt() {
        Utils.msg("Java Att => " + client.readStringFromJava());
        Utils.msg("Java Static Att => " + client.readStaticStringFromJava());
    }


    public static void modifyJavaAtt() {
        Utils.msg("Java Att => " + "before: " + client.name);
        client.modifyAtt();
        Utils.msg("Java Att => " + "after: " + client.name);

        Utils.msg("");

        Utils.msg("Java StaticAtt => " + "before: " + client.otherName);
        client.modifyStaticAtt();
        Utils.msg("Java Static Att => " + "after: " + client.otherName);
    }

    public static void invokedMethod() {
        client.invokeMethod();
        client.invokeStaticMethod();
    }

    private int cInvokeJavaMethod(int max) {
        return new Random().nextInt(max);
    }

    public static String cInvokeJavaStaticMethod() {
        return UUID.randomUUID().toString();
    }

    /**
     * C调用Date生成时间戳
     */
    public static void invokeTime() {
        client.invokeConstructMethod();
    }

    /**
     * C调用Java父类方法
     */
    public static void invokeSuper() {
        client.invokeSuperMethod();
    }

    public static void strIssue() {
        Utils.msg(client.chineseIssue("马蓉"));
    }

    public static void passArray() {
        Utils.msg("排序前：" + client.getArray(10));
    }

    public static void archiveArray() {
        Utils.msg(Arrays.toString(client.getArray(10)) + "\n");
    }

    public static void optimizeRef() {
        Utils.msg("局部引用");
        client.localRef();

        Utils.msg("全局引用");
        client.globalRef();

        Utils.msg("弱全局引用");
        client.globalWeakRef();

    }

    public static void jniException() {
        try {
            client.exception();
        } catch (Exception e) {
            Utils.msg("Java 捕获Jni抛出的异常");
        }
    }

}
