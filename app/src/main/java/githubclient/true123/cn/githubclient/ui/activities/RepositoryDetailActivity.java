package githubclient.true123.cn.githubclient.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import githubclient.true123.cn.githubclient.GithubApplication;
import githubclient.true123.cn.githubclient.R;
import githubclient.true123.cn.githubclient.ui.module.RepositoryDetailModule;
import githubclient.true123.cn.githubclient.ui.presenter.RepositoryDetailPresenter;
import githubclient.true123.cn.githubclient.ui.views.RepositoryDetailView;

/**
 * Created by junbo on 10/8/2016.
 */
public class RepositoryDetailActivity extends BaseActivity implements RepositoryDetailView {
    @Inject
    RepositoryDetailPresenter presenter;
    @Bind(R.id.tv_detail)
    TextView detail;

    @Override
    protected void initComponent() {
        String userName="";
        String repositoryName="";
        Intent intent=getIntent();
        if(intent!=null){
            Bundle b=intent.getExtras();
            if(b!=null){
                userName=b.getString("userName");
                repositoryName = b.getString("repositoryName");

            }
        }
        GithubApplication.getGithubApplication(this).getUserComponent()
                .plus(new RepositoryDetailModule(this, userName, repositoryName)).inject(this);
    }

    @Override
    protected void initView() {
        presenter.onLoadRepositoryItem();
    }

    @Override
    public int getContentResId() {
        return R.layout.repository_detail_activity;
    }

    @Override
    protected void destroyPresenter() {
        presenter = null;
    }

    @Override
    public void onLoad(Object t) {
        detail.setText(t.toString());
    }

    @Override
    public void error(String msg) {
        detail.setText(msg);
    }
}
