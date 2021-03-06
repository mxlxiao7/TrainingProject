package leon.training.algorithm.recursion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class AlgorithmFragment extends BaseFragment {

    private static final String TAG = AlgorithmFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private TextView mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private TextView mBtn0;
    private TextView mBtn1;
    private TextView mBtn2;
    private TextView mBtn3;
    private TextView mBtn4;

    public AlgorithmFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static AlgorithmFragment newInstance() {
        AlgorithmFragment fragment = new AlgorithmFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_algorithm_layout, container, false);
        mMsg = (TextView) rootView.findViewById(R.id.tv_msg);
        mClearBtn = (TextView) rootView.findViewById(R.id.clear);
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.setLength(0);
                helloEventBus("");
            }
        });

        mBtn0 = (TextView) rootView.findViewById(R.id.btn0);
        mBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] data = {99, 33};
                Gcd.main(data);
            }
        });

        mBtn1 = (TextView) rootView.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtn2 = (TextView) rootView.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtn3 = (TextView) rootView.findViewById(R.id.btn3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtn4 = (TextView) rootView.findViewById(R.id.btn4);
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
