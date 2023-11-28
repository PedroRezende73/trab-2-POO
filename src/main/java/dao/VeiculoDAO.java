/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Veiculo;


/**
 *
 * @author 1547816
 */
public class VeiculoDAO extends GenericDAO {
 
    
    private List<Veiculo> pesquisar(String pesq, int tipo)  {        
        // TESTE
        return listar(Veiculo.class);
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
