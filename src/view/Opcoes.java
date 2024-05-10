/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.ControllerLogin;
import controller.ControllerCompraBit;
import controller.ControllerDeposito;
import controller.ControllerSaque;
import controller.ControllerSenha;
import controller.ControllerVenda;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import model.Investidor;

/**
 *
 * @author unifmperes
 */
public class Opcoes extends javax.swing.JFrame {
    /**
     * Creates new form Opcoes
     */
    private Investidor investidor;
    public Opcoes(Investidor investidor) {
        initComponents();
        this.investidor = investidor;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public ControllerSenha getController3() {
        return controller3;
    }

    public void setController3(ControllerSenha controller3) {
        this.controller3 = controller3;
    }
    
    public ControllerSaque getController2() {
        return controller2;
    }

    public void setController(ControllerSaque controller) {
        this.controller2 = controller2;
    }
    public ControllerDeposito getController() {
        return controller;
    }

    public void setController(ControllerDeposito controller) {
        this.controller = controller;
    }

    public JRadioButton getBtatualizar() {
        return btatualizar;
    }

    public void setBtatualizar(JRadioButton btatualizar) {
        this.btatualizar = btatualizar;
    }

    public JRadioButton getBtcomprar() {
        return btcomprar;
    }

    public void setBtcomprar(JRadioButton btcomprar) {
        this.btcomprar = btcomprar;
    }

    public JRadioButton getBtdepositar() {
        return btdepositar;
    }

    public void setBtdepositar(JRadioButton btdepositar) {
        this.btdepositar = btdepositar;
    }

    public JRadioButton getBtextrato() {
        return btextrato;
    }

    public void setBtextrato(JRadioButton btextrato) {
        this.btextrato = btextrato;
    }

    public JRadioButton getBtsacar() {
        return btsacar;
    }

    public void setBtsacar(JRadioButton btsacar) {
        this.btsacar = btsacar;
    }

    public JRadioButton getBtsair() {
        return btsair;
    }

    public void setBtsair(JRadioButton btsair) {
        this.btsair = btsair;
    }

    public JRadioButton getBtsaldo() {
        return btsaldo;
    }

    public void setBtsaldo(JRadioButton btsaldo) {
        this.btsaldo = btsaldo;
    }

    public JRadioButton getBtvender() {
        return btvender;
    }

    public void setBtvender(JRadioButton btvender) {
        this.btvender = btvender;
    }

    public JLabel getMenu() {
        return menu;
    }

    public void setMenu(JLabel menu) {
        this.menu = menu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btsaldo = new javax.swing.JRadioButton();
        btextrato = new javax.swing.JRadioButton();
        btdepositar = new javax.swing.JRadioButton();
        btsacar = new javax.swing.JRadioButton();
        btcomprar = new javax.swing.JRadioButton();
        btvender = new javax.swing.JRadioButton();
        btatualizar = new javax.swing.JRadioButton();
        btsair = new javax.swing.JRadioButton();
        menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btsaldo.setText("Consultar saldo");
        btsaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaldoActionPerformed(evt);
            }
        });

        btextrato.setText("Consultar extrato");
        btextrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btextratoActionPerformed(evt);
            }
        });

        btdepositar.setText("Depositar");
        btdepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdepositarActionPerformed(evt);
            }
        });

        btsacar.setText("Sacar");
        btsacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsacarActionPerformed(evt);
            }
        });

        btcomprar.setText("Comprar criptomoedas");
        btcomprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcomprarActionPerformed(evt);
            }
        });

        btvender.setText("Vender criptomoedas");
        btvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvenderActionPerformed(evt);
            }
        });

        btatualizar.setText("Atualizar cotação");

        btsair.setText("Sair");
        btsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsairActionPerformed(evt);
            }
        });

        menu.setText("MENU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btsair)
                    .addComponent(btatualizar)
                    .addComponent(btvender)
                    .addComponent(btcomprar)
                    .addComponent(btsacar)
                    .addComponent(btdepositar)
                    .addComponent(btextrato)
                    .addComponent(btsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(menu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(menu)
                .addGap(43, 43, 43)
                .addComponent(btsaldo)
                .addGap(18, 18, 18)
                .addComponent(btextrato)
                .addGap(18, 18, 18)
                .addComponent(btdepositar)
                .addGap(18, 18, 18)
                .addComponent(btsacar)
                .addGap(18, 18, 18)
                .addComponent(btcomprar)
                .addGap(18, 18, 18)
                .addComponent(btvender)
                .addGap(18, 18, 18)
                .addComponent(btatualizar)
                .addGap(18, 18, 18)
                .addComponent(btsair)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btsaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaldoActionPerformed
        ControllerSenha controllerSenha = new ControllerSenha();
        if(controllerSenha.verSenha(investidor)){
            MostrarMoedas mostrarMoedas = new MostrarMoedas(investidor);
            mostrarMoedas.setVisible(true);
        }
    }//GEN-LAST:event_btsaldoActionPerformed

    private void btvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvenderActionPerformed

        ControllerSenha controllerSenha = new ControllerSenha();
        if(controllerSenha.verSenha(investidor)){
            Venda venda = new Venda(investidor);
            venda.setVisible(true);
        }
    }//GEN-LAST:event_btvenderActionPerformed

    private void btdepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdepositarActionPerformed
        
        ControllerSenha controllerSenha = new ControllerSenha();
        if(controllerSenha.verSenha(investidor)){
            DepositoReal c = new DepositoReal(investidor);
            c.setVisible(true);
        }
    }//GEN-LAST:event_btdepositarActionPerformed

    private void btsacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsacarActionPerformed

        ControllerSenha controllerSenha = new ControllerSenha();
        if(controllerSenha.verSenha(investidor)){
            SaqueReal s = new SaqueReal(investidor);
            s.setVisible(true);
        }
    }//GEN-LAST:event_btsacarActionPerformed

    private void btcomprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcomprarActionPerformed

        ControllerSenha controllerSenha = new ControllerSenha();
        if(controllerSenha.verSenha(investidor)){
            Compra compra = new Compra(investidor);
            compra.setVisible(true);
        }
    }//GEN-LAST:event_btcomprarActionPerformed

    private void btsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsairActionPerformed
        JOptionPane.showMessageDialog(null, "Até mais");
    }//GEN-LAST:event_btsairActionPerformed

    private void btextratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btextratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btextratoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Opcoes().setVisible(true);
//            }
//        });
//    }
    private ControllerDeposito controller;
    private ControllerSaque controller2;
    private ControllerSenha controller3;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btatualizar;
    private javax.swing.JRadioButton btcomprar;
    private javax.swing.JRadioButton btdepositar;
    private javax.swing.JRadioButton btextrato;
    private javax.swing.JRadioButton btsacar;
    private javax.swing.JRadioButton btsair;
    private javax.swing.JRadioButton btsaldo;
    private javax.swing.JRadioButton btvender;
    private javax.swing.JLabel menu;
    // End of variables declaration//GEN-END:variables
}
