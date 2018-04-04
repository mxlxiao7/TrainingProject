package leon.training.designpattern.aop.dynamic;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import net.sf.cglib.proxy.Enhancer;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import leon.training.BaseFragment;
import leon.training.designpattern.aop.dynamic.aspectJ.DebugTrace;
import leon.training.designpattern.aop.dynamic.java.ISubjectA;
import leon.training.designpattern.aop.dynamic.cglib.Subject;
import leon.training.designpattern.aop.dynamic.cglib.SubjectProxy;
import leon.training.designpattern.aop.dynamic.java.DynamicProxyHandler;
import leon.training.designpattern.aop.dynamic.java.ISubjectB;
import leon.training.designpattern.aop.dynamic.java.RealSubject;
import leon.training.utils.Utils;
import leon.trainingproject.R;
import leon.trainingproject.databinding.FragmentDynamicProxyLayoutBinding;

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
    private FragmentDynamicProxyLayoutBinding mBinding;
    private Button mBtn;
    private Button mBtn1;
    private Button mBtn2;


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

        /**
         * Java动态代理
         */
        mBtn = mBinding.btn;
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                javaProxy();
            }
        });

        /**
         * CGLIB动态代理
         */
        mBtn1 = mBinding.btn1;
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cglibProxy();
            }
        });


        /**
         * aspectJ
         */
        mBtn2 = mBinding.btn2;
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aspectJProxy();
            }
        });


        return mBinding.getRoot();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message) {
        s.append(message).append("\n");
        mMsg.setText(s.toString());
    }

    /**
     *
     */
    void javaProxy() {
        /**
         * 接口
         */
        ISubjectB subject = (ISubjectB) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{ISubjectB.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Integer a = (Integer) args[0];
                        Integer b = (Integer) args[1];
                        Utils.msg("方法名：" + method.getName());
                        Utils.msg("参数：" + a + " , " + b);

                        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                        for (Annotation anno : declaredAnnotations) {
                            Utils.msg("注解：" + anno.toString());
                        }
                        return a + b;
                    }
                });

        subject.add(5, 6);


        /**
         * 传入具体类
         */
        RealSubject realTest = new RealSubject();
        DynamicProxyHandler handler = new DynamicProxyHandler(realTest);

        /**
         * @param   loader the class loader to define the proxy class
         * @param   interfaces 这里必须是接口
         * @param   h
         */
        Object proxy = Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),
                realTest.getClass().getInterfaces(),
                handler);
        /**
         * 这个代理对象只能转换成接口，不能转换为具体对象
         */
        ((ISubjectA) proxy).sum(1, 2);
        ((ISubjectB) proxy).add(1, 2);
        ((ISubjectB) proxy).del();
    }

    /**
     * 在android无法使用
     */
    void cglibProxy() {
        SubjectProxy proxy = new SubjectProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Subject.class);
        enhancer.setCallback(proxy);
        Subject dao = (Subject) enhancer.create();
        dao.update();
        dao.select();
    }

    /**
     * 支持编译期和加载时代码注入
     */
    @DebugTrace
    private void aspectJProxy() {
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
