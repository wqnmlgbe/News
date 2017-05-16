package open.cklan.com.library.utils;

import android.text.format.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * AUTHOR：lanchuanke on 17/5/4 21:38
 */
public class DateUtil {

    public static final String getTimeLength(int length){
        StringBuilder sb=new StringBuilder();
        int hour=length /(60*60);
        if(hour!=0){
            sb.append(hour+":");
            length=length %(60*60);
        }
        int minute=length /60;
        int seconds=length%60;
        sb.append(minute+":"+seconds);
        return sb.toString();
    }

}
