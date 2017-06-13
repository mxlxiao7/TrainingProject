package leon.training.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import leon.training.BaseFragment;
import leon.training.algorithm.Utils;
import leon.training.trycatch.Condition;
import leon.trainingproject.R;

/**
 * Created by maxiaolong on 2016/11/28.
 */
public class ViewFragment extends BaseFragment {

    private static final String TAG = ViewFragment.class.getSimpleName();
    private static final String ARG_SECTION_NUMBER = "section_number";
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private Button mBtn;
    private LinearLayout mContainer;

    public static int i = 0;

    public ViewFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ViewFragment newInstance() {
        ViewFragment fragment = new ViewFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_view_layout, container, false);
        mContainer = (LinearLayout) rootView.findViewById(R.id.container);
        mMsg = (TextView) rootView.findViewById(R.id.tv_msg);
        mClearBtn = (Button) rootView.findViewById(R.id.clear);
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.setLength(0);
                helloEventBus("");
                for (; ; ) {
                    if (mContainer.getChildCount() <= 1) {
                        break;
                    }
                    View child = mContainer.getChildAt(0);
                    if (child.getId() != R.id.tv_msg) {
                        mContainer.removeView(child);
                    }
                }
            }
        });
        mBtn = (Button) rootView.findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                final MyTextView tv = new MyTextView(mContainer.getContext());
                tv.setText("我是谁");
                tv.setTextColor(Color.BLUE);
                tv.setLayoutParams(p);
                mContainer.addView(tv, 0);

                mContainer.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int[] location = new int[2];
                        tv.getLocationInWindow(location);
                        Utils.msg("LocationInWindow " + location[0] + "," + +location[1]);
                        tv.getLocationOnScreen(location);
                        Utils.msg("LocationOnScreen " + location[0] + "," + +location[1]);
                    }
                }, 2000);
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