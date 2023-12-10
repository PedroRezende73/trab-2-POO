/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Veiculo;
import org.hibernate.HibernateException;
import org.hibernate.Session;


/**
 *
 * @author 1547816
 */
public class VeiculoDAO extends GenericDAO {
 
    
    private List<Veiculo> pesquisar(String pesq, int tipo)  {        
        List<Veiculo> lista = new ArrayList();
        
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // CRITERIA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();            
            CriteriaQuery consulta = builder.createQuery(Veiculo.class);
            
            // TABELAS
            Root tabela = consulta.from(Veiculo.class);
            
            //RESTRIÇÕES
            Predicate restricoes = null;
            switch (tipo) {
                // where nomeCliente LIKE 'pesq%'
                case 1: restricoes = builder.like(tabela.get("placa"), pesq + "%"); break;
                case 2: restricoes = builder.like(tabela.get("nomeCondutor"), pesq + "%"); break;
                case 3: restricoes = builder.like(tabela.get("marca"), pesq + "%"); break;
                case 4: restricoes = builder.like(tabela.get("modelo"), pesq + "%"); break;
            }

            consulta.where(restricoes);
            
            lista = sessao.createQuery(consulta).getResultList();
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException erro ) {
            if ( sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);  
        }

        return lista;
        
    }
    
    
    public List<Veiculo> pesquisarPlaca(String pesq)  {        
        return pesquisar(pesq,1);
    }
    
    public List<Veiculo> pesquisarCondutor(String pesq)  {        
        return pesquisar(pesq,2);
    }
    
    public List<Veiculo> pesquisarMarca(String pesq)  {        
        return pesquisar(pesq,3);
    }
    
    public List<Veiculo> pesquisarModelo(String pesq)  {        
        return pesquisar(pesq,4);
    }
    
}
