package leon.training.designpattern.behavior.chain;


import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/5/25.
 */

class Client {

    public static void main() {
        //先要组装责任链
        IHandler h1 = new GeneralHandler();
        IHandler h2 = new DeptHandler();
        IHandler h3 = new ProjectHandler();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试
        String test1 = h3.handleRequest("张三", 300);
        Utils.msg("test1 = " + test1 + " \n");
        String test2 = h3.handleRequest("李四", 300);
        Utils.msg("test2 = " + test2 + " \n");
        Utils.msg("---------------------------------------" + " \n");

        String test3 = h3.handleRequest("张三", 700);
        Utils.msg("test3 = " + test3 + " \n");
        String test4 = h3.handleRequest("李四", 700);
        Utils.msg("test4 = " + test4 + " \n");
        Utils.msg("---------------------------------------" + " \n");

        String test5 = h3.handleRequest("张三", 1500);
        Utils.msg("test5 = " + test5 + " \n");
        String test6 = h3.handleRequest("李四", 1500);
        Utils.msg("test6 = " + test6 + " \n");
    }
}
