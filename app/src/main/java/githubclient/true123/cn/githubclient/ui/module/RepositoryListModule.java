package githubclient.true123.cn.githubclient.ui.module;

import java.util.Map;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import githubclient.true123.cn.githubclient.api.UserManger;
import githubclient.true123.cn.githubclient.ui.ActivityScope;
import githubclient.true123.cn.githubclient.ui.adapter.GreatViewHolderFactory;
import githubclient.true123.cn.githubclient.ui.adapter.NormalViewHolderFactory;
import githubclient.true123.cn.githubclient.ui.adapter.RepositoryListAdapter;
import githubclient.true123.cn.githubclient.ui.adapter.ViewHolderFactory;
import githubclient.true123.cn.githubclient.ui.presenter.RepositoryListPresenter;
import githubclient.true123.cn.githubclient.ui.views.RepositoryListView;

/**
 * Created by junbo on 9/8/2016.
 */
@Module
public class RepositoryListModule {
    private RepositoryListView repositoryListView;
    private String userName;


    public RepositoryListModule(RepositoryListView repositoryListView, String userName) {
        this.repositoryListView = repositoryListView;
        this.userName = userName;
    }

    @Provides
    @Named("userName")
    @ActivityScope
    String provideUserName() {
        return userName;
    }

    @Provides
    @ActivityScope
    RepositoryListView provideRepositoryListView() {
        return repositoryListView;
    }

    @Provides
    @ActivityScope
    RepositoryListPresenter provideRepositoryListPresenter(UserManger userManger, RepositoryListView repositoryListView) {
        return new RepositoryListPresenter(userManger, userName, repositoryListView);
    }

    @Provides
    @ActivityScope
    @IntoMap
    @IntKey(RepositoryListAdapter.VIEW_TYPE_NORMAL)
    ViewHolderFactory provideNormalViewHolder() {
        return new NormalViewHolderFactory();
    }

    @Provides
    @ActivityScope
    @IntoMap
    @IntKey(RepositoryListAdapter.VIEW_TYPE_GREAT)
    ViewHolderFactory provideGreatViewHolder() {
        return new GreatViewHolderFactory();
    }

    @Provides
    @ActivityScope
    RepositoryListAdapter provideRepositoryListAdapter(RepositoryListView repositoryListView, Map<Integer, ViewHolderFactory> factoryMap) {
        return new RepositoryListAdapter(repositoryListView, factoryMap);
    }
}
