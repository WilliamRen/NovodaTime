package com.novoda.android.time;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DateParserTest {
    
    private DateParser dateParser;
    
    @Before
    public void before() {
        dateParser = new DateParser();
    }
    
    @Test
    public void SHOULD_toMilliseconds_RETURN_milliseconds_FROM_stringDate() {
        long actual = dateParser.toMilliseconds("2012-02-12");
        assertEquals(1329004800000l, actual, 0.1);
    }
    
    @Test(expected = RuntimeException.class)
    public void SHOULD_toMilliseconds_THROW_IF_dateIsNotValid() {
        dateParser.toMilliseconds("");
    }

}
