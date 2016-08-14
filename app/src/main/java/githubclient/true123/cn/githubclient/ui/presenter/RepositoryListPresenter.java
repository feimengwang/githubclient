package githubclient.true123.cn.githubclient.ui.presenter;

import java.util.Map;

import githubclient.true123.cn.githubclient.api.UserManger;
import githubclient.true123.cn.githubclient.bean.User;
import githubclient.true123.cn.githubclient.ui.adapter.ViewHolderFactory;
import githubclient.true123.cn.githubclient.ui.views.RepositoryListView;
import githubclient.true123.cn.githubclient.util.MLog;
import rx.Observable;

/**
 * Created by junbo on 14/8/2016.
 */
public class RepositoryListPresenter extends BasePresenter {
    UserManger userManger;
    String userName;
    RepositoryListView repositoryListView;

    public RepositoryListPresenter(UserManger userManger, String userName, RepositoryListView repositoryListView) {

        super(repositoryListView);
        this.repositoryListView = repositoryListView;
        this.userManger = userManger;
        this.userName = userName;
        MLog.i(this,"userName="+userName);
    }
    public void onLoadRepositories(){
        MLog.i(this,"onLoadRepositories="+userName);
        getObservable().subscribe(getSubscriber());

    }
    @Override
    public Observable getObservable() {
        User u=new User();
        u.setLogin(userName);
        return userManger.getRepositories(u);
    }


}
