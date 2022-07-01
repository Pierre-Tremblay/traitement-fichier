package DAL;

import Entity.Additif;
import Entity.Marque;
import Entity.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO implements DAO<Produit> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-connect");
    private final EntityManager em = emf.createEntityManager();
    @Override
    public void create(Produit objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un produit");
        }
    }

    @Override
    public void update(Produit objet) throws DALException {

    }

    @Override
    public void delete(Produit objet) throws DALException {

    }

    @Override
    public List<Produit> selectAll() throws DALException {
        ResultSet rs;
        List<Produit> produitList = new ArrayList<>();
        try {
            TypedQuery<Produit> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Produit a", Produit.class);
            produitList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste de produit");
        }
        return produitList;
    }

    @Override
    public Produit selectById(int id) throws DALException {
        return null;
    }

}
