package githubclient.true123.cn.githubclient;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import githubclient.true123.cn.githubclient.ui.UserComponent;
import githubclient.true123.cn.githubclient.util.MLog;

/**
 * Created by junbo on 9/8/2016.
 */
public class GithubApplication extends Application {
    private static GithubApplication githubApplication;
    @Inject
    Application application;
    private AppComponent appComponent;
    UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        initComponent();
    }

    private void init() {
        MLog.i(this, "init");
        githubApplication = (GithubApplication) getApplicationContext();
    }

    public static GithubApplication getGithubApplication(Context context) {
        return (GithubApplication) context.getApplicationContext();
    }

    public static GithubApplication getGithubApplication() {
        return githubApplication;
    }


    public void initComponent() {
        MLog.i(this, "initComponent");
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        userComponent = appComponent.get();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
