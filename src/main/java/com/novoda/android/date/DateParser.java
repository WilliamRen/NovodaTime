package com.novoda.android.date;

import org.joda.time.DateTime;

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
        return new DateTime(dateString).getMillis();
    }
    
}
