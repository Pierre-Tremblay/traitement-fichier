package BLL;

import DAL.AllergeneDAO;
import DAL.DALException;
import DAL.DAOFactory;
import Entity.Allergene;

import java.util.List;

public class AllergeneManager {
    private static volatile AllergeneManager instance;
    private static AllergeneDAO allergeneDAO;

    private AllergeneManager() {
        allergeneDAO = DAOFactory.getAllergeneDAO();
    }

    public static AllergeneManager getInstance() {
        if (instance == null) {
            synchronized (AllergeneManager.class) {
                if (instance == null) {
                    instance = new AllergeneManager();
                }
            }
        }
        return instance;
    }

    //    Create
    public Allergene create(Allergene allergene) throws BLLException {
        try {
            if (allergeneDAO.selectByLibelle(allergene.getLibelle()) == null && allergene.getLibelle() != null) {
                allergeneDAO.create(allergene);
            } else {
                return null;
            }
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de l'insertion de l'allergene", e);
        }
        return allergene;
    }

    //    Read
    public List<Allergene> selectAll() throws BLLException {
        try {
            return allergeneDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des allergenes", e);
        }
    }

    public Allergene selectById(int id) throws BLLException {
        try {
            return allergeneDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'allergene", e);
        }
    }

    //    Update
    public void update(Allergene allergene) throws BLLException {
        try {
            allergeneDAO.update(allergene);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'allergene", e);
        }
    }

    //    Delete
    public void delete(Allergene allergene) throws BLLException {
        try {
            allergeneDAO.delete(allergene);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'allergene", e);
        }
    }
}
