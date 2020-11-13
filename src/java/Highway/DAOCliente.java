package Highway;


import Entities.Cliente;
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
public class DAOCliente {
    public static Cliente Login(String usuario, String senha) {
        List<Cliente> clientes = DAOBase.QueryResult("SELECT c FROM Cliente c WHERE (c.usuario = '" + usuario + "' AND c.senha = '" + senha + "')");
        
        if (clientes == null || clientes.size() == 0)
            return null;
        else
            return clientes.get(0);
    }

    public static Boolean UsuarioCPFExiste(String usuario, String cpf) {
        List<Cliente> clientes = DAOBase.QueryResult("SELECT c FROM Cliente c WHERE (c.usuario = '" + usuario + "' OR c.cpf = '" + cpf + "')");
        
        return (clientes != null && clientes.size() != 0);
    }    
}
