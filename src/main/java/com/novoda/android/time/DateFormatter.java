package com.novoda.android.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Generic date formatter.
 * The responsibilities of this class are not yet well define, expect changes as the library grows.
 */
public class DateFormatter {

    /**
     * Change format of a date.
     * 
     * @param date
     * @param originFormat
     * @param newFormat
     * @param defaultValue
     * @return
     */
    public String changeFormat(String date, String originFormat, String newFormat, String defaultValue) {
        try {
            SimpleDateFormat sourceFormat = new SimpleDateFormat(originFormat);
            Date parsedDate = sourceFormat.parse(date);
            SimpleDateFormat toFormat = new SimpleDateFormat(newFormat);
            return toFormat.format(parsedDate);
        } catch (Exception e) {
            return defaultValue;
        }
    }
    
    /**
     * Format current time.
     * 
     * @param format
     * @return
     */
    public String formatCurrentTime(String format) {
        return formatTime(new Date(), format);
    }
    
    /**
     * Format time to the format passed as parameter.
     * 
     * @param date
     * @param format
     * @return
     */
    public String formatTime(Date date, String format) {
        if(date == null) {
            return null;
        }
        if(format == null) {
            return date.toString();
        }
        SimpleDateFormat dt = new SimpleDateFormat(format);
        return dt.format(date);
    }

}
