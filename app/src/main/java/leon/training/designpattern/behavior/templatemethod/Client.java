package leon.training.designpattern.behavior.templatemethod;


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
