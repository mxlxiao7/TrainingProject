package leon.training.designpattern.behavior.templatemethod;


import leon.training.algorithm.Utils;
import leon.training.designpattern.behavior.chain.DeptHandler;
import leon.training.designpattern.behavior.chain.GeneralHandler;
import leon.training.designpattern.behavior.chain.IHandler;
import leon.training.designpattern.behavior.chain.ProjectHandler;

/**
 * Created by maxiaolong on 2017/5/25.
 */

class Client {

    public static void main() {
        Student student = new Student();
        student.prepareGotoSchool();

        Teacher teacher = new Teacher();
        teacher.prepareGotoSchool();
    }
}
