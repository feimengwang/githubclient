package githubclient.true123.cn.githubclient.ui.component;

import dagger.Subcomponent;
import githubclient.true123.cn.githubclient.ui.ActivityScope;
import githubclient.true123.cn.githubclient.ui.activities.RepositoryDetailActivity;
import githubclient.true123.cn.githubclient.ui.module.RepositoryDetailModule;
import githubclient.true123.cn.githubclient.ui.module.SplashModule;
import githubclient.true123.cn.githubclient.ui.views.RepositoryDetailView;
import githubclient.true123.cn.githubclient.ui.views.SplashView;

/**
 * Created by junbo on 9/8/2016.
 */
@Subcomponent(modules = RepositoryDetailModule.class)
@ActivityScope
public interface RepositoryDetailComponent {
    void inject(RepositoryDetailActivity repositoryDetailActivity);
}
