package com.novoda.android.time;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Utility Class to manage date formatting.
 * Functionality implemented are :
 * - date range formatting
 * 
 */
public class DateRangeFormatter {

    /**
     * This method format the dates in a format like
     * dd MMM YYYY-dd MMM YYYY
     * 
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    public String formatDateRange(final String startDateTime, final String endDateTime) {
        if (isEmpty(startDateTime)) {
            return "";
        }
        return formatDateRangeFromStringDates(startDateTime, endDateTime);
    }
    
    private String formatDateRangeFromStringDates(String startDateTime, String endDateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(startDateTime);
        } catch (Exception e) {
            return "";
        }
        try {
            endDate = sdf.parse(endDateTime);
        } catch(Exception e) {
            endDate = null;
        }
        if (endDate != null) {
            if (dateRangeLongerThanOneDay(startDate, endDate)) {
                return formatDateRange(startDate, endDate);
            }
        }
        return formatSingleDate(startDate);
    }

    private String formatDateRange(Date startDate, Date endDate) {
        return formatStartDate(startDate, endDate) + "-" + formatSingleDate(endDate);
    }

    private String formatStartDate(Date startDate, Date endDate) {
        String dateFormat = getDateRangeFormatter(startDate, endDate);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(startDate);
    }

    private String getDateRangeFormatter(Date startDate, Date endDate) {
        final boolean datesAreInTheSameMonth = getMonthOfYear(startDate) == getMonthOfYear(endDate);
        final boolean datesAreInTheSameYear = getYear(startDate) == getYear(endDate);
        if (datesAreInTheSameYear) {
            if (datesAreInTheSameMonth) {
                return "d";
            } else {
                return "d MMM";
            }
        } else {
            return "d MMM yyyy";
        }
    }

    private int getYear(Date startDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        return cal.get(Calendar.YEAR);
    }

    private int getMonthOfYear(Date startDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        return cal.get(Calendar.MONTH);
    }

    
    private String formatSingleDate(Date date) {
        String dateFormat = getDateFormatterString(date);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    private String getDateFormatterString(Date date) {
        if (dateIsInTheCurrentYear(date)) {
            return "d MMM";
        } else {
            return "d MMM yyyy";
        }
    }

    private boolean dateIsInTheCurrentYear(Date date) {
        Calendar cal = Calendar.getInstance();
        final int currentYear = cal.get(Calendar.YEAR);
        cal.setTime(date);
        final int year = cal.get(Calendar.YEAR);
        return year == currentYear;
    }

    private boolean dateRangeLongerThanOneDay(Date startDate, Date endDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        int startDayOfTheYear = cal.get(Calendar.DAY_OF_YEAR);
        cal.setTime(endDate);
        int endDayOfTheYear = cal.get(Calendar.DAY_OF_YEAR);
        
        return startDayOfTheYear != endDayOfTheYear;
    }
    
    private boolean isEmpty(String date) {
        if(date == null || date.length() == 0) {
            return true;
        }
        return false;
    }

}
