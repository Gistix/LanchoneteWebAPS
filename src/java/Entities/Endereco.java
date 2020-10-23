/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.SQLException;
import org.postgresql.util.PGobject;

/**
 *
 * @author Giovanni
 */
public class Endereco {
    private String rua;
    private int numero;
    private String cep;
    
    public Endereco (String rua, int numero, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String toString() {
        //return String.format("\"s%\", %d: %s)", rua, numero, cep); 
        return rua + ", " + numero + ", " + cep;
    }
    
    public PGobject ToDBData () throws SQLException {
        //String endereco = String.format("(s%,%d,%s)", rua, numero, cep);
        String endereco = "(\"" + rua + "\", " + numero + ", " + cep + ")";
        
        PGobject jsonbObject = new PGobject();
        jsonbObject.setType("endereco");
        jsonbObject.setValue(endereco);
        
        return jsonbObject;
    }
    
    public static Endereco FromDBData (PGobject dbData) {
        String str = dbData.toString();
        str = str.substring(1, str.length()-1);
        String[] endereco = str.split(",");

        String rua = endereco[0].substring(1, endereco[0].length()-1);
        Integer num = Integer.parseInt(endereco[1]);
        String cep = endereco[2];
        
        return new Endereco(rua, num, cep);
    }    
}
