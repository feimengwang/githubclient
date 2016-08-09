package githubclient.true123.cn.githubclient.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by junbo on 9/8/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResId());
        ButterKnife.bind(this);
        initComponent();
        initView();

    }

    protected abstract void initComponent();

    protected abstract void initView();

    public abstract int getContentResId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyPresenter();
    }

    protected abstract void destroyPresenter();
}

