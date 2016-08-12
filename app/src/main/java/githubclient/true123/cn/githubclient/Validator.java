package githubclient.true123.cn.githubclient;

import android.app.Application;
import android.text.TextUtils;

/**
 * Created by junbo on 10/8/2016.
 */
public class Validator {
    public Validator(Application application){

    }
    public Boolean isEmptyOrNull(String text){
        return TextUtils.isEmpty(text);
    }
}

