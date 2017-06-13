package leon.training.designpattern.structure.component;

import java.util.ArrayList;
import java.util.List;

import leon.training.algorithm.Utils;

/**
 * Created by maxiaolong on 2017/5/5.
 */

public class Composite extends Component {

    // 用来保存节点的子节点
    List<Component> list = new ArrayList<Component>();

    // 添加节点 添加部件
    @Override
    public void add(Component c) {
        list.add(c);
    }

    // 删除节点 删除部件
    @Override
    public void remove(Component c) {
        list.remove(c);
    }

    // 遍历子节点
    @Override
    public void eachChild() {
        Utils.msg(name + "执行了");
        for (Component c : list) {
            c.eachChild();
        }
    }




}
