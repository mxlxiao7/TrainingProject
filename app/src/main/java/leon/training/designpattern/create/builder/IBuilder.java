package leon.training.designpattern.create.builder;

/**
 * Created by maxiaolong on 2017/4/19.
 */

public interface IBuilder {

    public void buildPartA(String s);

    public void buildPartB(String s);

    public void buildPartC(String s);

    public Productor build();
}
