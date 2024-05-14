/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import model.Carteira;
import model.Investidor;

/**
 *
 * @author Manuella
 */
public class Compra extends javax.swing.JFrame {
    private Investidor investidor;
    /**
     * Creates new form Compra
     */
    public Compra(Investidor investidor) {
        initComponents();
        this.investidor = investidor;
    }

    public JButton getCompraBit() {
        return compraBit;
    }

    public void setCompraBit(JButton compraBit) {
        this.compraBit = compraBit;
    }

    public JButton getCompraEt() {
        return compraEt;
    }

    public void setCompraEt(JButton compraEt) {
        this.compraEt = compraEt;
    }

    public JButton getCompraR() {
        return compraR;
    }

    public void setCompraR(JButton compraR) {
        this.compraR = compraR;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        compraBit = new javax.swing.JButton();
        compraEt = new javax.swing.JButton();
        compraR = new javax.swing.JButton();
        mostraCot = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("O que você deseja comprar?");

        compraBit.setText("Bitcoins");
        compraBit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraBitActionPerformed(evt);
            }
        });

        compraEt.setText("Ethereum");
        compraEt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraEtActionPerformed(evt);
            }
        });

        compraR.setText("Ripple");
        compraR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraRActionPerformed(evt);
            }
        });

        mostraCot.setText("Mostrar Cotação");
        mostraCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraCotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(compraBit)
                            .addComponent(compraR)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mostraCot)
                        .addGap(30, 30, 30)
                        .addComponent(compraEt)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(compraBit)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compraEt)
                    .addComponent(mostraCot))
                .addGap(39, 39, 39)
                .addComponent(compraR)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compraBitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraBitActionPerformed
        CompraBit compraBit = new CompraBit(investidor);
        compraBit.setVisible(true);
    }//GEN-LAST:event_compraBitActionPerformed

    private void compraEtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraEtActionPerformed
        CompraEthereum compraEthereum = new CompraEthereum(investidor);
        compraEthereum.setVisible(true);
    }//GEN-LAST:event_compraEtActionPerformed

    private void compraRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraRActionPerformed
        CompraRipple compraRipple = new CompraRipple(investidor);
        compraRipple.setVisible(true);
    }//GEN-LAST:event_compraRActionPerformed

    private void mostraCotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraCotActionPerformed
        MostraCot mostraCot = new MostraCot(investidor);
        mostraCot.setVisible(true);
    }//GEN-LAST:event_mostraCotActionPerformed

    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Compra().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compraBit;
    private javax.swing.JButton compraEt;
    private javax.swing.JButton compraR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mostraCot;
    // End of variables declaration//GEN-END:variables
}
