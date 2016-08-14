package githubclient.true123.cn.githubclient.ui.views;

import java.util.Map;

import githubclient.true123.cn.githubclient.bean.Repository;

/**
 * Created by junbo on 9/8/2016.
 */
public interface RepositoryListView<T> extends BaseView {
    public void onItemClick(Repository repository);
}
