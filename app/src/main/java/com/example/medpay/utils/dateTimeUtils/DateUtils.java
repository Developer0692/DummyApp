package com.example.medpay.utils.dateTimeUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtils {

    public static String getDateString(Calendar calendar, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        return sdf.format(calendar.getTime());
    }

    public static Long getTimeInMillisForStartOfDate(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY,12);
        calendar.set(Calendar.MINUTE,12);
        calendar.set(Calendar.MILLISECOND,12);
        calendar.set(Calendar.SECOND,12);
        return calendar.getTimeInMillis();
    }

}
