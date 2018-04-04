package leon.training.designpattern.aop.dynamic.cglib;

import leon.training.utils.Utils;

/**
 * @author maxiaolong3
 * @version V1.0
 * @description:
 * @date 2018/4/4 下午3:13
 */
public class Subject {

    public void update() {
        Utils.msg("Subject - update()");
    }

    public void select() {
        Utils.msg("Subject - select()");
    }

}
