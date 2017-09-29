package leon.training.function.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
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
import leon.trainingproject.R;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class AidlFragment extends BaseFragment {

    private static final String TAG = AidlFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView textView1;
    private TextView mMsg;
    private Button mBtn;
    private Button mBtn0;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private IServieInterface mService;

    /**
     * 连接
     */
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IServieInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

    /**
     * 回调
     */
    private Controler mControler = new Controler.Stub() {
        @Override
        public void start() throws RemoteException {
            Utils.msg("服务已启动");
        }

        @Override
        public void stop() throws RemoteException {
            Utils.msg("服务已停止");
        }

        @Override
        public void action(int index) throws RemoteException {
            Utils.msg("执行时间" + index + "s");
        }
    };


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static AidlFragment newInstance() {
        AidlFragment fragment = new AidlFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (connection != null) {
            getActivity().unbindService(connection);
            connection = null;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_function_aidl_layout, container, false);
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
                Intent intent = new Intent();
                intent.setAction("leon.training.function.aidl.AIDLService");
                //从 Android 5.0开始 隐式Intent绑定服务的方式已不能使用,所以这里需要设置Service所在服务端的包名
                intent.setPackage("leon.trainingproject");
                getActivity().bindService(intent, connection, Context.BIND_AUTO_CREATE);
            }
        });

        mBtn0 = (Button) rootView.findViewById(R.id.btn0);
        mBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String str = mService.getServiceName();
                    Utils.msg(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        mBtn1 = (Button) rootView.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String str = mService.getInfo().getName();
                    Utils.msg(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });


        mBtn2 = (Button) rootView.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //注册
                try {
                    mService.registControler(mControler);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        mBtn3 = (Button) rootView.findViewById(R.id.btn3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //注销
                try {
                    mService.unRegistControler(mControler);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        mBtn4 = (Button) rootView.findViewById(R.id.btn4);
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //启动任务
                try {
                    mService.doTask();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
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
