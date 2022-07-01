package BLL;

import DAL.AdditifDAO;
import DAL.DALException;
import DAL.DAOFactory;
import Entity.Additif;

import java.util.List;

public class AdditifManager {
    private static volatile AdditifManager instance;
    private static AdditifDAO additifDAO;

    private AdditifManager() {
        additifDAO = DAOFactory.getAdditifDAO();
    }

    public static AdditifManager getInstance() {
        if (instance == null) {
            synchronized (AdditifManager.class) {
                if (instance == null) {
                    instance = new AdditifManager();
                }
            }
        }
        return instance;
    }

    //    Create
    public Additif create(Additif additif) throws BLLException {
        try {
            if (additifDAO.selectByLibelle(additif.getLibelle()) == null && additif.getLibelle() != null) {
                additifDAO.create(additif);
            } else {
                return null;
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de l'additif", e);
        }
        return additif;
    }


    //    Read
    public List<Additif> selectAll() throws BLLException {
        try {
            return additifDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des additifs", e);
        }
    }

    public Additif selectById(int id) throws BLLException {
        try {
            return additifDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'additif", e);
        }
    }

    //    Update
    public void update(Additif additif) throws BLLException {
        try {
            additifDAO.update(additif);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'additif", e);
        }
    }

    //    Delete
    public void delete(Additif additif) throws BLLException {
        try {
            additifDAO.delete(additif);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'additif", e);
        }
    }


}
