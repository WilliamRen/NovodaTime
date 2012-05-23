package com.novoda.android.time;

import java.util.Calendar;
import java.util.Date;

/**
 * Small utility class to do date comparison.
 * Use this class carefully as the interface may change quite a bit.
 */
public class DateComparator {

    /**
     * Return true if the date is in the past.
     * The check is done on year, month and day.
     * 
     * @param date
     */
    public boolean isPastDate(Date date) {
        if(date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR); 
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return isPastDate(year, month, day);
    }
    
    /**
     * Return true if the date corresponding is in the past.
     * 
     * @param year
     * @param month
     * @param day
     * @return
     */
    public boolean isPastDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR); 
        if(currentYear > year) {
            return true;
        } else if (currentYear < year) {
            return false;
        }
        int currentMonth = calendar.get(Calendar.MONTH);
        if(currentMonth > month) {
            return true;
        } else if (currentMonth < month) {
            return false;
        }
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        if(currentDay > day) {
            return true;
        }
        return false; 
    }
    
}
