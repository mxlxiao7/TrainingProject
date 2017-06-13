package leon.training.designpattern.behavior.chain;

/**
 * Created by maxiaolong on 2017/5/25.
 */

public abstract class BaseHanndler implements IHandler {

    /**
     * 持有后继的责任对象
     */
    protected IHandler successor;


    public BaseHanndler() {

    }

    /**
     * 取值方法
     */
    public IHandler getSuccessor() {
        return successor;
    }

    /**
     * 赋值方法，设置后继的责任对象
     */
    public void setSuccessor(IHandler successor) {
        this.successor = successor;
    }
}
