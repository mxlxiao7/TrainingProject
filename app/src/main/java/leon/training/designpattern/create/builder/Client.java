package leon.training.designpattern.create.builder;

/**
 * Created by maxiaolong on 2017/4/19.
 */

class Client {


    private IBuilder mBuilder;

    // 构造方法中也可以传递builder
    public Client(IBuilder builder) {
        this.mBuilder = builder;
    }

    // 传递builder
    public void setBuilder(Builder builder) {
        this.mBuilder = builder;
    }

    // 这个方法用来规范流程，产品构建和组装方法
    public void construct() {
        mBuilder.buildPartA("市委书记");
        mBuilder.buildPartB("李达康");
        mBuilder.buildPartC("001");
    }
}
