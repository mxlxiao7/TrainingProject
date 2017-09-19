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
public class SortInsert implements Strategy {


    private String tip = "插入排序（Insertion Sort）的算法描述是一种简单直观的排序算法。" +
            "它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，" +
            "找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），" +
            "因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。\n" +
            " \n" +
            "时间复杂度：Ο(n2)\n" +
            "\n" +
            "稳定性:稳定\n" +
            "\n" +
            "步骤：\n" +
            "从第一个元素开始，该元素可以认为已经被排序\n" +
            "取出下一个元素，在已经排序的元素序列中从后向前扫描\n" +
            "如果该元素（已排序）大于新元素，将该元素移到下一位置\n" +
            "重复步骤3，直到找到已排序的元素小于或者等于新元素的位置\n" +
            "将新元素插入到该位置中\n" +
            "重复步骤2\n" +
            "\n";

    @Override
    public void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];//等待插入到前面的有序数组
            int j;
            for (j = i; j > 0 && data[j - 1] > tmp; j--) {
                data[j] = data[j - 1];
            }
            data[j] = tmp;
        }
    }

    @Override
    public String getTip() {
        return tip;
    }
}
