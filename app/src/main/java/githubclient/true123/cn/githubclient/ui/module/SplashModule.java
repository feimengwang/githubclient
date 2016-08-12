package githubclient.true123.cn.githubclient.ui.module;

import dagger.Module;
import dagger.Provides;
import githubclient.true123.cn.githubclient.api.UserManger;
import githubclient.true123.cn.githubclient.ui.ActivityScope;
import githubclient.true123.cn.githubclient.ui.activities.SplashActivity;
import githubclient.true123.cn.githubclient.ui.presenter.SplashPresenter;
import githubclient.true123.cn.githubclient.ui.views.SplashView;
import githubclient.true123.cn.githubclient.util.MLog;

/**
 * Created by junbo on 9/8/2016.
 */
@Module
public class SplashModule {
    public SplashView splashView;


    public SplashModule(SplashView splashView) {
        this.splashView = splashView;
    }


    @Provides
    @ActivityScope
    SplashView provideSplashView() {
        return splashView;
    }

    @Provides
    @ActivityScope
    public SplashPresenter provideSplashPresenter(SplashView splashView,UserManger userManger) {
        MLog.i(this, "provideSplashPresenter");
        return new SplashPresenter(splashView, userManger);
    }

}
