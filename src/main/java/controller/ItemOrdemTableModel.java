package controller;


import model.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 1547816
 */
public class ItemOrdemTableModel extends AbstractTableModel {

    private List<Servico> lista = new ArrayList();
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Servico item = lista.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> item.getNome();
            case 1 -> item.getHorario();
            case 2 -> item.getValor();
            default -> "";
        };
         
    }
    
    @Override
    public String getColumnName(int columnIndex ) {
        return switch (columnIndex) {
            case 0 -> "Nome";
            case 1 -> "Duração";
            case 2 -> "Valor";
            default -> "";
        };        
    }
    
    public void adicionar(Servico item) {
        lista.add(item);
        fireTableRowsInserted( lista.size() - 1 , lista.size() - 1);
    }
    
    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1 , lista.size() - 1);
    }
    
    public void removeAll() {
        lista.clear();
        fireTableRowsDeleted(lista.size() - 1 , lista.size() - 1);
    }
        
    public void setList(List<Servico> novaLista) {
        lista = novaLista;
        fireTableRowsInserted( 0 , lista.size() - 1);
    }
    
    public List<Servico> getList() {
        return lista;
    }
}
