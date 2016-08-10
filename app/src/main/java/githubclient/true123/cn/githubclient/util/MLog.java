package githubclient.true123.cn.githubclient.util;

import android.util.Log;

/**
 * Created by junbo on 10/8/2016.
 */
public class MLog {
    private static final String TAG = "MLog";
    private static LEVEL current = LEVEL.DEBUG;

    enum LEVEL {
        DEBUG(0), INFO(1), ERROR(3), WARN(2);
        private int index;

        LEVEL(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }


    static boolean isLog(LEVEL level) {
        if (level.getIndex() >= current.getIndex()) {
            return true;
        }
        return false;
    }

    public static void i(Class clazz, String msg) {
        if (isLog(LEVEL.INFO)) {
            Log.i(TAG, clazz.getSimpleName() + " - " + msg);
        }
    }

    public static void e(Class clazz, String msg) {
        if (isLog(LEVEL.INFO)) {
            Log.e(TAG, clazz.getSimpleName() + " - " + msg);
        }
    }

    public static void w(Class clazz, String msg) {
        if (isLog(LEVEL.INFO)) {
            Log.w(TAG, clazz.getSimpleName() + " - " + msg);
        }
    }

    public static void d(Class clazz, String msg) {
        if (isLog(LEVEL.INFO)) {
            Log.d(TAG, clazz.getSimpleName() + " - " + msg);
        }
    }
}
