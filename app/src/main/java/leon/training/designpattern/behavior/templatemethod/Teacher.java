package leon.training.designpattern.behavior.templatemethod;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/6/14.
 */

public class Teacher extends AbstractPerson {
    @Override
    protected void dressUp() {
        Utils.msg("穿工作服");
    }

    @Override
    protected void eatBreakfast() {
        Utils.msg("做早饭，照顾孩子吃早饭");
    }

    @Override
    protected void takeThings() {
        Utils.msg("带上昨晚准备的考卷");
    }
}