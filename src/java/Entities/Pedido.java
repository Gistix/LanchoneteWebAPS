/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Giovanni
 */
@Entity
@Table(name="tb_pedido")
public class Pedido {
    @Id
    public int numero;
    public String usuario;
    public int pao;
    public int carne;    
    public int salada;
    public int molho;
 
    public Pedido () {};      
    
    public Pedido (int numero, String usuario, int pao, int salada, int carne, int molho) {
        this.numero = numero;
        this.usuario = usuario;
        this.pao = pao;
        this.carne = carne;
        this.salada = salada;
        this.molho = molho;     
    }
}
