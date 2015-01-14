package it.ale;


import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class AbsenteeServiceTest {

    @Test public void
    notify_that_Yoda_is_not_present() {
        AbsenteeService service = new AbsenteeService();

        service.absent("Yoda");

        assertEquals(1, service.listOfAbsents().size());
    }

}
