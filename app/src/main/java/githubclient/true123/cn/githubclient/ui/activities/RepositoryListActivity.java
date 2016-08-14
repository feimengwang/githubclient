package githubclient.true123.cn.githubclient.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import githubclient.true123.cn.githubclient.GithubApplication;
import githubclient.true123.cn.githubclient.R;
import githubclient.true123.cn.githubclient.bean.Repository;
import githubclient.true123.cn.githubclient.bean.User;
import githubclient.true123.cn.githubclient.ui.adapter.RepositoryListAdapter;
import githubclient.true123.cn.githubclient.ui.module.RepositoryListModule;
import githubclient.true123.cn.githubclient.ui.presenter.RepositoryListPresenter;
import githubclient.true123.cn.githubclient.ui.views.RepositoryListView;
import githubclient.true123.cn.githubclient.util.MLog;

/**
 * Created by junbo on 10/8/2016.
 */
public class RepositoryListActivity extends BaseActivity implements RepositoryListView {
    @Inject
    RepositoryListAdapter adapter;
    @Inject
    RepositoryListPresenter presenter;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    @Override
    protected void initComponent() {
        User u = null;
        Intent intent = getIntent();
        MLog.i(this, "getIntent = " + getIntent());
        if (intent != null) {
            Bundle b = intent.getExtras();
            MLog.i(this, "b = " + b);
            if (b != null) {
                String userName = b.getString("name");
                MLog.i(this, "userName = " + userName);
                u = new User();
                u.setLogin(userName);
            }
        }
        MLog.i(this, "user = " + u.getLogin());
        GithubApplication.getGithubApplication(this).getUserComponent()
                .plus(new RepositoryListModule(this, u)).inject(this);
    }

    @Override
    protected void initView() {
        MLog.i(this,"adapter="+adapter);
        MLog.i(this,"presenter="+presenter);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.onLoadRepositories();
    }

    @Override
    public int getContentResId() {
        return R.layout.repository_list_activity;
    }

    @Override
    protected void destroyPresenter() {
        presenter = null;
    }

    @Override
    public void onLoad(Object t) {
        MLog.i(this, "t==" + t);
        List list = (List) t;
        adapter.update(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void error(String msg) {

    }


    @Override
    public void onItemClick(Repository repository) {

    }
}
