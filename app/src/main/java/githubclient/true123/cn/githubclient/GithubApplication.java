package githubclient.true123.cn.githubclient;

import android.app.Application;

/**
 * Created by junbo on 9/8/2016.
 */
public class GithubApplication extends Application {
    private static GithubApplication githubApplication;
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
        initComponent();
    }

    private void init() {
        githubApplication = (GithubApplication) getApplicationContext();
    }

    public static GithubApplication getGithubApplicationContext() {
        return githubApplication;
    }

    public void initComponent() {
        appComponent=  DaggerAppComponent.builder().build();
    }
    public AppComponent getAppComponent(){
        return appComponent;
    }
}
