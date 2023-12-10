package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 1547816
 */

@Entity
public class ItemOrdem implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idItemOrdem;
    
    @ManyToOne
    @JoinColumn ( name="idServico" )
    private Servico servico;
    
    @ManyToOne
    @JoinColumn ( name="idFuncionario" )
    private Funcionario funcionario;

    public ItemOrdem() {
    }

    public ItemOrdem(Servico servico, Funcionario funcionario) {
        this.servico = servico;
        this.funcionario = funcionario;
    }

    public ItemOrdem(int idItemOrdem, Servico servico, Funcionario funcionario) {
        this.idItemOrdem = idItemOrdem;
        this.servico = servico;
        this.funcionario = funcionario;
    }

    public int getIdItemOrdem() {
        return idItemOrdem;
    }

    public Servico getServico() {
        return servico;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setIdItemOrdem(int idItemOrdem) {
        this.idItemOrdem = idItemOrdem;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
