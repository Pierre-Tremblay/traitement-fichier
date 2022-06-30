package DAL;

import Entity.Categorie;
import Entity.Ingredient;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO implements DAO<Ingredient> {

    @Override
    public void create(Ingredient objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un ingrédient");
        }
    }

    @Override
    public void update(Ingredient objet) throws DALException {

    }

    @Override
    public void delete(Ingredient objet) throws DALException {

    }

    @Override
    public List<Ingredient> selectAll() throws DALException {
        ResultSet rs;
        List<Ingredient> ingredientList = new ArrayList<>();
        try {
            TypedQuery<Ingredient> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Ingredient a", Ingredient.class);
            ingredientList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste de catégorie");
        }
        return ingredientList;
    }

    @Override
    public Ingredient selectById(int id) throws DALException {
        return null;
    }
}
