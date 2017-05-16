package open.cklan.com.library.utils;

import android.util.Log;

/**
 * AUTHOR：lanchuanke on 17/5/3 21:10
 */
public class LogUtil {
    private static final String TAG="TopLine";

    public static void i(String message){
        Log.i(TAG,message);
    }

    public static void e(String message){
        Log.e(TAG,message);
    }
}
