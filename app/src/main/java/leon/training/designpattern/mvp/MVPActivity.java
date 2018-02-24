package leon.training.designpattern.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import leon.training.BaseActivity;
import leon.trainingproject.R;

/**
 * Created by maxiaolong on 2017/5/25.
 */
public class MVPActivity extends BaseActivity implements MVPContract.View {

    private MVPContract.Presenter mPresenter;
    private TextView tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_design);

        tv = (TextView) findViewById(R.id.tv_msg);

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");
            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.delayPost(4);
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.msg("发送了一个消息");
            }
        });

        new MVPPresenter(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void setPresenter(MVPContract.Presenter presenter) {
        this.mPresenter = presenter;
    }


    @Override
    public void showLocalToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
