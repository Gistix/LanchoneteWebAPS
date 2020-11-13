package Highway;


import Entities.Pedido;
import Entities.Ingrediente;
import java.util.List;

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
    
    public static double Preco (List<Ingrediente> ingredientes) {
        double preco = 0.00;
        
        for(Ingrediente ingrediente : ingredientes)
            preco += ingrediente.preco;
        
        return preco;
    }   
}
