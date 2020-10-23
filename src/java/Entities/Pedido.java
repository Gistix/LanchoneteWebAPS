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
public class Pedido {
    @Id
    private int numero;
    private String usuario;
    private int pao;
    private int carne;    
    private int salada;
    private int molho;
 
    public Pedido () {};      
    
    public Pedido (int numero, String usuario, int pao, int salada, int carne, int molho) {
        this.numero = numero;
        this.usuario = usuario;
        this.pao = pao;
        this.carne = carne;
        this.salada = salada;
        this.molho = molho;     
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPao() {
        return pao;
    }

    public void setPao(int pao) {
        this.pao = pao;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public int getSalada() {
        return salada;
    }

    public void setSalada(int salada) {
        this.salada = salada;
    }

    public int getMolho() {
        return molho;
    }

    public void setMolho(int molho) {
        this.molho = molho;
    }
}
