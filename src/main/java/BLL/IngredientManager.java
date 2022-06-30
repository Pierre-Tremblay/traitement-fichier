package BLL;

import DAL.DALException;
import DAL.DAOFactory;
import DAL.IngredientDAO;
import Entity.Ingredient;

import java.util.List;

public class IngredientManager {
    private static volatile IngredientManager instance;
    private static IngredientDAO ingredientDAO;

    private IngredientManager() {
        ingredientDAO = DAOFactory.getIngredientDAO();
    }

    public static IngredientManager getInstance() {
        if (instance == null) {
            synchronized (IngredientManager.class) {
                if (instance == null) {
                    instance = new IngredientManager();
                }
            }
        }
        return instance;
    }

    //    Create
    public Ingredient create(Ingredient ingredient) throws BLLException {
        try {
            ingredientDAO.create(ingredient);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de l'insertion de l'ingredient", e);
        }
        return ingredient;
    }

    //    Read
    public List<Ingredient> selectAll() throws BLLException {
        try {
            return ingredientDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des ingredients", e);
        }
    }

    public Ingredient selectById(int id) throws BLLException {
        try {
            return ingredientDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'ingredient", e);
        }
    }

    //    Update
    public void update(Ingredient ingredient) throws BLLException {
        try {
            ingredientDAO.update(ingredient);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la maj de l'ingredient", e);
        }
    }

    //    Delete
    public void delete(Ingredient ingredient) throws BLLException {
        try {
            ingredientDAO.delete(ingredient);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'ingredient", e);
        }
    }
}
