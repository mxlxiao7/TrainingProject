package leon.training.thread.multithread;

import java.util.concurrent.RecursiveTask;

import leon.training.algorithm.Logger;
import leon.training.algorithm.Utils;

/**
 * Created by leon on 2017/7/11.
 */

class SumTask extends RecursiveTask<Long> {

    static final int THRESHOLD = 500;

    long[] array;

    int start;

    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {

        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }

            Utils.msg("compute " + start + "~" + end + " =  " + sum);
            return sum;
        }

        int mid = (end + start) / 2;

        Utils.msg("split " + start + "~" + end + " ==>  " + start + "~" + mid + " , " + mid + "~" + end);


        SumTask task1 = new SumTask(this.array, start, mid);
        SumTask task2 = new SumTask(this.array, mid, end);

        invokeAll(task1, task2);

        Long result1 = task1.join();
        Long result2 = task2.join();

        Long result = result1 + result2;

        return result;
    }


}
