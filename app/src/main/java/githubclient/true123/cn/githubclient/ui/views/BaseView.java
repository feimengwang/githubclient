package githubclient.true123.cn.githubclient.ui.views;

import android.app.Application;

import javax.inject.Inject;

/**
 * Created by junbo on 9/8/2016.
 */
public interface  BaseView {

    public   void onLoad(Object t);

    public   void error(String msg);


}
