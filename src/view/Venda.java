/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import model.Investidor;

/**
 *
 * @author Manuella
 */
public class Venda extends javax.swing.JFrame {
    private Investidor investidor;
    /**
     * Creates new form Venda
     */
    public Venda(Investidor investidor) {
        initComponents();
        this.investidor = investidor;
    }

    public JButton getBtBitcon() {
        return btBitcon;
    }

    public void setBtBitcon(JButton btBitcon) {
        this.btBitcon = btBitcon;
    }

    public JButton getBtEthereum() {
        return btEthereum;
    }

    public void setBtEthereum(JButton btEthereum) {
        this.btEthereum = btEthereum;
    }

    public JButton getBtRipple() {
        return btRipple;
    }

    public void setBtRipple(JButton btRipple) {
        this.btRipple = btRipple;
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
        btBitcon = new javax.swing.JButton();
        btEthereum = new javax.swing.JButton();
        btRipple = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Qual moeda você deseja vender?");

        btBitcon.setText("Bitcoin");
        btBitcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBitconActionPerformed(evt);
            }
        });

        btEthereum.setText("Ethereum");
        btEthereum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEthereumActionPerformed(evt);
            }
        });

        btRipple.setText("Ripple");
        btRipple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRippleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEthereum)
                            .addComponent(btBitcon)
                            .addComponent(btRipple))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btBitcon)
                .addGap(18, 18, 18)
                .addComponent(btEthereum)
                .addGap(18, 18, 18)
                .addComponent(btRipple)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBitconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBitconActionPerformed
        VendaBit vendaBit = new VendaBit(investidor);
        vendaBit.setVisible(true);
    }//GEN-LAST:event_btBitconActionPerformed

    private void btRippleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRippleActionPerformed
        VendaRi vendaRi = new VendaRi(investidor);
        vendaRi.setVisible(true);
    }//GEN-LAST:event_btRippleActionPerformed

    private void btEthereumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEthereumActionPerformed
        VendaEt vendaEt = new VendaEt(investidor);
        vendaEt.setVisible(true);
    }//GEN-LAST:event_btEthereumActionPerformed

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
//            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Venda().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBitcon;
    private javax.swing.JButton btEthereum;
    private javax.swing.JButton btRipple;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
