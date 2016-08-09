package githubclient.true123.cn.githubclient.ui.presenter;


import githubclient.true123.cn.githubclient.bean.BaseBean;
import githubclient.true123.cn.githubclient.ui.views.BaseView;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by junbo on 9/8/2016.
 */
public abstract class BasePresenter {
    private BaseView baseView;

    BasePresenter(BaseView baseView) {
        this.baseView = baseView;
    }



    public abstract Observable getObservable();

    public void onDestory() {
        baseView = null;
    }

    public Observer<BaseBean> getSubscriber() {
        return new Subscriber<BaseBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (baseView != null) baseView.error(e.getMessage());
            }

            @Override
            public void onNext(BaseBean base) {
                if (baseView != null) baseView.onLoad(base);
            }
        };
    }
}