package leon.training.designpattern.structure.proxy.dynamic;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import leon.training.BaseFragment;

import leon.training.utils.Utils;
import leon.trainingproject.R;
import leon.trainingproject.databinding.FragmentDynamicProxyLayoutBinding;
import retrofit2.http.GET;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class DynamicProxyFragment extends BaseFragment {
    private static final String TAG = DynamicProxyFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView mTextView;
    private TextView mMsg;
    private Button mBtn;
    private FragmentDynamicProxyLayoutBinding mBinding;

    public DynamicProxyFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DynamicProxyFragment newInstance() {
        DynamicProxyFragment fragment = new DynamicProxyFragment();
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
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dynamic_proxy_layout, container, false);

        mMsg = mBinding.tvMsg;
        mClearBtn = mBinding.clear;
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.setLength(0);
                helloEventBus("");
            }
        });

        mBtn = mBinding.btn;
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ITest test = (ITest) Proxy.newProxyInstance(getClass().getClassLoader(),
                        new Class[]{ITest.class},
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                Integer a = (Integer) args[0];
                                Integer b = (Integer) args[1];
                                Utils.msg("方法名：" + method.getName());
                                Utils.msg("参数：" + a + " , " + b);

                                GET get = method.getAnnotation(GET.class);
                                Utils.msg("注解：" + get.value());
                                return null;
                            }
                        });
                test.add(5, 6);
                test.add(7, 6);
            }
        });

        return mBinding.getRoot();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message) {
        s.append(message).append("\n");
        mMsg.setText(s.toString());
    }
}
