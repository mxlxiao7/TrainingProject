package leon.training.algorithm.sortimp;

import leon.training.algorithm.Strategy;

/**
 * 归并排序
 * <p>
 * Author:maxiaolong
 * Date:2016/11/3
 * Time:13:32
 * Email:mxlxiao7@sina.com
 */
public class SortMergeRecursive implements Strategy {


    private String tip =
            "归并排序（Insertion Sort）用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，" +
                    "再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。" +
                    "\n" +
                    "时间复杂度：Ο(n2)\n" +
                    "\n" +
                    "稳定性:稳定\n" +
                    "\n" +
                    "步骤：\n" +
                    "归并过程为：比较a[i]和b[j]的大小，若a[i]≤b[j]，则将第一个有序表中的元素a[i]复制到r[k]中，" +
                    "并令i和k分别加上1；否则将第二个有序表中的元素b[j]复制到r[k]中，并令j和k分别加上1，" +
                    "如此循环下去，直到其中一个有序表取完，然后再将另一个有序表中剩余的元素复制到r中从下标k到下标t的单元。" +
                    "归并排序的算法我们通常用递归实现，先把待排序区间[s,t]以中点二分，接着把左边子区间排序，" +
                    "再把右边子区间排序，最后把左区间和右区间用一次归并操作合并成有序的区间[s,t]。" +
                    "\n";

    @Override
    public void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        mergeSort(data, 0, data.length - 1);
    }

    private void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid + 1, right);
        }
    }

    private void merge(int[] data, int leftPos, int rightPos, int rightEnd) {
        //有一个临时数组
        int[] tmpArr = new int[data.length];
        int tmpPos = leftPos;
        int leftEnd = rightPos - 1;
        int copyPos = leftPos;

        //逐个比较分割后的两个数组的值，小的放入临时数组
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (data[leftPos] < data[rightPos]) {
                tmpArr[tmpPos++] = data[leftPos++];
            } else {
                tmpArr[tmpPos++] = data[rightPos++];
            }
        }

        //复制剩下的数
        while (leftPos <= leftEnd) {
            tmpArr[tmpPos++] = data[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArr[tmpPos++] = data[rightPos++];
        }

        //将排序过得临时数组复制回
        while (copyPos <= rightEnd) {
            data[copyPos] = tmpArr[copyPos];
            copyPos++;
        }
    }


    @Override
    public String getTip() {
        return tip;
    }
}
