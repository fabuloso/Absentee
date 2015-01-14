package it.ale;

import java.util.ArrayList;
import java.util.List;

public class AbsenteeService{

    List<String> list = new ArrayList<String>();

    public void absent(String name) {
        list.add(name);
    }

    public List listOfAbsents() {
        return list;
    }
}
