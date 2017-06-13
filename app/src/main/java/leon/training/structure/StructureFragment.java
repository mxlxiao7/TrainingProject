package leon.training.structure;

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

import java.util.LinkedList;

import leon.training.BaseFragment;
import leon.training.structure.list.MDLinkedList;
import leon.training.structure.list.MSLinkedList;
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
public class StructureFragment extends BaseFragment {

    private static final String TAG = StructureFragment.class.getSimpleName();
    private static final String ARG_SECTION_NUMBER = "section_number";
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private Button mBtn;
    private Button mBtn1;
    private Button mBtn2;

    public StructureFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static StructureFragment newInstance() {
        StructureFragment fragment = new StructureFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_structure_layout, container, false);
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
                MSLinkedList.main();
            }
        });
        mBtn1 = (Button) rootView.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MDLinkedList.main();
            }
        });

        mBtn2 = (Button) rootView.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CylicBarrierUtil.doAction();
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