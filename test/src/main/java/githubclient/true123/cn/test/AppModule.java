package githubclient.true123.cn.test;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by junbo on 12/8/2016.
 */
@Module
public class AppModule {
    Application application;
    public AppModule(Application application){
        this.application = application;
    }
    @Provides
    Application provideApplication(){
        return application;
    }
}
