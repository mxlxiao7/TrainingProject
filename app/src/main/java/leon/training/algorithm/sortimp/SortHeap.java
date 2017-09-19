package leon.training.algorithm.sortimp;

import leon.training.algorithm.Strategy;
import leon.training.utils.Utils;

/**
 * 堆排序
 * <p>
 * Author:maxiaolong
 * Date:2016/11/3
 * Time:13:32
 * Email:mxlxiao7@sina.com
 */
public class SortHeap implements Strategy {


    private String tip =
            "堆排序（Insertion Sort）堆排序利用了大根堆（或小根堆）堆顶记录的关键字最大（或最小）这一特征，" +
                    "使得在当前无序区中选取最大（或最小）关键字的记录变得简单。" +
                    "\n" +
                    "时间复杂度：O(nlgn)\n" +
                    "\n" +
                    "稳定性:不稳定\n" +
                    "\n" +
                    "步骤：\n" +
                    "① 先将初始文件R[1..n]建成一个大根堆，此堆为初始的无序区\n" +
                    "② 再将关键字最大的记录R[1]（即堆顶）和无序区的最后一个记录R[n]交换，由此得到新的无序区R[1..n-1]和有序区R[n]，且满足R[1..n-1].keys≤R[n].key\n" +
                    "③由于交换后新的根R[1]可能违反堆性质，故应将当前无序区R[1..n-1]调整为堆。然后再次将R[1..n-1]中关键字最大的记录R[1]和该区间的最后一个记录R[n-1]交换，由此得到新的无序区R[1..n-2]和有序区R[n-1..n]，且仍满足关系R[1..n-2].keys≤R[n-1..n].keys，同样要将R[1..n-2]调整为堆。" +
                    "\n" +
                    "一般用数组来表示堆，若根结点存在序号0处， i结点的父结点下标就为(i-1)/2。i结点的左右子结点下标分别为2*i+1和2*i+2。" +
                    "\n";

    @Override
    public void sort(int[] data) {
        heapSort(data);
    }

    private void heapSort(int[] data) {
        int size = data.length;
        for (int i = 0; i < size; i++) {
            createMaxHeap(data, size - i - 1);

            //最大元素在0位置，要把最大元素放在最后
            Utils.swap(data, 0, size - i - 1);
        }
    }

    /**
     * 构建大堆
     *
     * @param data
     * @param last
     */
    public void createMaxHeap(int[] data, int lastIndex) {

        /**
         * 一般用数组来表示堆，若根结点存在序号0处， i结点的父结点下标就为(i-1)/2。
         * i结点的左右子结点下标分别为2*i+1和2*i+2。
         */

        //(lastIndex - 1) / 2  从最后节点的父节点开始遍历
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //顶点元素下标
            int tmp = i;
            while (tmp * 2 + 1 <= lastIndex) {

                //找到最后孩子中大的一个的下标
                int big = tmp * 2 + 1;
                if (big < lastIndex && data[big] < data[big + 1]) {
                    big++;
                }

                //父节点和较大的孩子节点比较，如果父节点小，就交换, 如果大就break
                if (data[tmp] < data[big]) {
                    Utils.swap(data, tmp, big);
                    tmp = big;
                } else {
                    break;
                }
            }
        }
    }
    
    @Override
    public String getTip() {
        return tip;
    }
}
