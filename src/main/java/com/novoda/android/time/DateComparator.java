package com.novoda.android.time;

import java.util.Calendar;
import java.util.Date;

/**
 * Small utility class to do date comparison.
 * Use this class carefully as the interface may change quite a bit.
 */
public class DateComparator {
    
    private int year;
    private int month;
    private int day;
    
    public DateComparator() {
        this(Calendar.getInstance().getTime());
    }
    
    public DateComparator(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.year = calendar.get(Calendar.YEAR); 
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }
    
    public DateComparator(int year, int month, int day) {
        this.year = year; 
        this.month = month;
        this.day = day;
    }

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
        if(this.year > year) {
            return true;
        } else if (this.year < year) {
            return false;
        }
        if(this.month > month) {
            return true;
        } else if (this.month < month) {
            return false;
        }
        if(this.day > day) {
            return true;
        }
        return false; 
    }
    
}
