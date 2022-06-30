package DAL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ConnexionJPA {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityManager loadDB() throws DALException{
        if(emf == null){
            emf = javax.persistence.Persistence.createEntityManagerFactory("jpa-connect");
            try{
                em = emf.createEntityManager();
            } catch (Exception e){
                throw new DALException("Erreur lors de la connexion avec entityManager");
            }
        }
        return em;
    }
    public static EntityManager getProperty() throws DALException{
        return loadDB();
    }
}