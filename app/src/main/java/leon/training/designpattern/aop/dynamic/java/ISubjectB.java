package leon.training.designpattern.aop.dynamic.java;



/**
 * Created by maxiaolong on 2017/6/5.
 */

public interface ISubjectB {

    /**
     * 注解在代理方法中也能拿到
     * @param a
     * @param b
     * @return
     */
    @Deprecated
    public int add(int a, int b);



    public int del();
}
