/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnose;

import patient.*;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


public class printDiagnose extends javax.swing.JFrame {

    
    public printDiagnose() {
        initComponents();
         displayData();
        
    }
    
    Color navColor = new Color(153,153,255);
    Color HoverColor = new Color(204,204,204);
    
            public void displayData() {
             try {
                 dbConnector dbc = new dbConnector();
                 String query = "SELECT diagnose_id, patient_id, p_fname, p_lname, " +
                                "d_name, status, treatment, date " +
                                "FROM tbl_diagnose  " +
                                "JOIN tbl_patients  ON patient_id = p_id";
                 ResultSet rs = dbc.getData(query);
                 diagnoseTable.setModel(DbUtils.resultSetToTableModel(rs));
                 rs.close();
             } catch (SQLException ex) {
                 System.out.println("Errors: " + ex.getMessage());
             }
         }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        viewInfo = new javax.swing.JButton();
        printtt = new javax.swing.JButton();
        diagnoseID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        diagnoseTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        treat = new javax.swing.JTextField();
        pid = new javax.swing.JTextField();
        pfn = new javax.swing.JTextField();
        sympt = new javax.swing.JTextField();
        st = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dt = new javax.swing.JTextField();
        pln = new javax.swing.JTextField();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 93, 34));

        viewInfo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        viewInfo.setText("VIEW DETAILS");
        viewInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewInfoMouseClicked(evt);
            }
        });
        jPanel2.add(viewInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 50));

        printtt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        printtt.setText("PRINT");
        printtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printttMouseClicked(evt);
            }
        });
        jPanel2.add(printtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, 50));

        diagnoseID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        diagnoseID.setText("ID");
        jPanel2.add(diagnoseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 40, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Diagnose ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 410));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        diagnoseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(diagnoseTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 220));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Status");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 90, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Patient ID:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 140, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Patient First Name:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 140, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Patient Last Name:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 140, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Treatment:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Symptom:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 90, 30));

        treat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(treat, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 200, 30));

        pid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 180, 30));

        pfn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(pfn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 180, 30));

        sympt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(sympt, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 200, 30));

        st.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 200, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Date:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 90, 30));

        dt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtActionPerformed(evt);
            }
        });
        jPanel3.add(dt, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 200, 30));

        pln.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(pln, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 180, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 750, 410));

        minimize.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("—");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 40, 40));

        close.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("X");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 40, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PRINT DATA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 260, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        addPatientDiagnose apd = new addPatientDiagnose();
        apd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void printttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printttMouseClicked
            int rowIndex = diagnoseTable.getSelectedRow();
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select an item!");
    } else {
        try {
            dbConnector dbc = new dbConnector();
            TableModel tbl = diagnoseTable.getModel();
        int selectedDiagnoseId = Integer.parseInt(tbl.getValueAt(rowIndex, 0).toString());

        String query = "SELECT patient_id, p_fname, p_lname, d_name, status, treatment, date " +
                       "FROM tbl_diagnose  " +
                       "JOIN tbl_patients  ON patient_id = p_id " +
                       "WHERE diagnose_id = " + selectedDiagnoseId;

        ResultSet rs = dbc.getData(query);

        if (rs.next()) {
            DiagnosePrinting dp = new DiagnosePrinting();
            dp.pat_id.setText(rs.getString("patient_id"));
            dp.p_name.setText(rs.getString("p_fname") + " " + rs.getString("p_lname"));
            dp.sym.setText(rs.getString("d_name"));
            dp.stat.setText(rs.getString("status"));
            dp.date.setText(rs.getString("date"));
            dp.treat.setText(rs.getString("treatment"));

            dp.setVisible(true);
            this.dispose();
        }
    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex);
    }
}
    }//GEN-LAST:event_printttMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered

    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizeMouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Do you want to Exit?");
        if (a == JOptionPane. YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_closeMouseClicked

    private void dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtActionPerformed

    private void viewInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewInfoMouseClicked
        Session ses = Session.getInstance();
        diagnoseTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int rowIndex = diagnoseTable.getSelectedRow();
                if (rowIndex >= 0) {
                    try {

                        TableModel tbl = diagnoseTable.getModel();
                        String diagnoseIDValue = tbl.getValueAt(rowIndex, 0).toString();

                        dbConnector dbc = new dbConnector();

                        String query = "SELECT diagnose_id, p_id AS patient_id, p_fname, p_lname, " +
                        "d_name, status, date, treatment " +
                        "FROM tbl_diagnose  " +
                        "JOIN tbl_patients  ON patient_id = p_id " +
                        "WHERE diagnose_id = '" + diagnoseIDValue + "'";

                        ResultSet rs = dbc.getData(query);

                        if (rs.next()) {
                            diagnoseID.setText(rs.getString("diagnose_id"));
                            pid.setText(rs.getString("patient_id"));
                            pfn.setText(rs.getString("p_fname"));
                            pln.setText(rs.getString("p_lname"));
                            sympt.setText(rs.getString("d_name"));
                            st.setText(rs.getString("status"));
                            dt.setText(rs.getString("date"));
                            treat.setText(rs.getString("treatment"));
                        }

                    } catch (SQLException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
            }
        });
    }//GEN-LAST:event_viewInfoMouseClicked

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
            java.util.logging.Logger.getLogger(printDiagnose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(printDiagnose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(printDiagnose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(printDiagnose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new printDiagnose().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    public javax.swing.JLabel diagnoseID;
    private javax.swing.JTable diagnoseTable;
    private javax.swing.JTextField dt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField pfn;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField pln;
    public javax.swing.JButton printtt;
    private javax.swing.JTextField st;
    private javax.swing.JTextField sympt;
    private javax.swing.JTextField treat;
    private javax.swing.JButton viewInfo;
    // End of variables declaration//GEN-END:variables
}
