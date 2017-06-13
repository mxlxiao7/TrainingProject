package leon.training.designpattern.behavior.observer;

import java.util.Vector;

/**
 * Author:maxiaolong
 * Date:2016/10/13
 * Time:16:31
 * Email:mxlxiao7@sina.com
 */
public class Subject implements ISubject {


    private Vector<IObserver> vector = new Vector<IObserver>();

    @Override
    public void regist(IObserver observer) {
        vector.add(observer);
    }

    @Override
    public void unregist(IObserver observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : vector) {
            observer.update();
        }
    }


}
