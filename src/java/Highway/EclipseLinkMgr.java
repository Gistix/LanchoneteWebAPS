package Highway;


import Entities.*;
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
public class EclipseLinkMgr {
    public static EclipseLinkMgr instance = new EclipseLinkMgr();

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("APS4SemestrePU");
    private EntityManager em = emf.createEntityManager();
    
    public void Iniciar() {
        try {
            System.out.println("Iniciando");
            /*List<Cliente> clientes = Query("SELECT c FROM Cliente c");
            
            for (Cliente cliente : clientes)
                System.out.println(cliente.getNome() + ", " + cliente.getCpf() + ": " + cliente.getUsuario() + ", Endereço: " + cliente.getEndereco().toString());*/

            /*List<Ingrediente> ingredientes = em.createQuery("SELECT c FROM Ingrediente c", Ingrediente.class).getResultList();
            
            for (Ingrediente ingrediente : ingredientes)
                System.out.println(ingrediente.getNome());*/           
            
        } catch (Exception e) {       
            System.out.println(e.getMessage()); 
        }  
    }
    
    public static <T> List<T> Query (String query) {
        return instance.em.createQuery(query).getResultList();
    }
    
    public static Boolean Login(String usuario, String senha) {
        List<Cliente> clientes = EclipseLinkMgr.Query("SELECT c FROM Cliente c WHERE (c.usuario = '" + usuario + "' AND c.senha = '" + senha + "')");
        
        return clientes.size() != 0;
    }
 
     public static List<Ingrediente> Ingredientes(Pedido pedido) {
        return EclipseLinkMgr.Query("SELECT i FROM Ingrediente i WHERE (i.numero = " + pedido.pao + " OR i.numero = " + pedido.carne + " OR i.numero = " + pedido.salada + " OR i.numero = " + pedido.molho + ")");
    }

    public static String[] NomeIngredientes(List<Ingrediente> ingredientes) {
        String[] nomes = new String[] {"", "", "-", "-"};
        
        for(Ingrediente ingrediente : ingredientes) {
            nomes[ingrediente.tipo-1] = ingrediente.nome;
        }
        
        return nomes;
    }
     
    public static double Preco (List<Ingrediente> ingredientes) {
        double preco = 0.00;
        
        for(Ingrediente ingrediente : ingredientes)
            preco += ingrediente.preco;
        
        return preco;
    }   
}
