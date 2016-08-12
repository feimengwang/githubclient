package githubclient.true123.cn.test;

import dagger.Component;

/**
 * Created by junbo on 12/8/2016.
 */
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
