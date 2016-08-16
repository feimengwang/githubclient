package githubclient.true123.cn.githubclient.ui.presenter;

import githubclient.true123.cn.githubclient.api.UserManger;
import githubclient.true123.cn.githubclient.ui.views.RepositoryDetailView;
import githubclient.true123.cn.githubclient.util.MLog;
import rx.Observable;

/**
 * Created by junbo on 14/8/2016.
 */
public class RepositoryDetailPresenter extends BasePresenter {
    UserManger userManger;
    String userName;
    String repositoryName;
    RepositoryDetailView repositoryDetailView;

    public RepositoryDetailPresenter(UserManger userManger, String userName, String repositoryName, RepositoryDetailView repositoryDetailView) {

        super(repositoryDetailView);
        this.repositoryDetailView = repositoryDetailView;
        this.userManger = userManger;
        this.userName = userName;
        this.repositoryName = repositoryName;
        MLog.i(this, "userName=" + userName);
    }

    public void onLoadRepositoryItem() {
        MLog.i(this, "onLoadRepositories=" + userName);
        getObservable().subscribe(getSubscriber());

    }

    @Override
    public Observable getObservable() {

        return userManger.getRepositoryItem(userName, repositoryName);
    }


}
