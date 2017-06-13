package leon.training.designpattern.behavior.observer;

/**
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:16:30
 * Email:mxlxiao7@sina.com
 */
public interface ISubject {

    /*增加观察者*/
    public void regist(IObserver observer);

    /*删除观察者*/
    public void unregist(IObserver observer);

    /*通知所有的观察者*/
    public void notifyObservers();

}
