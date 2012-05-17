package com.novoda.android.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.novoda.android.time.DateFormatter;

public class DateFormatterTest {
    
    private DateFormatter dateFormatter;
    
    @Before
    public void before() {
        dateFormatter = new DateFormatter();
    }
    
    @Test
    public void SHOULD_changeFormatOfTheString() {
        String actual = dateFormatter.changeFormat("2012-05-13", "yyyy-MM-dd", "E d MMMM yyyy", "");
        assertEquals("Sun 13 May 2012", actual);
    }
    
    /**
     * "yyyy-MM-dd" to "yyyy-MM-dd"
     */
    @Test
    public void SHOULD_changeFormat_NOT_changeDate_IF_formatIsTheSameOfTheOriginal() {
        String actual = dateFormatter.changeFormat("2012-05-13", "yyyy-MM-dd", "yyyy-MM-dd", "");
        assertEquals("2012-05-13", actual);
    }
    
    @Test
    public void SHOULD_changeFormat_RETURN_default_IF_dateStringIsNull() {
        String actual = dateFormatter.changeFormat(null, "yyyy-MM-dd", "yyyy-MM-dd", "");
        assertEquals("", actual);
    }
    
    @Test
    public void SHOULD_changeFormat_RETURN_default_IF_originalFormatIsNull() {
        String actual = dateFormatter.changeFormat("2012-05-13", null, "yyyy-MM-dd", "");
        assertEquals("", actual);
    }
    
    @Test
    public void SHOULD_changeFormat_RETURN_default_IF_newFormatIsNull() {
        String actual = dateFormatter.changeFormat("2012-05-13", "yyyy-MM-dd", null, "");
        assertEquals("", actual);
    }
    
    @Test
    public void SHOULD_formatCurrentTime() {
        String actual = dateFormatter.formatCurrentTime("yyyy-MM-dd");
        assertNotNull(actual);
        assertEquals("2012-05-17", actual);
        assertTrue(actual.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d"));
    }
    
    @Test
    public void SHOULD_formatCurrentTime_RETURN_validDate_IF_formatIsNull() {
        String actual = dateFormatter.formatCurrentTime(null);
        assertNotNull(actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void SHOULD_formatCurrentTime_THROW_IF_formatIsNotValid() {
        dateFormatter.formatCurrentTime("ggee");
    }

}