package DAL;

import Entity.Additif;
import Entity.Allergene;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AllergeneDAO implements DAO<Allergene>{

    @Override
    public void create(Allergene objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un allergene " );
        }
    }

    @Override
    public void update(Allergene objet) throws DALException {

    }

    @Override
    public void delete(Allergene objet) throws DALException {

    }

    @Override
    public List<Allergene> selectAll() throws DALException {
        ResultSet rs;
        List<Allergene> allergeneList = new ArrayList<>();
        try {
            TypedQuery<Allergene> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Allergene a", Allergene.class);
            allergeneList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste d'allergene");
        }
        return allergeneList;
    }

    @Override
    public Allergene selectById(int id) throws DALException {
        return null;
    }
}
