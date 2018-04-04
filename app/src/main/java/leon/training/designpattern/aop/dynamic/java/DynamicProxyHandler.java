package leon.training.designpattern.aop.dynamic.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import leon.training.utils.Utils;

/**
 * @author maxiaolong3
 * @version V1.0
 * @description:
 * @date 2018/4/4 下午12:00
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object real;

    public DynamicProxyHandler(Object real) {
        this.real = real;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Utils.msg("DynamicProxy - before");
        Object invoke = method.invoke(real, args);
        Utils.msg("DynamicProxy - after");
        return invoke;
    }
}
