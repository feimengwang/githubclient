package githubclient.true123.cn.githubclient.ui.views;

/**
 * Created by junbo on 9/8/2016.
 */
public interface BaseView<T> {
    public void onLoad(T t);

    public void error(String msg);
}
