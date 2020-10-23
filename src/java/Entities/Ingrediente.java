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
    
    enum Tipo {
        Erro(0),
        Pao(1),
        Carne(2),
        Salada(3),
        Molho(4);
        
        private final int value;

        Tipo(int value) {
            this.value = value;
        } 
        
        static Tipo fromInt (int value) {
            for (Tipo tipo : Tipo.values())
                if (tipo.value == value)
                    return tipo;
            
            return Tipo.Erro;
        }
    }    
    
    @Id
    private int numero;
    private String nome;
    //@Enumerated(EnumType.ORDINAL)
    private int tipo;
    private float preco;
 
    public Ingrediente () {};    
    
    public Ingrediente (int numero, String nome, int tipo, float preco) {
        this.numero = numero;
        this.nome = nome;
        //this.tipo = Tipo.values()[tipo-1];
        this.tipo = tipo;
        this.preco = preco;        
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipoEnum() {
        return Tipo.fromInt(tipo);
        //return Tipo.values()[tipo-1];
    }

    public void setTipoEnum(Tipo tipo) {
        this.tipo = tipo.value;
    }    
    
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
