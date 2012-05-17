package com.novoda.android.time;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.novoda.android.time.DateRangeFormatter;

public class DateRangeFormatterTest {

    private DateRangeFormatter dateFormatter;
    private int currentYear;
    private int nextYear;
    
    @Before
    public void before() {
        dateFormatter = new DateRangeFormatter();
        currentYear = getCurrentYear();
        nextYear = currentYear+1;
    }
    
    @Test
    public void SHOULD_formateDateRange_RETURN_emptyString_IF_areEmptyStrings() {
        String actual = dateFormatter.formatDateRange("", "");
        assertEquals("", actual);
    }
    
    @Test
    public void SHOULD_formateDateRange_RETURN_emptyString_IF_areNullStrings() {
        String actual = dateFormatter.formatDateRange(null, null);
        assertEquals("", actual);
    }
    
    @Test
    public void SHOULD_formateDateRange_NOT_crashWithStrangeStartDate() {
        String actual = dateFormatter.formatDateRange("akshay", null);
        assertEquals("", actual);
    }
    
    @Test
    public void SHOULD_formateDateRange_NOT_crashWithStrangeEndDate() {
        String actual = dateFormatter.formatDateRange("", "jamie");
        assertEquals("", actual);
    }

    @Test
    public void SHOULD_formateDateRange_RETURN_empty_IF_areStartDateIsEmpty() {
        String text = dateFormatter.formatDateRange("", "2012-04-30");
        assertEquals("", text);
    }

    @Test
    public void SHOULD_formateDateRange_RETURN_empty_IF_areStartDateIsNull() {
        String text = dateFormatter.formatDateRange(null, "2012-04-30");
        assertEquals("", text);
    }
    
    @Test
    public void SHOULD_formateDateRange_RETURN_startDateFormatter_IF_endDateIsEmpty() {
        String text = dateFormatter.formatDateRange(currentYear + "-04-25", "");
        assertEquals("25 Apr", text);
    }
    
    @Test
    public void SHOULD_formateDateRange_RETURN_startDateFormatter_IF_endDateIsNull() {
        String text = dateFormatter.formatDateRange(currentYear + "-04-25", null);
        assertEquals("25 Apr", text);
    }

    @Test
    public void SHOULD_formatDateRange_RETURN_stringLike_ddMMMYYYY_withDifferentYears_EVEN_IF_monthIsTheSame() {
        String actual = dateFormatter.formatDateRange(currentYear + "-04-25", nextYear + "-04-30");
        assertEquals("25 Apr " + currentYear + "-30 Apr " + nextYear, actual);
    }

    @Test
    public void SHOULD_formatDateRange_RETURN_rangeSplitAcrossYearWithDifferentMonthNames() {
        String text = dateFormatter.formatDateRange(currentYear + "-04-25", nextYear + "-01-30");
        assertEquals("25 Apr " + currentYear + "-30 Jan " + nextYear, text);
    }

    @Test
    public void SHOULD_formatDateRange_RETURN_rangeLike_ddMM_ddMM_IF_yearIsTheSame() {
        String text = dateFormatter.formatDateRange(currentYear + "-04-25", currentYear + "-05-30");
        assertEquals("25 Apr-30 May", text);
    }

    @Test
    public void SHOULD_formatDateRange_RETURN_ddddMMM_IF_sameMonth_AND_sameYear() {
        String text = dateFormatter.formatDateRange(currentYear + "-04-25", currentYear + "-04-30");
        assertEquals("25-30 Apr", text);
    }

    @Test
    public void SHOULD_formatDateRange_RETURN_ddMMM_IF_startAndEndDateAreTheSame() {
        String text = dateFormatter.formatDateRange(currentYear + "-04-25", currentYear + "-04-25");
        assertEquals("25 Apr", text);
    }
    
    @Test
    public void SHOULD_formatDateRange_RETURN_ddMMMYYYY_IF_startAndEndDateAreTheSame_AND_differentYear() {
        String text = dateFormatter.formatDateRange(nextYear + "-04-30", nextYear + "-04-30");
        assertEquals("30 Apr " + nextYear, text);
    }
    
    private int getCurrentYear() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = gc.get(Calendar.YEAR);
        return year;
    }
    
}
