package Highway;


import Entities.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DAOEclipseLink {
    public static DAOEclipseLink instance = new DAOEclipseLink();

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("APS4SemestrePU");

    private static EntityManager CreateEntityManager() {
        return instance.entityManagerFactory.createEntityManager();
    }
    
    // Funções básicas query
    public static <T> void QueryInsert (T entity) {
        EntityManager entityManager = CreateEntityManager(); 
        
        entityManager.getTransaction().begin();        
        entityManager.persist(entity);      
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
    
    // Funções com entidades
    // Usuário
    public static Cliente Login(String usuario, String senha) {
        List<Cliente> clientes = DAOEclipseLink.QueryResult("SELECT c FROM Cliente c WHERE (c.usuario = '" + usuario + "' AND c.senha = '" + senha + "')");
        
        if (clientes == null || clientes.size() == 0)
            return null;
        else
            return clientes.get(0);
    }

    public static Boolean UsuarioCPFExiste(String usuario, String cpf) {
        List<Cliente> clientes = DAOEclipseLink.QueryResult("SELECT c FROM Cliente c WHERE (c.usuario = '" + usuario + "' OR c.cpf = '" + cpf + "')");
        
        return (clientes != null && clientes.size() != 0);
    }    
    
    // Ingrediente
    public static List<Ingrediente> TodosIngredientes() {
        return DAOEclipseLink.QueryResult("SELECT i FROM Ingrediente i ORDER BY i.numero ASC");
    }    
    
    public static List<Ingrediente> Ingredientes(Pedido pedido) {
        return DAOEclipseLink.QueryResult("SELECT i FROM Ingrediente i WHERE (i.numero = " + pedido.pao + " OR i.numero = " + pedido.carne + " OR i.numero = " + pedido.salada + " OR i.numero = " + pedido.molho + ")");
    }

    public static String[] NomeIngredientes(List<Ingrediente> ingredientes) {
        String[] nomes = new String[] {"", "", "", ""};
        
        for(Ingrediente ingrediente : ingredientes) {
            nomes[ingrediente.tipo-1] = ingrediente.nome;
        }
        
        return nomes;
    }
    
    // Pedido   
    public static List<Pedido> Pedidos (String usuario) {
        return DAOEclipseLink.QueryResult("SELECT p FROM Pedido p WHERE p.usuario = '" + usuario + "'");
    }
    
    public static double Preco (List<Ingrediente> ingredientes) {
        double preco = 0.00;
        
        for(Ingrediente ingrediente : ingredientes)
            preco += ingrediente.preco;
        
        return preco;
    }   
}
