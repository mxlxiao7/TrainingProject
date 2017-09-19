package leon.training.algorithm.sortimp;

import leon.training.algorithm.Strategy;

/**
 * 希尔排序
 * <p>
 * Author:maxiaolong
 * Date:2016/11/3
 * Time:13:32
 * Email:mxlxiao7@sina.com
 */
public class SortShell implements Strategy {


    private String tip =
            "希尔排序（Shell Sort）是插入排序的一种。" +
                    "希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，" +
                    "每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。" +
                    " \n" +
                    "时间复杂度：O(nlgn)\n" +
                    "\n" +
                    "稳定性:非稳定\n" +
                    "\n" +
                    "步骤：\n" +
                    "先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。" +
                    "所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；" +
                    "然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量  =1(  <  …<d2<d1)，" +
                    "即所有记录放在同一组中进行直接插入排序为止。" +
                    "\n";


    @Override
    public void sort(int[] data) {
        for (int gap = data.length; gap > 0; gap /= 2) {
            for (int i = gap; i < data.length; i++) {
                int tmp = data[i];
                int j;
                for (j = i; j >= gap && data[j - gap] > tmp; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = tmp;
            }
        }
    }


    @Override
    public String getTip() {
        return tip;
    }
}
