package leon.training.algorithm.sortimp;

import leon.training.algorithm.Strategy;

/**
 * 插入排序
 * <p/>
 * Author:maxiaolong
 * Date:2016/11/3
 * Time:13:32
 * Email:mxlxiao7@sina.com
 */
public class SortBinaryInsert implements Strategy {


    private String tip = "二分插入排序（BinaryInsertion Sort）的算法描述是一种简单直观的排序算法。" +
            "它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，" +
            "找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），" +
            "因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。\n" +
            " \n" +
            "时间复杂度：Ο(n2)\n" +
            "\n" +
            "稳定性:稳定\n" +
            "\n" +
            "步骤：总体步骤和插入排序一样，寻找插入位置时使用二分查找法";

    @Override
    public void sort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            int tmp = data[i];

            int left = 0;
            int right = i - 1;
            int mid = 0;

            while (left <= right) {
                mid = (left + right) / 2;
                if (tmp < data[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            for (int j = i; j > left; j--) {
                data[j] = data[j - 1];
            }

            if (left != i) {
                data[left] = tmp;
            }
        }
    }

    @Override
    public String getTip() {
        return tip;
    }
}
