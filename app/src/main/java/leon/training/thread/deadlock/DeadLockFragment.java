package leon.training.thread.deadlock;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import leon.training.BaseFragment;
import leon.training.designpattern.structure.adapter.AdapterFragment;
import leon.trainingproject.R;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class DeadLockFragment extends BaseFragment {

    private static final String TAG = AdapterFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private TextView mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private TextView mBtn0;
    private TextView mBtn1;
    private TextView mBtn2;
    private TextView mBtn3;
    private TextView mBtn4;

    public DeadLockFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DeadLockFragment newInstance() {
        DeadLockFragment fragment = new DeadLockFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_thread_dead_lock_layout, container, false);
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
                Client.main();
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
