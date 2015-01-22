package it.ale;

import java.util.*;

import static org.apache.commons.collections.MapUtils.getObject;

public class AbsenteeService {

    private Map<Date, List<String>> presenceBook = new HashMap<Date, List<String>>();

    public AbsenteeService() {
    }

    public void absent(String name, Date date) {
        List<String> names = absenteeUsersOn(date);
        names.add(name);
        presenceBook.put(date, names);
    }

    public List<String> absentsOn(Date today) {
        return presenceBook.get(today);
    }

    public List<Date> absentDatesFor(String name) {
        return retrieveTheAbsenteeOn(name, presenceBook.keySet());
    }

    private List<Date> retrieveTheAbsenteeOn(String name, Set<Date> dates) {
        List<Date> absenteeDates = new ArrayList<Date>();
        for (Date date : dates) {
            if (presenceBook.get(date).contains(name)) {
                absenteeDates.add(date);
            }
        }
        return absenteeDates;
    }

    private List<String> absenteeUsersOn(Date date) {
        return (List<String>) getObject(presenceBook, date, new ArrayList<String>());
    }

    public void addLesson(Date lessonDate) {
        presenceBook.put(lessonDate, new ArrayList<String>());
    }
}
