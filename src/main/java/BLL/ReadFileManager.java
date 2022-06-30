package BLL;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileManager {


    public static List<String[]> readFile() throws IOException {
        File file = new File("src/main/resources/open-food-facts.csv");
        FileReader fr = new FileReader(file);
        CSVReader csvReader = new CSVReader(fr, '|');

        List<String[]> data = new ArrayList<>();

        String[] nextLine;
        while ((nextLine = csvReader.readNext()) != null) {
            int size = nextLine.length;

            // ligne vide
            if (size == 0) {
                continue;
            }
            String debut = nextLine[0].trim();
            if (debut.length() == 0 && size == 1) {
                continue;
            }

            // ligne de commentaire
            if (debut.startsWith("#")) {
                continue;
            }
            data.add(nextLine);
        }

        return data;
    }
}
