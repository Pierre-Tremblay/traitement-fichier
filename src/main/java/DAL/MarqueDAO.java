package DAL;

import BLL.PersistenceManager;
import Entity.Additif;
import Entity.Ingredient;
import Entity.Marque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarqueDAO implements DAO<Marque> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Marque objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'une marque");
        }
    }

    @Override
    public void update(Marque objet) throws DALException {

    }

    @Override
    public void delete(Marque objet) throws DALException {

    }

    @Override
    public List<Marque> selectAll() throws DALException {

        List<Marque> marqueList = new ArrayList<>();
        try {
            TypedQuery<Marque> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Marque a", Marque.class);
            marqueList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste de marque");
        }
        return marqueList;
    }

    @Override
    public Marque selectById(int id) throws DALException {
        return null;
    }

    public Marque selectByLibelle(String libelle) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Marque a WHERE a.libelle = :libelle", Marque.class).setParameter("libelle", libelle).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
