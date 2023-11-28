/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Usuario
 */

@Entity
public class Funcionario implements Serializable{
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idFuncionario;
    
    @Column ( nullable = false )
    private String nome;
    
    @Column ( nullable = false, length = 20, updatable = false )
    private String cpf;
    
    @Column ( nullable = false, length = 20 )
    private String telefone;
    
    @Column ( length = 10 )
    private String cep;
    
    @Column
    private String logradouro;
        
    @Column ( length = 100 )
    private String bairro;
            
    @Column
    private String complemento;
    
    @OneToMany ( mappedBy = "funcionario")
    List<OrdemServico> ordens = new ArrayList();

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String telefone, String cep, String logradouro, String bairro, String complemento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public Funcionario(int idFuncionario, String nome, String cpf, String telefone, String cep, String logradouro, String bairro, String complemento) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }
    
    @Override
    public String toString(){
        return nome;
    }
}
