package open.cklan.com.library.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * AUTHOR：lanchuanke on 17/5/12 18:16
 */
public class SnackBarUtil {

    public static final void showMessage(View view, String msg){
        Snackbar.make(view,msg,Snackbar.LENGTH_LONG).show();
    }
}
