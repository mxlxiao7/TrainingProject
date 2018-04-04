package leon.training.designpattern.mvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import leon.training.BaseActivity;
import leon.training.designpattern.mvp.MVPContract;
import leon.training.designpattern.mvp.MVPPresenter;
import leon.trainingproject.R;

/**
 * Created by maxiaolong on 2017/5/25.
 */
public class MVVMActivity extends BaseActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm_design);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
