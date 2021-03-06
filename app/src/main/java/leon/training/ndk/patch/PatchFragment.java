package leon.training.ndk.patch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import leon.training.BaseFragment;
import leon.training.utils.Utils;
import leon.trainingproject.R;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class PatchFragment extends BaseFragment {

    private static final String TAG = PatchFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private TextView mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private TextView mBtn0;
    private TextView mBtn1;


    public PatchFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PatchFragment newInstance() {
        PatchFragment fragment = new PatchFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMsg.postDelayed(new Runnable() {
            @Override
            public void run() {
                //显示当前版本号
                Utils.msg("当前版本号： " + Utils.getAppVersionCode(PatchFragment.this.getContext()));
            }
        },1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ndk_patch_layout, container, false);
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
                Client.diff();
            }
        });

        mBtn1 = (TextView) rootView.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.patch(getContext());
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
