package DAL;

import BLL.PersistenceManager;
import Entity.Additif;
import Entity.Allergene;
import Entity.Categorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO implements DAO<Categorie> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Categorie objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'une catégorie");
        }
    }

    @Override
    public void update(Categorie objet) throws DALException {

    }

    @Override
    public void delete(Categorie objet) throws DALException {

    }

    @Override
    public List<Categorie> selectAll() throws DALException {
        ResultSet rs;
        List<Categorie> categorieList = new ArrayList<>();
        try {
            TypedQuery<Categorie> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Categorie a", Categorie.class);
            categorieList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste de catégorie");
        }
        return categorieList;
    }

    @Override
    public Categorie selectById(int id) throws DALException {
        return null;
    }
    public Categorie selectByLibelle(String libelle) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Categorie a WHERE a.libelle = :libelle", Categorie.class).setParameter("libelle", libelle).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
