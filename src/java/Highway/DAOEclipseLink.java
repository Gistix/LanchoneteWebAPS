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

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("APS4SemestrePU");
    private EntityManager em = emf.createEntityManager();
    
    // Funções básicas query
    public static Query Query (String query) {
        return instance.em.createQuery(query);
    }

    public static <T> void QueryInsert (T entity) {
        if(!instance.em.getTransaction().isActive())
            instance.em.getTransaction().begin();
        
        instance.em.persist(entity);
        instance.em.getTransaction().commit();
    }   

    public static void QueryInsert (Query query) {
        if(!instance.em.getTransaction().isActive())
            instance.em.getTransaction().begin();   
        
        query.executeUpdate();
        
        instance.em.getTransaction().commit();
    }
    
    public static void NovoPedido (Pedido pedido) {
        /*Query query = instance.em.createNativeQuery("INSERT INTO tb_pedidos (usuario, pao, carne, salada, molho, dataHora)"
                + " VALUES (?, ?, ?, ?, ?, ?)");
        
        query.setParameter(1, pedido.usuario);
        query.setParameter(2, pedido.pao);
        query.setParameter(3, pedido.carne);
        query.setParameter(4, pedido.salada);
        query.setParameter(5, pedido.molho);
        query.setParameter(6, pedido.dataHora);*/
          
        String isoDatePattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        
        Query query = instance.em.createNativeQuery("INSERT INTO tb_pedidos VALUES (nextval('tb_pedidos_numero_seq'), '"+pedido.usuario+"', "+pedido.pao+", "+pedido.carne+", "+pedido.salada+", "+pedido.molho+", '"+simpleDateFormat.format(pedido.dataHora)+"');");
        
        DAOEclipseLink.QueryInsert(query);
    }
    
    public static <T> List<T> QueryResult (String query) {
        return Query(query).getResultList();
    }   

    public static <T> T QuerySingleResult (String query) {
        return (T) Query(query).getSingleResult();
    }    
    
    public static int QueryUpdate (String query) {
        return Query(query).executeUpdate();
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
