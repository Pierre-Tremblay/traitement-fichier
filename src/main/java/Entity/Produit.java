package Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "id_marque")
    private Marque marque;


    @Enumerated(EnumType.STRING)
    private ScoreNutritionnel scoreNutritionnel;

    @ManyToMany
    @JoinTable(name = "produits_ingredients",
            joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredients", referencedColumnName = "id"))
    private Set<Ingredient> ingredients;
    @ManyToMany
    @JoinTable(name = "produits_additifs",
            joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_additif", referencedColumnName = "id"))
    private Set<Additif> additifs;
    @ManyToMany
    @JoinTable(name = "produits_allergenes",
            joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "id"))
    private Set<Allergene> allergenes;

    @Embedded
    private ValeurNutritive valeurNutritive;

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }



    public ScoreNutritionnel getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public void setScoreNutritionnel(ScoreNutritionnel scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(Set<Additif> additifs) {
        this.additifs = additifs;
    }

    public Set<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(Set<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public ValeurNutritive getValeurNutritive() {
        return valeurNutritive;
    }

    public void setValeurNutritive(ValeurNutritive valeurNutritive) {
        this.valeurNutritive = valeurNutritive;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append("id=").append(id);
        sb.append(", categorie=").append(categorie);
        sb.append(", marque=").append(marque);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", additifs=").append(additifs);
        sb.append(", allergenes=").append(allergenes);
        sb.append('}');
        return sb.toString();
    }
}
