package leon.training.designpattern.structure.adapter;

/**
 * Created by maxiaolong on 2017/4/24.
 */

class Client {

    public static void main(){
        //对象适配
        ITarget target = new ObjectAdapter(new Adaptee());
        target.sampleOperation1();
        target.sampleOperation2();

        //类适配
        target = new Adapter();
        target.sampleOperation1();
        target.sampleOperation2();
    }
}
