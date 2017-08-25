package leon.training.ndk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import leon.training.BaseFragment;
import leon.trainingproject.R;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class NDKFragment extends BaseFragment {

    private static final String TAG = NDKFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private Button mBtn;
    private Button mBtn0;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn7;
    private Button mBtn8;
    private Button mBtn9;

    public NDKFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NDKFragment newInstance() {
        NDKFragment fragment = new NDKFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ndk_layout, container, false);
        mMsg = (TextView) rootView.findViewById(R.id.tv_msg);
        mClearBtn = (Button) rootView.findViewById(R.id.clear);
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.setLength(0);
                helloEventBus("");
            }
        });

        mBtn = (Button) rootView.findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.read();
            }
        });

        mBtn0 = (Button) rootView.findViewById(R.id.btn0);
        mBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.readJavaAtt();
            }
        });

        mBtn1 = (Button) rootView.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.modifyJavaAtt();
            }
        });

        mBtn2 = (Button) rootView.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.invokedMethod();
            }
        });

        mBtn3 = (Button) rootView.findViewById(R.id.btn3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.invokeTime();
            }
        });

        mBtn4 = (Button) rootView.findViewById(R.id.btn4);
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.invokeSuper();
            }
        });

        mBtn5 = (Button) rootView.findViewById(R.id.btn5);
        mBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.strIssue();
            }
        });

        mBtn6 = (Button) rootView.findViewById(R.id.btn6);
        mBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.passArray();
            }
        });

        mBtn7 = (Button) rootView.findViewById(R.id.btn7);
        mBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.archiveArray();
            }
        });
        mBtn8 = (Button) rootView.findViewById(R.id.btn8);
        mBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.optimizeRef();
            }
        });
        mBtn9 = (Button) rootView.findViewById(R.id.btn9);
        mBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.jniException();
            }
        });
        return rootView;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message) {
        s.append(message).append("\n");
        mMsg.setText(s.toString());
    }
}
