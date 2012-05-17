package com.novoda.android.date;

import org.joda.time.DateTime;

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
        } else {
            return formatDateRangeFromStringDates(startDateTime, endDateTime);
        }
    }
    
    private String formatDateRangeFromStringDates(String startDateTime, String endDateTime) {
        final DateTime startDate = new DateTime(startDateTime);
        if (!isEmpty(endDateTime)) {
            final DateTime endDate = new DateTime(endDateTime);
            if (dateRangeLongerThanOneDay(startDate, endDate)) {
                return formatDateRange(startDate, endDate);
            }
        }
        return formatSingleDate(startDate);
    }

    private String formatDateRange(DateTime startDate, DateTime endDate) {
        return formatStartDate(startDate, endDate) + "-" + formatSingleDate(endDate);
    }

    private String formatStartDate(DateTime startDate, DateTime endDate) {
        return startDate.toString(getDateRangeFormatter(startDate, endDate));
    }

    private String getDateRangeFormatter(DateTime startDate, DateTime endDate) {
        final boolean datesAreInTheSameMonth = startDate.getMonthOfYear() == endDate.getMonthOfYear();
        final boolean datesAreInTheSameYear = startDate.getYear() == endDate.getYear();
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

    private String formatSingleDate(DateTime date) {
        return date.toString(getDateFormatterString(date));
    }

    private String getDateFormatterString(DateTime date) {
        if (dateIsInTheCurrentYear(date)) {
            return "d MMM";
        } else {
            return "d MMM yyyy";
        }
    }

    private boolean dateIsInTheCurrentYear(DateTime date) {
        final int currentYear = DateTime.now().year().get();
        return date.year().get() == currentYear;
    }

    private boolean dateRangeLongerThanOneDay(DateTime startDate, DateTime endDate) {
        return startDate.getDayOfYear() != endDate.getDayOfYear();
    }
    
    private boolean isEmpty(String date) {
        if(date == null || date.length() == 0) {
            return true;
        }
        return false;
    }

}
