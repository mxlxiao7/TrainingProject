package leon.training.leaks;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import leon.training.BaseActivity;

/**
 * Created by maxiaolong on 2017/5/25.
 */

public class LeakActivity extends BaseActivity {

    public static final List<Activity> ACTIVITY_CACHE = new ArrayList<Activity>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ACTIVITY_CACHE.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
