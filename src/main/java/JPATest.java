import BLL.ProduitManager;
import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JPATest {
    public static void main(String[] args) {
        ProduitManager instance = ProduitManager.getInstance();
        try{
            CSVReader reader = new CSVReader(new FileReader("E:\\Diginamic\\Maven\\ProjetMaven\\ traitement-fichier\\src\\main\\resources\\open-food-facts.csv"),'|');
            List<String[]>data = new ArrayList<>();
            String [] nextLine = null;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
