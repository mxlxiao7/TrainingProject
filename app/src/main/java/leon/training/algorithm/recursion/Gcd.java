package leon.training.algorithm.recursion;

import leon.training.algorithm.Strategy;
import leon.training.utils.Utils;

/**
 * 最大公约数
 * <p/>
 * Author:maxiaolong
 * Date:2017/11/3
 * Time:13:32
 * Email:mxlxiao7@sina.com
 */
public class Gcd {

    public static void main(int[] data) {

        if (data.length != 2) {
            Utils.msg("参数错误");
            return;
        }

        int result = gcd(data[0], data[1]);
        Utils.msg(data[0] + " 与 " + data[1] + " 最大公约数为：" + result);
    }

    /**
     * 求最大公约数
     *
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        if (m < n) {
            int tmp = n;
            n = m;
            m = tmp;
        }

        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

}
