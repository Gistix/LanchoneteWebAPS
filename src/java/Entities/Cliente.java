/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.*;
import org.eclipse.persistence.annotations.Array;

/**
 *
 * @author Giovanni
 */
class ClienteId implements Serializable {
    private String cpf;
    private String usuario;
}

@Entity @IdClass(ClienteId.class)
@Table(name="tb_clientes")
public class Cliente {
    private String nome;
    @Id
    private String cpf;
    @Id
    private String usuario;
    private String senha;
    private Endereco endereco;
    private Boolean adm;
    
    public Cliente () {};
    
    public Cliente (String nome, String cpf, String usuario, String senha, String rua, int numero, String cep, Boolean adm) {
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;      
        this.endereco = new Endereco (rua, numero, cep);
        this.adm = adm;
    }   
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the adm
     */
    public Boolean getAdm() {
        return adm;
    }

    /**
     * @param adm the adm to set
     */
    public void setAdm(Boolean adm) {
        this.adm = adm;
    }
}
