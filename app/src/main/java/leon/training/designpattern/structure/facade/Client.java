package leon.training.designpattern.structure.facade;


import leon.training.utils.Utils;

/**
 * Client 只能访问到 Façade 中提供的数据是门面设计模式的关键
 */
class Client {

    public static void main() {
        Computer computer = new Computer();
        computer.start();
        Utils.msg("\n=================");
        computer.shutDown();
    }
}
