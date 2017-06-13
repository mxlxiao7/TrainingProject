package leon.training.designpattern.structure.adapter;

/**
 *
 * 此接口就是客户端需要的
 *
 *
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:13:32
 * Email:mxlxiao7@sina.com
 */
public interface ITarget {

    /**
     * 这是源类Adaptee也有的方法
     */
    public void sampleOperation1();

    /**
     * 这是源类Adaptee没有的方法
     */
    public void sampleOperation2();


}
