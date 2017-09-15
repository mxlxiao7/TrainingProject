package leon.training.ndk.hotfix;

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
 *
 * 分两种:
 * 1.dex合并修复
 *   1.用dex工具生成补丁包 patch.dex
 *   2.客户端下载合并
 *   3.在application中也要做修复工作，保证退出后重新进入可修复
 *
 * 2.native层合并修复
 *
 *
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class HotFixFragment extends BaseFragment {

    private static final String TAG = HotFixFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private TextView mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private TextView mBtn0;
    private TextView mBtn1;


    public HotFixFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HotFixFragment newInstance() {
        HotFixFragment fragment = new HotFixFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ndk_hotfix_layout, container, false);
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

            }
        });

        mBtn1 = (TextView) rootView.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
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
