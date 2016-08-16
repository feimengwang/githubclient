package githubclient.true123.cn.githubclient.ui.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import githubclient.true123.cn.githubclient.api.UserManger;
import githubclient.true123.cn.githubclient.ui.ActivityScope;
import githubclient.true123.cn.githubclient.ui.presenter.RepositoryDetailPresenter;
import githubclient.true123.cn.githubclient.ui.views.RepositoryDetailView;

/**
 * Created by junbo on 9/8/2016.
 */
@Module
public class RepositoryDetailModule {
    private RepositoryDetailView repositoryDetailView;
    private String userName;
    private String repositoryName;

    public RepositoryDetailModule(RepositoryDetailView repositoryDetailView, String userName, String repositoryName) {
        this.repositoryDetailView = repositoryDetailView;
        this.userName = userName;
        this.repositoryName = repositoryName;
    }

    @Provides
    @Named("userName")
    @ActivityScope
    String provideUserName() {
        return userName;
    }

    @Provides
    @Named("repositoryName")
    @ActivityScope
    String provideRepositoryName() {
        return repositoryName;
    }

    @Provides
    @ActivityScope
    RepositoryDetailView provideRepositoryDetailView() {
        return repositoryDetailView;
    }

    @Provides
    @ActivityScope
    RepositoryDetailPresenter provideRepositoryDetailPresenter(UserManger userManger) {
        return new RepositoryDetailPresenter(userManger, userName, repositoryName, repositoryDetailView);
    }
}
