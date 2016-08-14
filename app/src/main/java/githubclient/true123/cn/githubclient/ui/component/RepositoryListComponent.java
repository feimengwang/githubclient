package githubclient.true123.cn.githubclient.ui.component;

import dagger.Subcomponent;
import githubclient.true123.cn.githubclient.ui.ActivityScope;
import githubclient.true123.cn.githubclient.ui.activities.RepositoryListActivity;
import githubclient.true123.cn.githubclient.ui.module.RepositoryListModule;
import githubclient.true123.cn.githubclient.ui.module.SplashModule;
import githubclient.true123.cn.githubclient.ui.views.RepositoryListView;
import githubclient.true123.cn.githubclient.ui.views.SplashView;

/**
 * Created by junbo on 9/8/2016.
 */
@Subcomponent(modules = RepositoryListModule.class)
@ActivityScope
public interface RepositoryListComponent {
    void inject(RepositoryListActivity repositoryListActivity);
}
