package leon.training.designpattern.create.builder;

/**
 * Created by maxiaolong on 2017/4/19.
 */

public class Productor {
    public String title;
    public String name;
    public String code;

    @Override
    public String toString() {
        return "Productor{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
