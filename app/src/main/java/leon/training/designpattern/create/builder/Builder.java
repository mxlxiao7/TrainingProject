package leon.training.designpattern.create.builder;

/**
 * Created by maxiaolong on 2017/4/19.
 */

public class Builder implements IBuilder {

    private Productor product;

    public Builder() {
        product = new Productor();
    }


    // 创建partA
    public void buildPartA(String title) {
        product.title = title;
    }

    // 创建partB
    public void buildPartB(String name) {
        product.name = name;
    }

    // 创建partC
    public void buildPartC(String code) {
        product.code = code;
    }

    // 返回复杂产品对象
    public Productor build() {
        return this.product;
    }
}
