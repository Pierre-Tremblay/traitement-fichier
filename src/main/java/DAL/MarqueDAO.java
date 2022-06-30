package DAL;

import Entity.Ingredient;
import Entity.Marque;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarqueDAO implements DAO<Marque> {

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
        ResultSet rs;
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
}
