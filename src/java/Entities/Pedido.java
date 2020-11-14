/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Giovanni
 */
@Entity
@Table(name="tb_pedidos")
public class Pedido implements Serializable {
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="tb_pedidos_numero_seq")    
    public Integer numero;
    public String usuario;
    public Integer pao;
    public Integer carne;    
    public Integer salada;
    public Integer molho;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date dataHora;
    
    public Pedido () {};      
    
    public Pedido (Integer numero, String usuario, Integer pao, Integer carne, Integer salada, Integer molho, Date dataHora) {
        this.numero = numero;
        this.usuario = usuario;
        this.pao = pao;
        this.carne = carne;
        this.salada = salada;
        this.molho = molho;    
        this.dataHora = dataHora;
    }
    
    public float Preco (List<Ingrediente> ingredientes) {
        float preco = 0.0f;
        
        for(Ingrediente ingrediente : ingredientes) {
            if (ingrediente.numero == pao || ingrediente.numero == carne || (salada != null && ingrediente.numero == salada) || (molho != null && ingrediente.numero == molho))
                preco += ingrediente.preco;
        }
        
        return preco;
    }
}