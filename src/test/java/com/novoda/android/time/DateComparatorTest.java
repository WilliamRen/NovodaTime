package com.novoda.android.time;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * TODO test are not very flexible I need to change the DateComparator
 * to receive the date as a dependency so it can be tested properly.
 */
public class DateComparatorTest {
    
    private DateComparator dateComparator;
    private int year; 
    private int month;
    private int day;
    
    @Before
    public void before() {
        dateComparator = new DateComparator();
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR); 
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }
    
    @Test
    public void isPastDate_SHOULD_returnTrueIsDateIsInThePast_GIVEN_yearMonthDay() {
        assertTrue(dateComparator.isPastDate(1979, 1, 1));
    }
    
    @Test
    public void isPastDate_SHOULD_returnFalse_IF_dateIsInTheFutureYear() {
        int nextYear = year + 1;
        assertFalse(dateComparator.isPastDate(nextYear, month, day));
    }
    
    @Test
    public void isPastDate_SHOULD_returnFalse_IF_dateIsInTheFutureMonth() {
        int nextMonth = month + 1;
        assertFalse(dateComparator.isPastDate(year, nextMonth, day));
    }
    
    @Test
    public void isPastDate_SHOULD_returnFalse_IF_dateIsInTheFutureDay() {
        int nextDay = day + 1;
        assertFalse(dateComparator.isPastDate(year, month, nextDay));
    }
    
    @Test
    public void isPastDate_SHOULD_returnTrue_IF_dateIsInThePastYear() {
        int previousYear = year - 1;
        assertTrue(dateComparator.isPastDate(previousYear, month, day));
    }
    
    @Test
    public void isPastDate_SHOULD_returnTrue_IF_dateIsInThePastMonth() {
        int previousMonth = month - 1;
        assertTrue(dateComparator.isPastDate(year, previousMonth, day));
    }
    
    @Test
    public void isPastDate_SHOULD_returnTrue_IF_dateIsInThePastDay() {
        int previousDay = day - 1;
        assertTrue(dateComparator.isPastDate(year, month, previousDay));
    }
    
    @Test
    public void isPastDate_SHOULD_returnFalse_IF_dateIsToday() {
        assertFalse(dateComparator.isPastDate(year, month, day));
    }
    
    @Test
    public void isPastDate_SHOULD_returnFalse_IF_dateIsToday_GIVEN_aDate() {
        Calendar calendar = Calendar.getInstance();
        assertFalse(dateComparator.isPastDate(calendar.getTime()));
    }
    
    @Test
    public void isPastDate_SHOULD_returnTrueIsDateIsInThePast_GIVEN_aDate() {
        Date date = new Date(0);
        assertTrue(dateComparator.isPastDate(date));
    }
    
    @Test
    public void isPastDate_SHOULD_returnFalse_IF_dateIsNull() {
        assertFalse(dateComparator.isPastDate(null));
    }
    
    @Test
    public void isPastDate_SHOULD_returnFalse_IF_dateIsInvalid() {
        assertFalse(dateComparator.isPastDate(23200, 23, 23));
    }

}
