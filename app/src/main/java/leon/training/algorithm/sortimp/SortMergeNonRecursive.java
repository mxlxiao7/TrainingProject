package leon.training.algorithm.sortimp;

import leon.training.algorithm.Strategy;

/**
 * 归并排序
 * <p/>
 * Author:maxiaolong
 * Date:2016/11/3
 * Time:13:32
 * Email:mxlxiao7@sina.com
 */
public class SortMergeNonRecursive implements Strategy {


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
        mergeSort(data);
    }


    public void mergeSort(int[] data) {
        int[] tmpArr = new int[data.length];
        int len = 1;
        while (len < data.length) {
            for (int i = 0; i < data.length; i += 2 * len) {
                merge(data, tmpArr, i, i + len, i + len * 2 - 1);
            }
            len *= 2;
        }
    }

    private void merge(int[] data, int[] tmpArr, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int count = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd && rightPos < data.length) {
            if (data[leftPos] < data[rightPos]) {
                tmpArr[tmpPos++] = data[leftPos++];
            } else {
                tmpArr[tmpPos++] = data[rightPos++];
            }
        }

        while (leftPos <= leftEnd && leftPos < data.length) {
            tmpArr[tmpPos++] = data[leftPos++];
        }

        while (rightPos <= rightEnd && rightPos < data.length) {
            tmpArr[tmpPos++] = data[rightPos++];
        }

        for (int i = 0; i < count; i++) {
            if (rightEnd < data.length) {
                data[rightEnd] = tmpArr[rightEnd];
            }
            rightEnd--;
        }
    }


    @Override
    public String getTip() {
        return tip;
    }
}
