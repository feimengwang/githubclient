package githubclient.true123.cn.githubclient.ui.component;

import dagger.Subcomponent;
import githubclient.true123.cn.githubclient.ui.ActivityScope;
import githubclient.true123.cn.githubclient.ui.activities.SplashActivity;
import githubclient.true123.cn.githubclient.ui.module.SplashModule;
import githubclient.true123.cn.githubclient.ui.views.SplashView;

/**
 * Created by junbo on 9/8/2016.
 */
@ActivityScope
@Subcomponent(modules = SplashModule.class)
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
