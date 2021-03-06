package leon.training.function.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import leon.training.BaseActivity;
import leon.training.utils.Utils;
import leon.trainingproject.R;

/**
 * Created by maxiaolong on 2017/5/31.
 */

public class Activity1 extends BaseActivity implements View.OnClickListener {
    private Button btn_open1, btn_open2, btn_open3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        setTitle("Activity1");

        //在日志中输出栈ID
        Utils.msg("Activity1的栈ID：" + getTaskId() + "");
        btn_open1 = (Button) findViewById(R.id.button1);
        btn_open2 = (Button) findViewById(R.id.button2);
        btn_open3 = (Button) findViewById(R.id.button3);
        btn_open1.setOnClickListener(this);
        btn_open2.setOnClickListener(this);
        btn_open3.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Utils.msg("Activity1 onDestroy()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, Activity1.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, Activity2.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, Activity3.class));
                break;
        }
    }
}
