package leon.training.ndk.hotfix;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import java.io.File;

import leon.training.utils.ApkUtils;
import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/25.
 */

class DexFix {

    static {
        System.loadLibrary("bsdiff");
    }





}
