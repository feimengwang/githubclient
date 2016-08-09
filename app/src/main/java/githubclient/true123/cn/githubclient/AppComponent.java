package githubclient.true123.cn.githubclient;

import dagger.Component;
import githubclient.true123.cn.githubclient.api.GithubServiceModule;
import githubclient.true123.cn.githubclient.ui.UserComponent;
import githubclient.true123.cn.githubclient.ui.UserModule;

/**
 * Created by junbo on 9/8/2016.
 */
@Component(modules = {AppModule.class, GithubServiceModule.class})
public interface AppComponent {
    UserComponent plus(UserModule userModule);
}
