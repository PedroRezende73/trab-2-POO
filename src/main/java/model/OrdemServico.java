/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @JoinColumn ( name = "idStatus", nullable = true)
    private Status status;
    
    @OneToMany (mappedBy = "idItemOrdem", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<ItemOrdem> itensOrdem;

    public OrdemServico() {
    }

    public OrdemServico(int idOrdem, boolean desconto, float valor, String obs, Veiculo veiculo) {
        this.idOrdem = idOrdem;
        this.desconto = desconto;
        this.obs = obs;
        this.veiculo = veiculo;
    }

    public OrdemServico(boolean desconto, float valor, String obs, Veiculo veiculo) {
        this.desconto = desconto;
        this.valor = valor;
        this.obs = obs;
        this.veiculo = veiculo;
    }
    
    public List<ItemOrdem> getItensOrdem() {
        return itensOrdem;
    }

    public void setItensOrdem(List<ItemOrdem> itensOrdem) {
        this.itensOrdem = itensOrdem;
    }

    public void setValorTotal(float total) {
        this.valor = total;
    }

    public int getIdOS() {
        return this.idOrdem;
    }
    
    
}
