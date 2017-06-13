package leon.training.groovy
/**
 * Created by maxiaolong on 2016/12/29.
 */

public class GroovyTest {
    String name;
    int age;

    GroovyTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    def void print() {
        toS.call();

    }

    def toS = {
        println(toString());
    }

    def String toString() {
        return name + " " + age;
    }
}
