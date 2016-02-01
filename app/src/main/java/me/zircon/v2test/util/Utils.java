package me.zircon.v2test.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <Description> <br>
 *
 * @author yewanwan<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 16/1/29 <br>
 */
public class Utils {

    public static String formatLongTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.CHINA);
        return format.format(new Date(time));
    }

}
