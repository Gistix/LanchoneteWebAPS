package Highway;


import Entities.Ingrediente;
import Entities.Pedido;
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
public class DAOIngrediente {
    public static List<Ingrediente> TodosIngredientes() {
        return DAOBase.QueryResult("SELECT i FROM Ingrediente i ORDER BY i.numero ASC");
    }
 
    public static List<Ingrediente> TodosIngredientesNaoUtilizados() {
        return DAOBase.QueryResult("SELECT i FROM Ingrediente i "
                + "WHERE NOT EXISTS (SELECT p FROM Pedido p WHERE i.numero = p.pao OR i.numero = p.carne OR i.numero = p.salada OR i.numero = p.molho) "
                + "ORDER BY i.numero ASC");
    }
    
    public static List<Ingrediente> Ingredientes(Pedido pedido) {
        return DAOBase.QueryResult("SELECT i FROM Ingrediente i WHERE (i.numero = " + pedido.pao + " OR i.numero = " + pedido.carne + " OR i.numero = " + pedido.salada + " OR i.numero = " + pedido.molho + ")");
    }

    public static Ingrediente Ingrediente(int id) {
        return (Ingrediente)DAOBase.QueryResult("SELECT i FROM Ingrediente i WHERE (i.numero = " + id + ")").get(0);
    }    

    public static String[] NomeIngredientes(List<Ingrediente> ingredientes) {
        String[] nomes = new String[] {"", "", "", ""};
        
        for(Ingrediente ingrediente : ingredientes) {
            nomes[ingrediente.tipo-1] = ingrediente.nome;
        }
        
        return nomes;
    }
}
