package githubclient.true123.cn.githubclient.ui.presenter;

import githubclient.true123.cn.githubclient.api.UserManger;
import githubclient.true123.cn.githubclient.ui.views.BaseView;
import githubclient.true123.cn.githubclient.util.MLog;
import rx.Observable;

/**
 * Created by junbo on 9/8/2016.
 */
public class SplashPresenter extends BasePresenter {
    String userName;
    UserManger userManger;

    public SplashPresenter(BaseView baseView, UserManger userManger) {
        super(baseView);
        this.userManger = userManger;
    }

    public void loadUser(String userName) {
        this.userName = userName;
        getObservable().subscribe(getSubscriber());
    }

    @Override
    public Observable getObservable() {
        MLog.i(this,"getObservable"+userName);
        return userManger.getUser(userName);

    }
}
