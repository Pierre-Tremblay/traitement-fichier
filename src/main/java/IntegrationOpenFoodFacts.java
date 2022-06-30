import BLL.*;
import Entity.Categorie;
import Entity.Produit;

import java.io.IOException;
import java.util.List;

public class IntegrationOpenFoodFacts {
    public static void main(String[] args) throws BLLException, IOException {
        List<String[]> data = ReadFileManager.readFile();
        CategorieManager categorieManager = CategorieManager.getInstance();
        AdditifManager additifManager = AdditifManager.getInstance();
        AllergeneManager allergeneManager = AllergeneManager.getInstance();
        MarqueManager marqueManager = MarqueManager.getInstance();
        IngredientManager ingredientManager = IngredientManager.getInstance();
        ProduitManager produitManager = ProduitManager.getInstance();


    }
}
