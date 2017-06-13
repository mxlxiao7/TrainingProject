package leon.training.designpattern.create.builder;

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
public class BuilderFragment extends BaseFragment {

    private static final String TAG = BuilderFragment.class.getSimpleName();
    private static final String ARG_SECTION_NUMBER = "section_number";
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private Button mBtn;

    public BuilderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BuilderFragment newInstance() {
        BuilderFragment fragment = new BuilderFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_method_builder_layout, container, false);
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
                // 对于客户端而言，只需要关心具体的建造者，无需关心产品内部构建流程。我如果需要其他的复杂产品对象，只需要选择其他的建造者，如果需要扩展，则只需要写一个新的builder就行。如果可以，这个建造者甚至可以用配置文件做，增加更多的扩展性。
                IBuilder builder = new Builder();
                // 把建造者注入导演
                Client director = new Client(builder);
                // 指挥者负责流程把控
                director.construct();
                // 建造者返回一个组合好的复杂产品对象
                Productor productor = builder.build();
                helloEventBus(productor.toString());
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