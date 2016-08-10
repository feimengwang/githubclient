package githubclient.true123.cn.githubclient.ui;

import dagger.Module;
import dagger.Provides;
import githubclient.true123.cn.githubclient.Validator;
import githubclient.true123.cn.githubclient.bean.User;

/**
 * Created by junbo on 9/8/2016.
 */
@Module
public class UserModule {

    private User user;


    public UserModule() {

    }

    @Provides
    @UserScope
    public Validator provideValidator() {
        return new Validator();
    }
}
