package it.ale;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static java.lang.Integer.valueOf;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class AbsenteeServiceTest {

    private AbsenteeService service;
    public static final Date TODAY = new Date();

    @Before
    public void setup(){
        service = new AbsenteeService();
    }

    @Test public void
    notifies_that_two_guys_are_not_presents_today(){
        service.absent("Dart Vader", TODAY);
        service.absent("Yoda", TODAY);

        assertEquals(2, service.absentsOn(TODAY).size());
    }

    @Test public void
    realizes_that_yoda_today_is_not_present(){
        service.absent("Yoda", TODAY);

        assertTrue(service.absentsOn(TODAY).contains("Yoda"));
    }

}
