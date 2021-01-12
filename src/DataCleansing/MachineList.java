package DataCleansing;

import java.util.ArrayList;
import java.util.List;

public class MachineList {
    private final List<MachineCleansingDetail> machineList = new ArrayList<>();

    public MachineList() {
        //lees de scv bestand
        List<String[]> machines = FileIO.readCsvToList("src/DataCleansing/MachinesList.csv");


        for (String[] column : machines){
            /*
             * lees csv bestand en zet data in machineList
             * column 0:    serialnum
             * column 1:    model
             * column 2:    employeeName
             * column 3:    comment
             * column 4:    HDDserial
             * column 5 :   lastUpdated
             * column 6:    cleansed
             */
            String serialNum = column[0];
            String model = column[1];
            String employeeName = column[2];
            String comment = column[3];
            String serialHDD = column[4];
            String lastUpdated = column[5];
            boolean cleansed = Boolean.parseBoolean(column[6]);

            //maak een machine object
            MachineCleansingDetail machine = new MachineCleansingDetail(serialNum,model,employeeName,comment,serialHDD,lastUpdated, cleansed);

            //add deze machine in de machines ArrayList
            machineList.add(machine);
        }

    }

    public List<MachineCleansingDetail> getMachineList(){
        return machineList;

    }
}
