package githubclient.true123.cn.githubclient.ui.activities;

import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import githubclient.true123.cn.githubclient.GithubApplication;
import githubclient.true123.cn.githubclient.R;
import githubclient.true123.cn.githubclient.bean.User;
import githubclient.true123.cn.githubclient.ui.UserModule;
import githubclient.true123.cn.githubclient.ui.module.SplashModule;
import githubclient.true123.cn.githubclient.ui.presenter.SplashPresenter;
import githubclient.true123.cn.githubclient.ui.views.SplashView;

/**
 * Created by junbo on 9/8/2016.
 */
public class SplashActivity extends BaseActivity implements SplashView {
    @Bind(R.id.et_user_name)
    EditText name;
    @Bind(R.id.btn_get_user)
    Button button;

    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void initComponent() {
        GithubApplication
                .getGithubApplicationContext()
                .getAppComponent()
                .plus(new UserModule())
                .plus(new SplashModule(this));
    }

    @Override
    protected void initView() {

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

    }



    @Override
    public void error(String msg) {

    }
}
