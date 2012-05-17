package com.novoda.android.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Generic class for parsing dates.
 * 
 * 
 */
public class DateParser {

    /**
     * Parse the dateString to milliseconds.
     * 
     * @param dateString
     * @return
     */
    public long toMilliseconds(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dateString);
            return date.getTime();
        } catch (ParseException pe) {
            throw new RuntimeException();
        }
    }
    
}
