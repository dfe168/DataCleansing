package DataCleansing;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private final List<String[]> loadedEmployees;

    public Employee(){
        loadedEmployees = FileIO.readCsvToList("src/DataCleansing/employees.csv");
    }

    public List<String> getFullNames(){
        List<String> employeeNames = new ArrayList<>();

        for(String[] emp : loadedEmployees) {

            String firstname = emp[1];
            String lastname = emp[2];

            employeeNames.add( firstname+ " " + lastname);
        }
        return employeeNames;
    }
}
