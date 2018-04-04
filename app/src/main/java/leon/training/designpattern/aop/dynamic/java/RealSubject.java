package leon.training.designpattern.aop.dynamic.java;

import leon.training.utils.Utils;

/**
 * @author maxiaolong3
 * @version V1.0
 * @description:
 * @date 2018/4/4 下午12:00
 */
public class RealSubject implements ISubjectB, ISubjectA {

    @Override
    public int add(int a, int b) {
        Utils.msg("RealTest - add()");
        return a + b;
    }

    @Override
    public int del() {
        Utils.msg("RealTest - del()");
        return 0;
    }

    @Override
    public int sum(int a, int b) {
        Utils.msg("RealTest - sum()");
        return a + b;
    }
}
