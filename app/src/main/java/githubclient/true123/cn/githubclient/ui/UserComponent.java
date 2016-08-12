package githubclient.true123.cn.githubclient.ui;

import dagger.Subcomponent;
import githubclient.true123.cn.githubclient.ui.component.SplashComponent;
import githubclient.true123.cn.githubclient.ui.module.SplashModule;

/**
 * Created by junbo on 9/8/2016.
 */
@UserScope
@Subcomponent
public interface UserComponent {
    SplashComponent plus(SplashModule splashModule);

}
