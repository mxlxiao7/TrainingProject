package leon.training.designpattern.structure.component;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/5.
 */

public class Leaf extends Component {

    // 叶子节点不具备添加的能力，所以不实现
    @Override
    public void add(Component c) {
        //do nothing
    }

    // 叶子节点不具备添加的能力必然也不能删除
    @Override
    public void remove(Component c) {
        //do nothing
    }

    // 叶子节点没有子节点所以显示自己的执行结果
    @Override
    public void eachChild() {
        Utils.msg(name + "执行了");
    }
}
