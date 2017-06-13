package leon.training.designpattern.structure.component;

/**
 * Created by maxiaolong on 2017/5/5.
 */

abstract class Component {

    String name;

    public abstract void add(Component c);

    public abstract void remove(Component c);

    public abstract void eachChild();
}
