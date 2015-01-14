package it.ale;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class AbsenteeServiceTest {

    private AbsenteeService service;

    @Before
    public void setup(){
        service = new AbsenteeService();
    }

    @Test public void
    notify_that_Yoda_is_not_present() {
        service.absent("Yoda");

        assertEquals(1, service.absents().size());
    }

    @Test public void
    notify_that_two_guys_are_not_presents(){
        service.absent("Yoda");
        service.absent("Luke Skywalker");

        assertEquals(2, service.absents().size());
    }




}
