package leon.training.ndk.patch;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.File;


import leon.training.utils.ApkUtils;
import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/25.
 */

class Client {
    static {
        System.loadLibrary("bsdiff");
    }


    /**
     * 做文件查分
     */
    public static native int bsdiff(String oldApkPath, String newApkPath, String patchPath);

    /**
     * 补丁
     */
    public static native int bspatch(String oldApkPath, String newApkPath, String patchPath);


    public static final String DIR = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "Patch";


    public static void diff() {
        Utils.msg("生成补丁包...");
        final String oldFile = DIR + File.separator + "old.apk";
        final String newFile = DIR + File.separator + "new.apk";
        final String patchFile = DIR + File.separator + "apk.patch";

        if (!new File(oldFile).exists()) {
            Utils.msg("oldFile not exist");
            return;
        }

        if (!new File(newFile).exists()) {
            Utils.msg("newFile not exist");
            return;
        }

        Utils.msg(oldFile);
        Utils.msg(newFile);
        Utils.msg(patchFile);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //2.合并得到最新版本的APK文件
                bsdiff(oldFile, newFile, patchFile);
                Utils.msg("生成完成");
            }
        }).start();
    }

    public static void patch(final Context context) {
        Utils.msg("开始补丁...");
        final String oldFile = ApkUtils.getSourceApkPath(context,context.getPackageName());
        final String newFile = DIR + File.separator + "patched.apk";
        final String patchFile = DIR + File.separator + "apk.patch";

        if (!new File(oldFile).exists()) {
            Utils.msg("oldFile not exist");
            return;
        }

        if (!new File(patchFile).exists()) {
            Utils.msg("patchFile not exist");
            return;
        }

        Utils.msg(oldFile);
        Utils.msg(newFile);
        Utils.msg(patchFile);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //2.合并得到最新版本的APK文件
                bspatch(oldFile, newFile, patchFile);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        ApkUtils.installApk(context, newFile);
                        Utils.msg("完成合并");
                    }
                });
            }
        }).start();
    }
}
