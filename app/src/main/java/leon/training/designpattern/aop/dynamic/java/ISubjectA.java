package leon.training.designpattern.aop.dynamic.java;


import io.reactivex.annotations.NonNull;

/**
 * Created by maxiaolong on 2017/6/5.
 */

public interface ISubjectA {

    /**
     * 注解在代理方法中也能拿到
     *
     * @param a
     * @param b
     * @return
     */
    @NonNull
    public int sum(int a, int b);


}
