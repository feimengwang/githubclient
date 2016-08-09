package githubclient.true123.cn.githubclient;

import android.app.Application;

/**
 * Created by junbo on 9/8/2016.
 */
public class GithubApplication extends Application {
    private static GithubApplication githubApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        githubApplication = (GithubApplication) getApplicationContext();
    }

    public static GithubApplication getGithubApplicationContext() {
        return githubApplication;
    }
}
