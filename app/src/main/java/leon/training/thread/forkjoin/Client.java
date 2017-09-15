package leon.training.thread.forkjoin;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import leon.training.algorithm.Creator;
import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/25.
 */

class Client {

    public static void main() {


        int[] tmp = Creator.randomArray(1, 4000, 4000);
        long[] array = new long[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            array[i] = tmp[i];
        }

        Utils.msg("Creator array-length: " + array.length);

        ForkJoinPool pool = new ForkJoinPool(4);
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = pool.invoke(task);
        long endTime = System.currentTimeMillis();

        Utils.msg("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }


}
