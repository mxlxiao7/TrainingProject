package leon.training.algorithm.recursion;

import android.os.HandlerThread;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/9/19.
 * 泊松分酒
 */
public class ShareWine {

    private int b1 = 12;
    private int b2 = 8;
    private int b3 = 5;
    private int m = 6;


    public static void main(int[] data) {
        ShareWine s = new ShareWine();
        Utils.msg("三个瓶子 " + s.b1 + "L," + s.b2 + "L," + s.b3 + "L, 测量出：" + s.m + "L水");

    }

    private void backBottle(int bb1, int bb2, int bb3) {
        if (bb1 == m || bb2 == m || bb3 == m) {
            Utils.msg("找到了瓶子");
            return;
        }

        if (bb2 != 0 && bb3 != b3) {
            if (bb2 + bb3 <= b3) {
                backBottle(bb1, 0, bb2 + bb3);
            } else {
                backBottle(bb1, bb2 - (b3 - bb3), b3);
            }
        }
    }

}
