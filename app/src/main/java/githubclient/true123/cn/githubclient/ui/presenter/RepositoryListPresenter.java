package githubclient.true123.cn.githubclient.ui.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import githubclient.true123.cn.githubclient.api.UserManger;
import githubclient.true123.cn.githubclient.bean.Repository;
import githubclient.true123.cn.githubclient.bean.User;
import githubclient.true123.cn.githubclient.ui.activities.RepositoryDetailActivity;
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
        MLog.i(this, "userName=" + userName);
    }

    public void onLoadRepositories() {
        MLog.i(this, "onLoadRepositories=" + userName);
        getObservable().subscribe(getSubscriber());

    }

    @Override
    public Observable getObservable() {

        return userManger.getRepositories(userName);
    }

    public void onItemClick(Repository repository) {
        if (repository != null) {
            Intent intent = new Intent((Context) repositoryListView, RepositoryDetailActivity.class);
            Bundle b = new Bundle();
            b.putString("userName", repository.getOwner().getLogin());
            b.putString("repositoryName", repository.getName());
            intent.putExtras(b);
            ((Context) repositoryListView).startActivity(intent);
        }
    }

}
