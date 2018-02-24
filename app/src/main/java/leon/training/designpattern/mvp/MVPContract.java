package leon.training.designpattern.mvp;

/**
 * @author maxiaolong3
 * @version V1.0
 * @description:
 * @date 2018/2/7 下午4:20
 */
public class MVPContract {


    interface View extends BaseView<Presenter> {

        void showLocalToast(String msg);

    }

    interface Presenter extends BasePresenter {

        void delayPost(long delay);

        void msg(String msg);
    }

}
