package leon.training.designpattern.create.factory.method;

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
 * Created by maxiaolong on 2016/11/28.
 */
public class MethodFactoryFragment extends BaseFragment {

    private static final String TAG = MethodFactoryFragment.class.getSimpleName();
    private static final String ARG_SECTION_NUMBER = "section_number";
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private Button mBtn;

    public MethodFactoryFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MethodFactoryFragment newInstance() {
        MethodFactoryFragment fragment = new MethodFactoryFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_method_factory_layout, container, false);
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
                //520档产品
                IFactory f = new FactoryBMW520();
                f.createBMW().doAction();

                //320档产品
                f = new FactoryBMW320();
                f.createBMW().doAction();
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