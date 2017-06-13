package leon.training.designpattern.structure.decorator;

/**
 * Created by maxiaolong on 2017/4/24.
 */

class Client {

    public static void main() {
        IComponent concreteComponent = new ConcreteComponent();
        concreteComponent.doSomething();
        IComponent decorate = new ConcreteDecorate(new ConcreteComponent());
        decorate.doSomething();
    }

}
