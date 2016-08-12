package githubclient.true123.cn.githubclient;

import javax.inject.Singleton;

import dagger.Component;
import githubclient.true123.cn.githubclient.api.GithubServiceModule;
import githubclient.true123.cn.githubclient.ui.UserComponent;

/**
 * Created by junbo on 9/8/2016.
 */
@Component(modules = {AppModule.class, GithubServiceModule.class})
@Singleton
public interface AppComponent {
    UserComponent get();


}
