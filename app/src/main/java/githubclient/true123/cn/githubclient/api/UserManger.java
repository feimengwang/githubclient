package githubclient.true123.cn.githubclient.api;

import java.util.List;

import githubclient.true123.cn.githubclient.bean.Repository;
import githubclient.true123.cn.githubclient.bean.RepositoryItem;
import githubclient.true123.cn.githubclient.bean.User;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by junbo on 9/8/2016.
 */
public class UserManger {
    GithubService githubService;

    public UserManger(GithubService githubService) {
        this.githubService = githubService;
    }

    public Observable<User> getUser(String userName) {
        return githubService.getUser(userName)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<Repository>> getRepositories(User user) {
        return githubService.getUserRepositories(user.getLogin())
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }

    public Observable<RepositoryItem> getRepositoryItem(String userName, String repName) {
        return githubService.getRepositoryItem(userName, repName)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }
}

