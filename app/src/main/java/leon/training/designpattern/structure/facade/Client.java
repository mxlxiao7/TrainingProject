package leon.training.designpattern.structure.facade;


import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/4/24.
 */

class Client {

    public static void main() {
        Computer computer = new Computer();
        computer.start();
        Utils.msg("\n=================");
        computer.shutDown();
    }
}
