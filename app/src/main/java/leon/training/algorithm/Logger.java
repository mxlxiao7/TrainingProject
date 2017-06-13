
package leon.training.algorithm;

import android.util.Log;

public class Logger {

    private static final String TAG = Logger.class.getSimpleName();

    /**
     * 打印
     *
     * @param data
     */
    public static String d(int[] data) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                str.append("[" + data[i] + ",");
            } else if (i > 0 && i < data.length - 1) {
                str.append(data[i] + ",");
            } else if (i == data.length - 1) {
                str.append(data[i] + "]");
            }
        }
        Log.e(TAG, str.toString());
        return str.toString();
    }


    /**
     * 打印
     *
     * @param data
     */
    public static void d(String str) {
        Log.e(TAG, str);
    }
}
