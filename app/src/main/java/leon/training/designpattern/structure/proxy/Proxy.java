package leon.training.designpattern.structure.proxy;

/**
 * Created by maxiaolong on 2017/4/20.
 */

public class Proxy implements IProxy {

    private IProxy mProxy;

    public Proxy() {             //关系在编译时确定
        mProxy = new RealSubject();
    }

    @Override
    public void doAction() {
        mProxy.doAction();
    }
}
