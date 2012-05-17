package com.novoda.android.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Specific date formatter for iso8601 
 * The responsibilities of this class are not yet well define, expect changes as the library grows.
 * 
 */
public class Iso8601DateFormatter {

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static final long HOURS_TO_MILLIS = 3600L*1000L;
    
    /**
     * Return the current time - hours pass as parameter in the iso8601 format. 
     * 
     * @param timeInMills
     * @param hours
     * @return
     */
    public String getFormattedTimeHoursBeforNow(long timeInMills, long hours) {
        return getFormattedTime(timeInMills - hours*HOURS_TO_MILLIS);
    }

    /**
     * Return milliseconds pass as parameter in the iso8601 format.
     * @param timeInMills
     * @return
     */
    public String getFormattedTime(long timeInMills) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date(timeInMills));
    }
    
}
