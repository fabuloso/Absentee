package it.ale;

import java.util.*;

public class AbsenteeService{

    private Map<Date, List<String>> register;

    public AbsenteeService() {
        register = new HashMap<>();
    }

    public void absent(String name, Date date) {
        List<String> names = register.get(date);

        if(names == null) {
            names = new ArrayList<String>();
        }

        names.add(name);
        register.put(date, names);
    }

    public List<String> absentsOn(Date today) {
        return register.get(today);
    }
}
