package com.novoda.android.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

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
     * Format current time;
     * 
     * @param format
     * @return
     */
    public String formatCurrentTime(String format) {
        return new DateTime().toString(format);
    }

}
