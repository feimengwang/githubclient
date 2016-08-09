package githubclient.true123.cn.githubclient.ui.presenter;

import githubclient.true123.cn.githubclient.api.RepositoryManager;
import githubclient.true123.cn.githubclient.ui.views.BaseView;
import rx.Observable;

/**
 * Created by junbo on 9/8/2016.
 */
public class SplashPresenter extends BasePresenter {
    String userName;
    RepositoryManager repositoryManager;

    SplashPresenter(BaseView baseView) {
        super(baseView);
    }

    public SplashPresenter(BaseView baseView, RepositoryManager repositoryManager) {
        super(baseView);
        this.repositoryManager = repositoryManager;
    }

    public void loadUser(String userName) {
        this.userName = userName;
        getObservable().subscribe(getSubscriber());
    }

    @Override
    public Observable getObservable() {
        return null;
    }
}
