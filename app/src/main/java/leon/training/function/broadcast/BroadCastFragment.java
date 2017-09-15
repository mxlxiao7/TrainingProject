package leon.training.function.broadcast;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
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
import leon.training.utils.Utils;
import leon.training.designpattern.structure.adapter.AdapterFragment;
import leon.trainingproject.R;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class BroadCastFragment extends BaseFragment {

    private static final String TAG = AdapterFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private Button mBtn;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;

    public static final String DYN_ACTION = "dyn_action";
    public static final String STA_ACTION = "sta_action";
    public static final String ORDER_ACTION = "order_action";


    public BroadCastFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BroadCastFragment newInstance() {
        BroadCastFragment fragment = new BroadCastFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //广播顺序
        IntentFilter orderFilter = new IntentFilter();
        orderFilter.addAction(ORDER_ACTION);
        getActivity().registerReceiver(mOrderBroadcast, orderFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            getActivity().unregisterReceiver(mOrderBroadcast);
            getActivity().unregisterReceiver(mDynBroadcast);
        }catch (Exception e){

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_broadcast_layout, container, false);
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
        mBtn.setOnClickListener(new View.OnClickListener() {//注册动态广播
            @Override
            public void onClick(View view) {
                IntentFilter mDynIntentFilter = new IntentFilter();
                mDynIntentFilter.addAction(DYN_ACTION);
                getActivity().registerReceiver(mDynBroadcast, mDynIntentFilter);
            }
        });

        mBtn1 = (Button) rootView.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {//发送动态广播
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(DYN_ACTION);
                getActivity().sendBroadcast(intent);
            }
        });

        mBtn2 = (Button) rootView.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {//注销静态广播
            @Override
            public void onClick(View view) {
                getActivity().getPackageManager().setComponentEnabledSetting(
                        new ComponentName(getActivity().getPackageName(), DisableReceiver.class.getName()),
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP);
            }
        });

        mBtn3 = (Button) rootView.findViewById(R.id.btn3);
        mBtn3.setOnClickListener(new View.OnClickListener() {//发送静态广播
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(STA_ACTION);
                getActivity().sendBroadcast(intent);
            }
        });

        mBtn4 = (Button) rootView.findViewById(R.id.btn4);
        mBtn4.setOnClickListener(new View.OnClickListener() {//发送静态广播
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(ORDER_ACTION);
                getActivity().sendBroadcast(intent);
            }
        });
        return rootView;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message) {
        s.append(message).append("\n");
        mMsg.setText(s.toString());
    }

    private BroadcastReceiver mDynBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Utils.msg("DynBroadcast=>" + intent.getAction().toString());
        }
    };

    private BroadcastReceiver mOrderBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Utils.msg("OrderDYNBroadcast=>" + intent.getAction().toString());
        }
    };
}
