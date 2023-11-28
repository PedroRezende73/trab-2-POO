package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    private Servico servico;
    private Funcionario funcionario;
    
    public ItemOrdem() {
    }
   
    
    public ItemOrdem(Pedido ped, Lanche lan, String adicionais, int bife, int ovo, int queijo, int presunto, int qtde) {
        this.chaveComposta = new ItemPedidoPK(ped, lan);
        this.adicionais = adicionais;
        this.bife = bife;
        this.ovo = ovo;
        this.queijo = queijo;
        this.presunto = presunto;
        this.qtde = qtde;
    }

    public ItemOrdem(Lanche lan, String adicionais, int bife, int ovo, int queijo, int presunto, int qtde) {
        this.chaveComposta = new ItemPedidoPK(null, lan);
        this.adicionais = adicionais;
        this.bife = bife;
        this.ovo = ovo;
        this.queijo = queijo;
        this.presunto = presunto;
        this.qtde = qtde;
    }

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }

    public int getBife() {
        return bife;
    }

    public void setBife(int bife) {
        this.bife = bife;
    }

    public int getOvo() {
        return ovo;
    }

    public void setOvo(int ovo) {
        this.ovo = ovo;
    }

    public int getQueijo() {
        return queijo;
    }

    public void setQueijo(int queijo) {
        this.queijo = queijo;
    }

    public int getPresunto() {
        return presunto;
    }

    public void setPresunto(int presunto) {
        this.presunto = presunto;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

   

    public ItemPedidoPK getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(ItemPedidoPK chaveComposta) {
        this.chaveComposta = chaveComposta;
    }
    
    public void setPedido(Pedido ped) {
        this.getChaveComposta().setPedido(ped);
    }
    
    public void setLanche(Lanche lan) {
        this.getChaveComposta().setLanche(lan);
    }
    
    public Pedido getPedido() {
        return this.getChaveComposta().getPedido();
    }
    
    public Lanche getLanche() {
        return this.getChaveComposta().getLanche();
    }
    
    
    
    
}
