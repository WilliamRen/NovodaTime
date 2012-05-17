package com.novoda.android.time;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.novoda.android.time.Iso8601DateFormatter;

public class Iso8601DateFormatterTest {
    
    private Iso8601DateFormatter formatter;
    
    @Before
    public void before() {
        formatter = new Iso8601DateFormatter();
    }
    
    @Test
    public void SHOULD_getTimeInIso8601Format_RETURN_iso8601Format() {
        String actual = formatter.getFormattedTime(1000000000l);
        assertEquals("1970-01-12T14:46:40+0100", actual);
    }
    
    @Test
    public void SHOULD_getFormattedTimeHoursBeforNow_RETURN_iso8601FormattedDate() {
        String actual = formatter.getFormattedTimeHoursBeforNow(1000000000l, 3l);
        assertEquals("1970-01-12T11:46:40+0100", actual);
    }
    

}
