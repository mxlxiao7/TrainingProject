package leon.training.ndk.splistmerge;


import android.os.Environment;

import java.io.File;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/25.
 */

class Client {

    /*************************native start*********************************/
    static {
        System.loadLibrary("native-c");
    }

    /**
     * 读取属性
     *
     * @return
     */
    public native static int splitFile(String src, String pattern, int num);

    public native static int mergeFile(String target, String pattern, int num);


    /*************************native end**********************************/


    /**
     * 读取
     */
    public static void split() {
        String path = Environment.getExternalStorageDirectory() + File.separator + "Download" + File.separator;
        String srcPath = path + "video.mp4";
        int num = 5;
        String pattern = path + "video_%d.mp4";
        File file = new File(srcPath);
        if (!file.exists()) {
            Utils.msg("目标文件不存在");
            return;
        }

        Utils.msg("文件大小：" + file.length());
        Utils.msg("开始分割文件： " + srcPath);
        Utils.msg("分割数量： " + num);
        splitFile(srcPath, pattern, num);
        Utils.msg("分割完毕...");
    }

    public static void merge() {
        String path = Environment.getExternalStorageDirectory() + File.separator + "Download" + File.separator;
        String targetPath = path + "video_merge.mp4";
        int num = 5;
        String pattern = path + "video_%d.mp4";
        Utils.msg("开始合并文件： " + targetPath);
        Utils.msg("合并数量： " + num);
        mergeFile(targetPath, pattern, num);
        Utils.msg("合并完毕...");
    }

}
