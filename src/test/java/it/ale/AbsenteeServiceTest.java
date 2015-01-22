package it.ale;

import org.apache.commons.collections.ListUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static it.ale.AbsenteeServiceTest.YESTERDAY;
import static java.lang.Integer.valueOf;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.apache.commons.collections.ListUtils.EMPTY_LIST;
import static org.apache.commons.collections.ListUtils.isEqualList;

public class AbsenteeServiceTest {

    private AbsenteeService service;
    public static final Date TODAY = new Date();
    public static final Date YESTERDAY = new Date(1);

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

    @Test public void
    realizes_that_yoda_was_absent_yesterday_and_today(){
        service.absent("Yoda", YESTERDAY);
        service.absent("Yoda", TODAY);

        assertTrue(service.absentsOn(YESTERDAY).contains("Yoda"));
        assertTrue(service.absentsOn(TODAY).contains("Yoda"));
    }


    @Test public void
    shows_all_the_absents_for_yoda() throws Exception {
        service.absent("Yoda", YESTERDAY);
        service.absent("Yoda", TODAY);

        List<Date> list = service.absentDatesFor("Yoda");
        assertEquals(list.get(0), YESTERDAY);
    }

    @Test public void
    shows_that_nobody_was_absents_today(){
        service.addLesson(TODAY);

        assertTrue(isEqualList(EMPTY_LIST, service.absentsOn(TODAY)));
    }

    @Ignore
    @Test public void
    if_Yoda_is_absents_but_there_is_no_lesson_nothing_happends() throws Exception {
        service.absent("Yoda", TODAY);

        assertFalse(service.absentsOn(TODAY).contains("Yoda"));
    }
}
