package DAL;

import BLL.PersistenceManager;
import Entity.Additif;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AdditifDAO implements DAO<Additif> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Additif objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un additif");
        }
    }

    @Override
    public void update(Additif objet) throws DALException {

    }

    @Override
    public void delete(Additif objet) throws DALException {

    }

    @Override
    public List<Additif> selectAll() throws DALException {
        ResultSet rs;
        List<Additif> additifList = new ArrayList<>();
        try {
            TypedQuery<Additif> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Additif a", Additif.class);
            additifList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste d'additif");
        }
        return additifList;
    }


    @Override
    public Additif selectById(int id) throws DALException {
        return null;
    }
    public Additif selectByLibelle(String libelle) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Additif a WHERE a.libelle = :libelle", Additif.class).setParameter("libelle", libelle).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
