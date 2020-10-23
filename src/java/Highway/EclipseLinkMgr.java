package Highway;


import Entities.*;
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
public class EclipseLinkMgr {
    public static EclipseLinkMgr instance = new EclipseLinkMgr();

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("APS4SemestrePU");
    private EntityManager em = emf.createEntityManager();
    
    public void Iniciar() {
        try {
            List<Cliente> clientes = Query("SELECT c FROM Cliente c");
            
            for (Cliente cliente : clientes)
                System.out.println(cliente.getNome() + ", " + cliente.getCpf() + ": " + cliente.getUsuario() + ", Endereço: " + cliente.getEndereco().toString());

            /*List<Ingrediente> ingredientes = em.createQuery("SELECT c FROM Ingrediente c", Ingrediente.class).getResultList();
            
            for (Ingrediente ingrediente : ingredientes)
                System.out.println(ingrediente.getNome());*/           
            
        } catch (Exception e) {       
            System.out.println(e.getMessage()); 
        }  
    }
    
    public <T> List<T> Query (String query)  {
        return em.createQuery(query).getResultList();
    }
}
