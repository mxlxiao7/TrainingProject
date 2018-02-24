package leon.training.designpattern.mvp;

/**
 * @author maxiaolong3
 * @version V1.0
 * @description:
 * @date 2018/2/7 下午4:17
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

}
