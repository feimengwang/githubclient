package githubclient.true123.cn.githubclient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by junbo on 9/8/2016.
 */
@Module
public class AppModule {
    private GithubApplication githubApplication;

    AppModule(GithubApplication githubApplication) {
        this.githubApplication = githubApplication;
    }

    @Provides
    @Singleton
    public GithubApplication provideGithubApplication() {
        return githubApplication;
    }
}
