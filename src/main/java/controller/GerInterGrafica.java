/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Veiculo;
import view.*;

/**
 *
 * @author Usuario
 */
public class GerInterGrafica {
    private final static GerInterGrafica unicaInstancia = new GerInterGrafica();
    private GerenciadorDominio gerDom;
    
    private GerInterGrafica() {
        gerDom = new GerenciadorDominio();
    }
     
    public static GerInterGrafica getInstance() {
        return unicaInstancia;
    }
    // FIM DO SINGLETON
    
    public GerenciadorDominio getGerDom() {
        return gerDom;
    }

    // ATRIBUTOS
    private FrmPrincipal frmPrinc = null;
    private DlgCadVeiculo janCadVeiculo = null;
    private DlgCadServico janCadServico = null;
    private DlgCadOS janCadOS = null;
    private DlgCadFuncionario janCadFuncionario = null;
    private DlgCadStatus janCadStatus = null;
    private DlgPesqVeiculo janPesqVei = null;

    private JDialog abrirJanela(JDialog objDlg, Class classe) {

        try {
            if (objDlg == null) {
                objDlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(frmPrinc, true);
            }
            objDlg.setVisible(true);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            objDlg = null;
            JOptionPane.showMessageDialog(frmPrinc, ex.getMessage());
        }
        
        return objDlg;
    }

    public void abrirJanPrincipal() {
        if (frmPrinc == null) {
            frmPrinc = new FrmPrincipal();
        }
        frmPrinc.setVisible(true);
    }

    public void abrirJanCadVeiculo() {
        abrirJanela(janCadVeiculo, DlgCadVeiculo.class);
    }

    public void abrirJanCadServico() {
        abrirJanela(janCadServico, DlgCadServico.class);
    }

    public void abrirJanCadOS() {
        abrirJanela(janCadOS, DlgCadOS.class);
    }

    public void abrirJanCadFuncionario() {
        abrirJanela(janCadFuncionario, DlgCadFuncionario.class);
    }
    
    public void abrirJanCadStatus() {
        abrirJanela(janCadStatus, DlgCadStatus.class);
    }
    
    public Veiculo abrirJanPesqVeiculo() {
        janPesqVei = (DlgPesqVeiculo) abrirJanela(janPesqVei, DlgPesqVeiculo.class);
        return janPesqVei.getVeiSelecionado();
    }

    public void sair() {
        frmPrinc.dispose();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            /*
            FlatDarkLaf dark = new FlatDarkLaf();
            javax.swing.UIManager.setLookAndFeel( dark );
             */
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // TRADUÇÃO
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim");
        javax.swing.UIManager.put("OptionPane.noButtonText", "Não");
        javax.swing.UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        GerInterGrafica gerIG = GerInterGrafica.getInstance();
        gerIG.abrirJanPrincipal();

    }

}
