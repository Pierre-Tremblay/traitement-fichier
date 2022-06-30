package BLL;

import DAL.DALException;
import DAL.DAOFactory;
import DAL.ProduitDAO;
import Entity.Produit;

import java.util.List;

public class ProduitManager {
    private static volatile ProduitManager instance;
    private static ProduitDAO produitDAO;

    private ProduitManager() {
        produitDAO = DAOFactory.getProduitDAO();
    }

    public static ProduitManager getInstance() {
        if (instance == null) {
            synchronized (ProduitManager.class) {
                if (instance == null) {
                    instance = new ProduitManager();
                }
            }
        }
        return instance;
    }

    //    Create
    public Produit create(Produit produit) throws BLLException {
        try {
            produitDAO.create(produit);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de l'insertion du produit", e);
        }
        return produit;
    }

    //    Read
    public List<Produit> selectAll() throws BLLException {
        try {
            return produitDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des produits", e);
        }
    }

    public Produit selectById(int id) throws BLLException {
        try {
            return produitDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection du produit", e);
        }
    }

    //    Update
    public void update(Produit produit) throws BLLException {
        try {
            produitDAO.update(produit);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la maj du produit", e);
        }
    }

    //    Delete
    public void delete(Produit produit) throws BLLException {
        try {
            produitDAO.delete(produit);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression du produit", e);
        }
    }
}