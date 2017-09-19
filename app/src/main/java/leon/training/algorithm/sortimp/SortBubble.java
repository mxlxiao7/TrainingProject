package leon.training.algorithm.sortimp;

import leon.training.algorithm.Strategy;
import leon.training.utils.Utils;

/**
 * 冒泡排序
 * <p/>
 * Author:maxiaolong
 * Date:2016/11/3
 * Time:13:32
 * Email:mxlxiao7@sina.com
 */
public class SortBubble implements Strategy {


    private String tip =
            "冒泡排序（Bubble Sort）它重复地走访过要排序的数列，一次比较两个元素，" +
                    "如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，" +
                    "也就是说该数列已经排序完成。" +
                    "\n" +
                    "时间复杂度：Ο(n2)\n" +
                    "\n" +
                    "稳定性:稳定\n" +
                    "\n" +
                    "步骤：\n" +
                    "冒泡排序算法的运作如下：（从后往前）\n" +
                    "比较相邻的元素。如果第一个比第二个大，就交换他们两个。\n" +
                    "对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。\n" +
                    "针对所有的元素重复以上的步骤，除了最后一个。\n" +
                    "持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。[1] " +
                    "\n";

    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    Utils.swap(data, j, j + 1);
                }
            }
        }
    }

    @Override
    public String getTip() {
        return tip;
    }
}
