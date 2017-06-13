package leon.training.trycatch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import leon.training.BaseFragment;
import leon.training.thread.countdownlatch.CountDownLatchDemo;
import leon.training.thread.cylicbarrier.CylicBarrierUtil;
import leon.training.thread.pc.PCUtil;
import leon.training.thread.phaser.PhaserUtil;
import leon.training.thread.semaphore.SemaphoreUtil;
import leon.training.thread.termination.TerminateLock;
import leon.trainingproject.R;

/**
 * Created by maxiaolong on 2016/11/28.
 */
public class TryCatchFragment extends BaseFragment {

    private static final String TAG = TryCatchFragment.class.getSimpleName();
    private static final String ARG_SECTION_NUMBER = "section_number";
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private Button mBtn;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;

    public TryCatchFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TryCatchFragment newInstance() {
        TryCatchFragment fragment = new TryCatchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        View rootView = inflater.inflate(R.layout.fragment_trycatch_layout, container, false);
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
                helloEventBus("\n返回值 = " + Condition.condition1());
            }
        });


        mBtn1 = (Button) rootView.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloEventBus("\n返回值 = " + Condition.condition2());
            }
        });


        mBtn2 = (Button) rootView.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloEventBus("\n返回值 = " + Condition.condition3());
            }
        });


        mBtn3 = (Button) rootView.findViewById(R.id.btn3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloEventBus("\n返回值 = " + Condition.condition4());
            }
        });


        mBtn4 = (Button) rootView.findViewById(R.id.btn4);
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloEventBus("\n返回值 = " + Condition.condition5());
            }
        });


        mBtn5 = (Button) rootView.findViewById(R.id.btn5);
        mBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloEventBus("\n返回值 = " + Condition.condition6());
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