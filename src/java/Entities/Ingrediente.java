/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.persistence.*;

/**
 *
 * @author Giovanni
 */
@Entity
@Table(name="tb_ingredientes")
public class Ingrediente {
    /*enum Tipo {
        Pao(1),
        Carne(2),
        Salada(3),
        Molho(4);
        
        private final int value;

        private Tipo(int value) {
            this.value = value;
        }        
    }*/
    
    public enum Tipo {
        Erro(0),
        Pao(1),
        Carne(2),
        Salada(3),
        Molho(4);
        
        private final int value;

        Tipo(int value) {
            this.value = value;
        } 
        
        public static Tipo fromInt (int value) {
            for (Tipo tipo : Tipo.values())
                if (tipo.value == value)
                    return tipo;
            
            return Tipo.Erro;
        }
    }    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="tb_ingredientes_numero_seq")  
    public int numero;
    public String nome;
    //@Enumerated(EnumType.ORDINAL)
    public int tipo;
    public float preco;
 
    public Ingrediente () {};    
    
    public Ingrediente (int numero, String nome, int tipo, float preco) {
        this.numero = numero;
        this.nome = nome;
        //this.tipo = Tipo.values()[tipo-1];
        this.tipo = tipo;
        this.preco = preco;        
    }
}
