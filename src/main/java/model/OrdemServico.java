/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Type;

/**
 *
 * @author Usuario
 */

@Entity
public class OrdemServico implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idOrdem;
    
    @Column
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean desconto;
    
    @Column
    private float valor;
    
    @Column
    @Lob
    private String obs;
    
    @ManyToOne
    @JoinColumn(  name = "placaVeiculo")
    private Veiculo veiculo;
    
    @ManyToOne
    @JoinColumn ( name = "idStatus")
    private Status status;
    
    @ManyToOne
    @JoinColumn ( name = "idFuncionario")
    private Funcionario funcionario;
    
    @ManyToMany
    @JoinTable ( name="Ordem_Servico", 
                 joinColumns = { @JoinColumn(name="idOrdem") } ,
                 inverseJoinColumns = { @JoinColumn(name="idServico") }
                )
    private List<Servico> listaServicos;

    public OrdemServico() {
    }

    public OrdemServico(boolean desconto, float valor, String obs, Veiculo veiculo, Status status, Funcionario funcionario) {
        this.desconto = desconto;
        this.valor = valor;
        this.obs = obs;
        this.veiculo = veiculo;
        this.status = status;
        this.funcionario = funcionario;
    }

    public OrdemServico(int idOrdem, boolean desconto, float valor, String obs, Veiculo veiculo, Status status, Funcionario funcionario) {
        this.idOrdem = idOrdem;
        this.desconto = desconto;
        this.valor = valor;
        this.obs = obs;
        this.veiculo = veiculo;
        this.status = status;
        this.funcionario = funcionario;
    }
    
    
}
