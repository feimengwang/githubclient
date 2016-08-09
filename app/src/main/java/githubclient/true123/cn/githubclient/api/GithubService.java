package githubclient.true123.cn.githubclient.api;


import java.util.List;

import githubclient.true123.cn.githubclient.bean.Repository;
import githubclient.true123.cn.githubclient.bean.RepositoryItem;
import githubclient.true123.cn.githubclient.bean.User;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by junbo on 9/8/2016.
 */
public interface GithubService {
    //https://api.github.com/repos/{owner}/{repo}
    @GET("repos/{owner}/{repo}")
    Observable<RepositoryItem> getRepositoryItem(@Path("owner") String user, @Path("repo") String repo);

    @GET("users/{userName}/repos")
    Observable<List<Repository>> getUserRepositories(@Path("userName") String userName);

    @GET("users/{userName}")
    Observable<User> getUser(@Path("userName") String userName);

}
