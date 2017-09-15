package leon.training.function.trycatch;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/4/6.
 */

public class Condition {

    /**
     * Condition 1： 如果try中没有异常且try中有return （执行顺序）
     * try ---- finally --- return --- 1
     */
    public static int condition1() {
        int i = 1;
        try {
            Utils.msg("\n--try--");
            return i;
        } catch (Exception e) {
            Utils.msg("\n--catch--");
            i = 2;
        } finally {
            i = 3;
            Utils.msg("\n--finally--");
        }
        Utils.msg("\n最后--return--");
        i = 4;
        return i;
    }

    /**
     * Condition 2： 如果try中有异常并且try中有return
     * try --- catch --- finally --- 4
     */
    public static int condition2() {
        String s = null;

        int i = 1;
        try {
            Utils.msg("\n--try--");
            s.toString();
            return i;
        } catch (Exception e) {
            Utils.msg("\n--catch--");
            i = 2;

        } finally {
            i = 3;
            Utils.msg("\n--finally--");
        }
        Utils.msg("\n最后--return--");
        i = 4;
        return i;
    }

    /**
     * Condition 3： try中有异常，try-catch-finally里都没有return ，finally 之后有个return
     * try --- catch --- finally --- 4
     */
    public static int condition3() {
        String s = null;
        int i = 1;
        try {
            Utils.msg("\n--try--");
            s.toString();
        } catch (Exception e) {
            Utils.msg("\n--catch--");
            i = 2;
        } finally {
            i = 3;
            Utils.msg("\n--finally--");
        }
        Utils.msg("\n最后--return--");
        i = 4;
        return i;
    }

    /**
     * Condition 4： 当 try和finally中都有return时，finally中的return会覆盖掉其它位置的return。
     * try --- catch --- finally --- 3
     */
    public static int condition4() {
        String s = null;
        int i = 1;
        try {
            Utils.msg("\n--try--");
            s.toString();
            return i;
        } catch (Exception e) {
            Utils.msg("\n--catch--");
            i = 2;
        } finally {
            i = 3;
            Utils.msg("\n--finally--");
            return i;
        }
    }

    /**
     * Condition 5： 当finally中不存在return，而catch中存在return，但finally中要修改catch中return 的变量值时
     * try --- catch --- finally --- 2
     */
    public static int condition5() {
        String s = null;
        int i = 1;
        try {
            Utils.msg("\n--try--" + i);
            s.toString();
        } catch (Exception e) {
            i = 2;
            Utils.msg("\n--catch--" + i);
            return i;
        } finally {
            i = 3;
            Utils.msg("\n--finally-- " + i);
        }
        i = 4;
        return i;
    }

    /**
     * Condition 6： 当finally中存在return，而catch中存在return，但finally中要修改catch中return的变量值时,finally中的return会覆盖catch中的return
     * try --- catch --- finally --- 3
     */
    public static int condition6() {
        String s = null;
        int i = 1;
        try {
            Utils.msg("\n--try--" + i);
            s.toString();
        } catch (Exception e) {
            i = 2;
            Utils.msg("\n--catch--" + i);
            return i;
        } finally {
            i = 3;
            Utils.msg("\n--finally-- " + i);
            return i;
        }
    }
}
