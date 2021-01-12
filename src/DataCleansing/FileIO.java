package DataCleansing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static List<String[]> readCsvToList(String filepath){
        List<String[]> readedLists = new ArrayList();

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                //cellen zijn door ';' gescheiden.
                readedLists.add( line.split( ";" ) );
            }
        } catch (FileNotFoundException e) {
            System.out.println("csv bestand niet gevonden.");
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return readedLists;
    }

    public static void saveToCsv(String filepath, MachineCleansingDetail machineDetails) {

        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(filepath, true));

            //ga naar nieuwe lijn en schrijf de data
            writer.print(System.getProperty("line.separator") + machineDetails.toString());

            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: data is niet opgeslagen");
        }


    }
}


