package leon.training.designpattern.structure.proxy;

/**
 * Created by maxiaolong on 2017/4/20.
 */

class Client {

    public static void main(){
        IProxy proxy = new Proxy();
        proxy.doAction();
    }

}
