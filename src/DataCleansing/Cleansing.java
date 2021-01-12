package DataCleansing;

import java.util.Date;
import java.util.List;

public class Cleansing {
    private final Employee employees;

    public Cleansing() {
        this.employees = new Employee();
    }

    public List<String> getEmployees(){
        return employees.getFullNames();
    }

    public void cleansed(String serialNum, String model, String employeeName, String comment, String serialHDD, boolean cleansed){

        String dateTime = new Date().toString();

        MachineCleansingDetail machineCleansing =
                new MachineCleansingDetail(serialNum,model,employeeName,comment,serialHDD,dateTime,cleansed);

        //sla machine cleansed details op in de csv-bestand
        saveToCsv(machineCleansing);
    }

    public void saveToCsv(MachineCleansingDetail cleansedMachine){
        String filepath = "src/DataCleansing/MachinesList.csv";
        FileIO.saveToCsv(filepath, cleansedMachine);
    }
}
