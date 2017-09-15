package leon.training.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import leon.training.BaseFragment;
import leon.trainingproject.R;
import leon.trainingproject.databinding.FragmentDatabindingLayoutBinding;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class DataBindingFragment extends BaseFragment {
    private static final String TAG = DataBindingFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private Button mBtn;
    private FragmentDatabindingLayoutBinding binding;


    public DataBindingFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DataBindingFragment newInstance() {
        DataBindingFragment fragment = new DataBindingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_databinding_layout, container, false);

        mMsg = binding.tvMsg;
        mClearBtn = binding.clear;
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.setLength(0);
                helloEventBus("");
            }
        });

        mBtn = binding.btn;
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DataBindingActivity.class);
                startActivity(i);
            }
        });

        return binding.getRoot();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message) {
        s.append(message).append("\n");
        mMsg.setText(s.toString());
    }
}
