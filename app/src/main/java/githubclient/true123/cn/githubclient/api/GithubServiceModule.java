package githubclient.true123.cn.githubclient.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import githubclient.true123.cn.githubclient.constant.Constant;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by junbo on 9/8/2016.
 */
@Module
public class GithubServiceModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return GithubManager.getOkHttpClient();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return GithubManager.getRetrofit(okHttpClient, Constant.BASE_URL);
    }

    @Provides
    @Singleton
    public GithubService provideGitHubService(Retrofit retrofit) {
        return GithubManager.getGithubService(retrofit);
    }

    @Provides
    @Singleton
    public UserManger provideUserManger(GithubService githubService) {
        return new UserManger(githubService);
    }
}
