package BLL;

import DAL.CategorieDAO;
import DAL.DALException;
import DAL.DAOFactory;
import Entity.Categorie;

import java.util.List;

public class CategorieManager {
    private static volatile CategorieManager instance;
    private static CategorieDAO categorieDAO;

    private CategorieManager() {
        categorieDAO = DAOFactory.getCategorieDAO();
    }

    public static CategorieManager getInstance() {
        if (instance == null) {
            synchronized (CategorieManager.class) {
                if (instance == null) {
                    instance = new CategorieManager();
                }
            }
        }
        return instance;
    }

    //    Create
    public Categorie create(Categorie categorie) throws BLLException {
        try {
            categorieDAO.create(categorie);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de l'insertion de l'categorie", e);
        }
        return categorie;
    }

    //    Read
    public List<Categorie> selectAll() throws BLLException {
        try {
            return categorieDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des categories", e);
        }
    }

    public Categorie selectById(int id) throws BLLException {
        try {
            return categorieDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de la categorie", e);
        }
    }

    //    Update
    public void update(Categorie categorie) throws BLLException {
        try {
            categorieDAO.update(categorie);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la maj de la categorie", e);
        }
    }

    //    Delete
    public void delete(Categorie categorie) throws BLLException {
        try {
            categorieDAO.delete(categorie);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de la categorie", e);
        }
    }
}
