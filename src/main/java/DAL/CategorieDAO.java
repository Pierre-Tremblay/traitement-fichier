package DAL;

import Entity.Allergene;
import Entity.Categorie;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO implements DAO<Categorie> {

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
}
