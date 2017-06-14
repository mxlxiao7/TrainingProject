package leon.training.designpattern.behavior.templatemethod;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/6/14.
 */

public class Student extends AbstractPerson {
    @Override
    protected void dressUp() {
        Utils.msg("穿校服");
    }

    @Override
    protected void eatBreakfast() {
        Utils.msg("吃妈妈做好的早饭");
    }

    @Override
    protected void takeThings() {
        Utils.msg("背书包，带上家庭作业和红领巾");
    }
}
