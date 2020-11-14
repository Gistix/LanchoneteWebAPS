package Highway;

import java.util.List;
import javax.persistence.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giovanni
 */
public class DAOBase {
    public static DAOBase instance = new DAOBase();

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("APS4SemestrePU");

    public static EntityManager CreateEntityManager() {
        return instance.entityManagerFactory.createEntityManager();
    }
    
    public static <T> void QueryInsert (T entity) {
        EntityManager entityManager = CreateEntityManager(); 
        
        entityManager.getTransaction().begin();        
        entityManager.persist(entity);      
        entityManager.getTransaction().commit();   
        
        entityManager.close();
    }

    public static <T> void QueryRemove (T entity) {
        EntityManager entityManager = CreateEntityManager(); 
        
        entityManager.getTransaction().begin(); 
        entityManager.remove(entityManager.merge(entity));    
        entityManager.getTransaction().commit();   
        
        entityManager.close();
    }    
    
    public static <T> List<T> QueryResult (String query) {
        EntityManager entityManager = CreateEntityManager();        
        List<T> result = entityManager.createQuery(query).getResultList();       
        entityManager.close();
        
        return result;
    }  
    
    public static int QueryUpdate (String query) {
        EntityManager entityManager = CreateEntityManager();           
        int result = entityManager.createQuery(query).executeUpdate();       
        entityManager.close();
        
        return result;
    }
}
