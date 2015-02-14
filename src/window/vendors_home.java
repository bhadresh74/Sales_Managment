/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package window;

import data.db_connection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigInteger;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bhadresh
 */
public class vendors_home extends javax.swing.JFrame {

    vendors_home p;
    public db_connection dc = new db_connection();
    
    
    public vendors_home() {
        initComponents();
        dc.makeconnection();
        doMyAction();
    }

    public void doMyAction()
    {
       DefaultTableModel model = (DefaultTableModel)vendor.getModel();
       
       try{
       dc.stmt = dc.conn.createStatement();
       String sql;

       sql = "SELECT * FROM vendor";
       ResultSet rs = dc.stmt.executeQuery(sql);

       while(rs.next())
       {
           int vid = rs.getInt("v_id");
           String party_name = rs.getString("party_name");
           String material_name = rs.getString("address");
           String no = rs.getString("mobile_no");
           String email = rs.getString("email");
           
           model.addRow(new Object[]{vid,party_name,material_name,no,email});
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
        jScrollPane1 = new javax.swing.JScrollPane();
        vendor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        refresh = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        edit = new javax.swing.JButton();
        new_v = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Purchase");
        setMinimumSize(new java.awt.Dimension(1000, 655));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(760, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vendor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No.", "Party Name", "Address", "Mobile", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vendor.setEnabled(false);
        jScrollPane1.setViewportView(vendor);
        if (vendor.getColumnModel().getColumnCount() > 0) {
            vendor.getColumnModel().getColumn(0).setPreferredWidth(20);
            vendor.getColumnModel().getColumn(1).setPreferredWidth(15);
            vendor.getColumnModel().getColumn(2).setPreferredWidth(300);
            vendor.getColumnModel().getColumn(3).setPreferredWidth(70);
            vendor.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 630));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 830, 630));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refresh.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel2.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 110, 30));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel5.setText("Select Options");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 6, 90, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 29, 190, 11));

        edit.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel2.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 110, 30));

        new_v.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        new_v.setText("Vendor");
        new_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_vActionPerformed(evt);
            }
        });
        jPanel2.add(new_v, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 110, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        
        do_refresh();
    }//GEN-LAST:event_refreshActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

       edit_vendor ev = new edit_vendor();
       ev.setAlwaysOnTop(true);
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
       this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
       ev.setVisible(true);
       ev.pack();
       ev.setLocationRelativeTo(null);
    }//GEN-LAST:event_editActionPerformed

    private void new_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_vActionPerformed

       add_vendor av = new add_vendor();
       av.setAlwaysOnTop(true);
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
       this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
       av.setVisible(true);
       av.pack();
       av.setLocationRelativeTo(null);
    }//GEN-LAST:event_new_vActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vendors_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vendors_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vendors_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vendors_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vendors_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton new_v;
    private javax.swing.JButton refresh;
    public javax.swing.JTable vendor;
    // End of variables declaration//GEN-END:variables

    private void do_refresh() {
    
       DefaultTableModel model = (DefaultTableModel)vendor.getModel();
   
       int rowCount = model.getRowCount();
       for (int i = rowCount - 1; i >= 0; i--)
       {
        model.removeRow(i);
       }
       
       try{
       dc.stmt = dc.conn.createStatement();
       String sql;

       sql = "SELECT * FROM vendor";
       ResultSet rs = dc.stmt.executeQuery(sql);

       while(rs.next())
       {
           int vid = rs.getInt("v_id");
           String party_name = rs.getString("party_name");
           String material_name = rs.getString("address");
           String no = rs.getString("mobile_no");
           String email = rs.getString("email");
           
           model.addRow(new Object[]{vid,party_name,material_name,no,email});
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }
}
