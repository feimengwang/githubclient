package githubclient.true123.cn.githubclient.ui;

import dagger.Module;
import dagger.Provides;
import githubclient.true123.cn.githubclient.bean.User;

/**
 * Created by junbo on 9/8/2016.
 */
@Module
public class UserModule {

    private User user;


    public UserModule(User user) {
        this.user = user;

    }

    @Provides
    @UserScope
    public User provideUser() {
        return user;
    }
}
