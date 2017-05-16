package open.cklan.com.library.utils;

import android.content.Context;

/**
 * AUTHOR：lanchuanke on 17/5/4 16:34
 */
public class ScreenUtil {

    public static int convertDpToPixel(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}
