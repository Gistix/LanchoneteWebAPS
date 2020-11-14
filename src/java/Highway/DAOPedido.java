package Highway;


import Entities.Pedido;
import Entities.Ingrediente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giovanni
 */
public class DAOPedido {
    public static List<Pedido> Pedidos (String usuario) {
        return DAOBase.QueryResult("SELECT p FROM Pedido p WHERE p.usuario = '" + usuario + "' "
                + "ORDER BY p.numero DESC");
    }

    public static List<Pedido> TodosPedidos () {
        return DAOBase.QueryResult("SELECT p FROM Pedido p "
                + "ORDER BY p.numero DESC");
    }    

    public static List<Pedido> TodosPedidosAsc () {
        return DAOBase.QueryResult("SELECT p FROM Pedido p "
                + "ORDER BY p.numero ASC");
    }   
    
    public static List<Pedido> PedidosIntervalo (String inicio, String fim) {
        /*EntityManager entityManager = DAOBase.CreateEntityManager();   
        Query query = entityManager.createNativeQuery("SELECT p FROM Pedido p "
                + "WHERE p.dataHora >= CAST(?1 as TIMESTAMP) "
                + "ORDER BY p.numero ASC", Pedido.class);
        query.setParameter(1, inicio, TemporalType.DATE);
        //query.setParameter(2, fim);               
             
        List<Pedido> result = query.getResultList();       
        entityManager.close();        
        
        return result; */
        /*DAOBase.QueryResult("SELECT p FROM Pedido p "
                + "WHERE p.dataHora >= '" + inicio + "' AND p.dataHora <= '" + fim + "' "
                + "ORDER BY p.numero ASC");*/
        
        return DAOBase.QueryResult("SELECT p FROM Pedido p "
                + "WHERE p.dataHora >= CAST('" + inicio + "' as TIMESTAMP) AND p.dataHora <= CAST('" + fim + "' as TIMESTAMP) "
                + "ORDER BY p.dataHora ASC");
    }    

    public static List<Pedido> PedidosIntervalo (Date inicio, Date fim) {
        List<Pedido> todosPedidos = DAOPedido.TodosPedidosAsc(); 
        List<Pedido> pedidos = new ArrayList<Pedido>();
        
        for(Pedido pedido : todosPedidos) {
            if (pedido.dataHora.after(inicio) && pedido.dataHora.before(fim) || pedido.dataHora.equals(inicio) || pedido.dataHora.equals(fim))
                pedidos.add(pedido);
        }
        
        return pedidos;
    }  
    
    public static double Preco (List<Ingrediente> ingredientes) {
        double preco = 0.00;
        
        for(Ingrediente ingrediente : ingredientes)
            preco += ingrediente.preco;
        
        return preco;
    }   
}
