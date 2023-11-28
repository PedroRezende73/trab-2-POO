/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ConexaoHibernate;
import dao.GenericDAO;
import dao.VeiculoDAO;
import java.util.List;
import model.Veiculo;
import model.Funcionario;
import model.Servico;
import model.Status;
import org.hibernate.HibernateException;


/**
 *
 * @author 1547816
 */
public class GerenciadorDominio {
    
    private final GenericDAO genDAO;
    private final VeiculoDAO veiDAO;

    public GerenciadorDominio() {
        // TESTE
        ConexaoHibernate.getSessionFactory();
        genDAO = new GenericDAO();
        veiDAO = new VeiculoDAO();
    }
    
    public List listar(Class classe) throws HibernateException {        
        return genDAO.listar(classe);
    }
    
    public void excluir(Object obj) throws HibernateException {                               
        genDAO.excluir(obj);
    }
    
    public void inserirVeiculo(Veiculo vei) {
        genDAO.inserir(vei);
    }
    
    public int inserirFuncionario(Funcionario fun) {
        genDAO.inserir(fun);
        return fun.getIdFuncionario();
    }
    
    public int inserirServico(Servico ser) {
        genDAO.inserir(ser);
        return ser.getIdServico();
    }
    
    public int inserirStatus(Status sta) {
        genDAO.inserir(sta);
        return sta.getIdStatus();
    }
    
    public List<Veiculo> pesquisarVeiculo(String pesq, int tipo) throws HibernateException {
        List<Veiculo> lista = null;
        switch (tipo) {
            case 0: lista = veiDAO.pesquisarPlaca(pesq); break;
            case 1: lista = veiDAO.pesquisarCondutor(pesq); break;
            case 2: lista = veiDAO.pesquisarMarca(pesq); break;
            case 3: lista = veiDAO.pesquisarModelo(pesq); break;
        }
        return lista;        
    }
}
