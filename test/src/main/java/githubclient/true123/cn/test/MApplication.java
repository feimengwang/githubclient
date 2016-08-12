package githubclient.true123.cn.test;

import android.app.Application;
import android.content.Context;

/**
 * Created by junbo on 12/8/2016.
 */
public class MApplication  extends Application{
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        iniComponent();
    }

    private void iniComponent() {
     appComponent =  DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
    public static MApplication getApplication(Context context){
        return (MApplication) context.getApplicationContext();
    }

}
