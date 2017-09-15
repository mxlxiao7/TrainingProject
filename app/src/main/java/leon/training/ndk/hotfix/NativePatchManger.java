package leon.training.ndk.hotfix;

import android.content.Context;

import java.io.File;

/**
 * Created by leon on 2017/9/15.
 */

public class NativePatchManger {

    private Context mContext;
//    private NativeManger mManger;

    public NativePatchManger(Context context) {
        this.mContext = context;
    }

    private void init() {
//        mManger = new NativeManger();
    }

    public void loadPatch(String path) {
        File file = new File(path);
        NativePatch patch = new NativePatch(mContext, file);
        loadPatch(patch);
    }

    private void loadPatch(NativePatch patch) {


    }

}
