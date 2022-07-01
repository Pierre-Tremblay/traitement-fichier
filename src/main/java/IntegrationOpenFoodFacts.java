import BLL.*;
import Entity.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegrationOpenFoodFacts {
    public static void main(String[] args) throws BLLException, IOException {
        AdditifManager additifManager = AdditifManager.getInstance();
        AllergeneManager allergeneManager = AllergeneManager.getInstance();
        CategorieManager categorieManager = CategorieManager.getInstance();
        IngredientManager ingredientManager = IngredientManager.getInstance();
        MarqueManager marqueManager = MarqueManager.getInstance();
        ProduitManager produitManager = ProduitManager.getInstance();
        List<String[]> data = ReadFileManager.readFile();
        for (String[] line : data) {
            if (data.indexOf(line) == 0) {
                continue;
            }
            Set<Additif> additifsSet = new HashSet<>();
            String[] additifs = line[29].split(",");
            for (String addit : additifs) {
                Additif additif = new Additif();
                additif.setLibelle(addit.trim());
                additif = additifManager.create(additif);
                additifsSet.add(additif);
            }
            Set<Allergene> allergenesSet = new HashSet<>();
            String[] allergenes = line[28].split(",");
            for (String allerg : allergenes) {
                Allergene allergene = new Allergene();
                allergene.setLibelle(allerg.trim());
                allergene = allergeneManager.create(allergene);
                allergenesSet.add(allergene);
            }

            Set<Ingredient> ingredientsSet = new HashSet<>();
            String[] ingredients = line[4].split(",|-|;");
            for (String ingred : ingredients) {
                Ingredient ingredient = new Ingredient();
                int max = Math.min(ingred.length(), 254);
                ingredient.setLibelle(ingred.substring(0, max).trim().replace("_", "").replace(".", "").replace("*", ""));
                ingredient = ingredientManager.create(ingredient);
                ingredientsSet.add(ingredient);

            }


            Categorie categorie = new Categorie();
            categorie.setLibelle(line[0].trim());
            categorie = categorieManager.create(categorie);

            Marque marque = new Marque();
            marque.setLibelle(line[1].trim());
            marque = marqueManager.create(marque);


            Produit produit = new Produit();
            produit.setMarque(marque);
            produit.setCategorie(categorie);
            produit.setAllergenes(allergenesSet);
            produit.setAdditifs(additifsSet);
            produit.setIngredients(ingredientsSet);
            produit.setScoreNutritionnel(ScoreNutritionnel.valueOf(line[3].trim().toUpperCase()));
            ValeurNutritive valeurNutritionelle = new ValeurNutritive();
            int maxEnergie = Math.min(line[5].length(), 254);
            valeurNutritionelle.setEnergies(line[5].substring(0, maxEnergie).trim());
            valeurNutritionelle.setGraisses(line[6].trim());
            valeurNutritionelle.setSucres(line[7].trim());
            valeurNutritionelle.setFibres(line[8].trim());
            valeurNutritionelle.setProteines(line[9].trim());
            valeurNutritionelle.setSel(line[10].trim());
            valeurNutritionelle.setVitA(line[11].trim());
            valeurNutritionelle.setVitD(line[12].trim());
            valeurNutritionelle.setVitE(line[13].trim());
            valeurNutritionelle.setVitK(line[14].trim());
            valeurNutritionelle.setVitC(line[15].trim());
            valeurNutritionelle.setVitB1(line[16].trim());
            valeurNutritionelle.setVitB2(line[17].trim());
            valeurNutritionelle.setVitPP(line[18].trim());
            valeurNutritionelle.setVitB6(line[19].trim());
            valeurNutritionelle.setVitB9(line[20].trim());
            valeurNutritionelle.setVitB12(line[21].trim());
            valeurNutritionelle.setCalcium(line[22].trim());
            valeurNutritionelle.setMagnesium(line[23].trim());
            valeurNutritionelle.setIron(line[24].trim());
            valeurNutritionelle.setFer(line[25].trim());
            valeurNutritionelle.setBetaCarotene(line[26].trim());
            valeurNutritionelle.setHuildeDePalme(Boolean.parseBoolean(line[27].trim()));
            produit.setValeurNutritive(valeurNutritionelle);
            produitManager.create(produit);

        }

    }
}
