package githubclient.true123.cn.githubclient.ui.activities;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import githubclient.true123.cn.githubclient.GithubApplication;
import githubclient.true123.cn.githubclient.R;
import githubclient.true123.cn.githubclient.Validator;
import githubclient.true123.cn.githubclient.api.UserManger;
import githubclient.true123.cn.githubclient.bean.User;
import githubclient.true123.cn.githubclient.ui.module.SplashModule;
import githubclient.true123.cn.githubclient.ui.presenter.SplashPresenter;
import githubclient.true123.cn.githubclient.ui.views.SplashView;
import githubclient.true123.cn.githubclient.util.MLog;

/**
 * Created by junbo on 9/8/2016.
 */
public class SplashActivity extends BaseActivity implements SplashView {
    @Bind(R.id.et_user_name)
    EditText name;
    @Bind(R.id.btn_get_user)
    Button button;

     @Inject
    public SplashPresenter splashPresenter;

    @Inject
    public UserManger userManger;

    @Inject
    Application application;

    @Inject
    Validator validator;

    @Override
    protected void initComponent() {
        MLog.i(this, "initComponent");
        GithubApplication
                .getGithubApplication(this)
                .getUserComponent().plus(new SplashModule(this)).inject(this);

    }

    @Override
    protected void initView() {
        name.setText("feimengwang");
    }

    @OnClick(R.id.btn_get_user)
    public void loadUser() {
        MLog.i(this, "splashPresenter=" + splashPresenter);
        MLog.i(this, "userManger=" + userManger);
        MLog.i(this, "application=" + application);
        MLog.i(this, "validator=" + validator);


        splashPresenter.loadUser(name.getText().toString());

    }

    @Override
    public int getContentResId() {
        return R.layout.splash_activity;
    }

    @Override
    protected void destroyPresenter() {
        splashPresenter.onDestory();
    }

    @Override
    public void onLoad(Object o) {
        if (o != null) {
            Intent intent = new Intent(this, RepositoryListActivity.class);
            Bundle b=new Bundle();
            b.putString("name",((User)o).getLogin());
            intent.putExtras(b);
            startActivity(intent);
        } else {
            MLog.e(this, "onload error");
        }
    }


    @Override
    public void error(String msg) {
        MLog.e(this, "error error" + msg);
    }
}
