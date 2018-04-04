package leon.training.designpattern.aop.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

import leon.training.utils.Utils;

/**
 * @author maxiaolong3
 * @version V1.0
 * @description:
 * @date 2018/4/4 下午3:15
 */
public class SubjectProxy implements MethodInterceptor {

    /**
     *
     * @param object          表示要进行增强的对象
     * @param method          表示拦截的方法
     * @param objects         数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
     * @param methodProxy     表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Utils.msg("Before Method Invoke");
        methodProxy.invokeSuper(object, objects);
        Utils.msg("After Method Invoke");
        return object;
    }



}
