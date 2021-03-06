/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package window;

import data.db_connection;
import java.sql.ResultSet;

/**
 *
 * @author Bhadresh
 */
public class pur_payment extends javax.swing.JFrame {

    /**
     * Creates new form add_purchase
     */
    pur_payment ap;
    public db_connection dc = new db_connection();
    
    public pur_payment() {
        initComponents();
        check_no.setEditable(false);
        bank_name.setEditable(false);
        dc.makeconnection();
        fillcombo();
    }
    
    
    public void fillcombo()
    {
        try{
           dc.stmt = dc.conn.createStatement();
           String sql;

           sql = "SELECT * FROM purchase";
           ResultSet rs = dc.stmt.executeQuery(sql);

           while(rs.next())
           {
               int pid = rs.getInt("p_id");
               s_no.addItem(pid);
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        check_no = new javax.swing.JTextField();
        bank_name = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        p_date = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        p_type = new javax.swing.JComboBox();
        s_no = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Payment Type");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 114, 80, -1));

        check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_noActionPerformed(evt);
            }
        });
        jPanel1.add(check_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 120, -1));
        jPanel1.add(bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 120, -1));
        jPanel1.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 120, -1));

        p_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_dateActionPerformed(evt);
            }
        });
        jPanel1.add(p_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, -1));

        add.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        add.setText("Add Payment Detail");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 250, 30));

        jLabel5.setText("Payment Date");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 74, 80, -1));

        jLabel1.setText("Serial No.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 34, 80, -1));

        jLabel2.setText("Amount");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 234, 80, -1));

        jLabel3.setText("Bank Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 194, 80, -1));

        jLabel4.setText("Check No.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 154, 80, -1));

        p_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Check", "Cash", "DD" }));
        p_type.setSelectedIndex(1);
        p_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_typeActionPerformed(evt);
            }
        });
        jPanel1.add(p_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 120, 22));

        jPanel1.add(s_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 120, 22));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        db_connection c = new db_connection(this);
        c.insert_ptransaction_query();
        setVisible(false);
    }//GEN-LAST:event_addActionPerformed

    private void p_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_dateActionPerformed

    private void check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_noActionPerformed
        
        
    }//GEN-LAST:event_check_noActionPerformed

    private void p_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_typeActionPerformed
        
        if(p_type.getSelectedItem().toString() == "Check")
        {
            check_no.setEditable(true);
            bank_name.setEditable(true);
        }
        if(p_type.getSelectedItem().toString() == "Cash")
        {
            check_no.setEditable(false);
            bank_name.setEditable(false);
        }
    }//GEN-LAST:event_p_typeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pur_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pur_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pur_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pur_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pur_payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    public javax.swing.JTextField amount;
    public javax.swing.JTextField bank_name;
    public javax.swing.JTextField check_no;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField p_date;
    public javax.swing.JComboBox p_type;
    public javax.swing.JComboBox s_no;
    // End of variables declaration//GEN-END:variables
}
