/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Type;

/**
 *
 * @author Usuario
 */

@Entity
public class Servico implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idServico;
    
    @Column ( nullable = false )
    private String nome;
    
    @Column
    @Type(type = "java.sql.Time")
    private java.sql.Time horario;
    
    @Column
    private float valor;
    
    public Servico() {
    }

    public Servico(String nome, Time horario, float valor) {
        this.nome = nome;
        this.horario = horario;
        this.valor = valor;
    }

    public Servico(int idServico, String nome, Time horario, float valor) {
        this.idServico = idServico;
        this.nome = nome;
        this.horario = horario;
        this.valor = valor;
    }

    public int getIdServico() {
        return idServico;
    }

    public String getNome() {
        return nome;
    }

    public Time getHorario() {
        return horario;
    }

    public float getValor() {
        return valor;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    
}
