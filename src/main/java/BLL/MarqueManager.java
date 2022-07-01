package BLL;

import DAL.DALException;
import DAL.DAOFactory;
import DAL.MarqueDAO;
import Entity.Marque;

import java.util.List;

public class MarqueManager {
    private static volatile MarqueManager instance;
    private static MarqueDAO marqueDAO;

    private MarqueManager() {
        marqueDAO = DAOFactory.getMarqueDAO();
    }

    public static MarqueManager getInstance() {
        if (instance == null) {
            synchronized (MarqueManager.class) {
                if (instance == null) {
                    instance = new MarqueManager();
                }
            }
        }
        return instance;
    }

    //    Create
    public Marque create(Marque marque) throws BLLException {
        try {
            if(marqueDAO.selectByLibelle(marque.getLibelle()) == null && marque.getLibelle() != null) {
                marqueDAO.create(marque);
            } else {
                return marqueDAO.selectByLibelle(marque.getLibelle());
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de la marque", e);
        }
        return marque;
    }

    //    Read
    public List<Marque> selectAll() throws BLLException {
        try {
            return marqueDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des marques", e);
        }
    }

    public Marque selectById(int id) throws BLLException {
        try {
            return marqueDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de la marque", e);
        }
    }

    //    Update
    public void update(Marque marque) throws BLLException {
        try {
            marqueDAO.update(marque);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la maj de la marque", e);
        }
    }

    //    Delete
    public void delete(Marque marque) throws BLLException {
        try {
            marqueDAO.delete(marque);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de la marque", e);
        }
    }
}
