package githubclient.true123.cn.githubclient.ui;

import dagger.Subcomponent;
import githubclient.true123.cn.githubclient.ui.component.RepositoryDetailComponent;
import githubclient.true123.cn.githubclient.ui.component.RepositoryListComponent;
import githubclient.true123.cn.githubclient.ui.component.SplashComponent;
import githubclient.true123.cn.githubclient.ui.module.RepositoryDetailModule;
import githubclient.true123.cn.githubclient.ui.module.RepositoryListModule;
import githubclient.true123.cn.githubclient.ui.module.SplashModule;
import githubclient.true123.cn.githubclient.ui.views.RepositoryListView;

/**
 * Created by junbo on 9/8/2016.
 */
@UserScope
@Subcomponent
public interface UserComponent {
    SplashComponent plus(SplashModule splashModule);
    RepositoryListComponent plus(RepositoryListModule repositoryListModule);
    RepositoryDetailComponent plus(RepositoryDetailModule repositoryDetailModule);

}
