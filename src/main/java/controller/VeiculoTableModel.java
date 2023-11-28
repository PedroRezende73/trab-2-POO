package controller;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Veiculo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 1547816
 */
public class VeiculoTableModel extends AbstractTableModel {

    List<Veiculo> lista = new ArrayList();
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo vei = lista.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> vei.getPlaca();
            case 1 -> vei.getNomeCondutor();
            case 2 -> vei.getMarca();
            case 3 -> vei.getModelo();
            default -> "";
        };
    }
    
    
    @Override
    public String getColumnName(int columnIndex ) {
       String colunas[] = {"Placa", "Condutor", "Marca", "Modelo"};
       return colunas[columnIndex];
    }
    
    
    public void adicionar(Veiculo vei) {
        lista.add(vei);
        fireTableRowsInserted( lista.size() - 1 , lista.size() - 1);
    }
    
    public Veiculo getVeiculo(int row) {
        return lista.get(row);
    }
    
    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1 , lista.size() - 1);
    }
    
    public void setList(List<Veiculo> novaLista) {
        lista = novaLista;
        fireTableRowsInserted( 0 , lista.size() - 1);
    }
}
