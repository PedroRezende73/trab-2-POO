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
import javax.persistence.Id;
import javax.persistence.OneToMany;



/**
 *
 * @author 1547816
 */


@Entity
public class Veiculo implements Serializable {
    
    @Id
    @Column ( nullable = false, length = 7, updatable = false )
    private String placa;
    
    @Column ( nullable = false )
    private String nomeCondutor;
    
    @Column ( nullable = false, length = 20, updatable = false)
    private String cpfCondutor;
    
    @Column ( length = 100 )
    private String marca;
    
    @Column ( length = 100 )
    private String modelo;
    
    @Column ( length = 50 )
    private String cor;
    
    @OneToMany ( mappedBy = "veiculo")
    List<OrdemServico> ordens = new ArrayList();

    public Veiculo() {
    }
    
    public Veiculo(String placa, String nomeCondutor, String cpfCondutor, String marca, String modelo, String cor) {
        this.placa = placa;
        this.nomeCondutor = nomeCondutor;
        this.cpfCondutor = cpfCondutor;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public String getCpfCondutor() {
        return cpfCondutor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setNomeCondutor(String nomeCondutor) {
        this.nomeCondutor = nomeCondutor;
    }

    public void setCpfCondutor(String cpfCondutor) {
        this.cpfCondutor = cpfCondutor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
