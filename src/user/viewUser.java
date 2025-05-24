/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import user.userForm;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import mainApp.loginForm;
import net.proteanit.sql.DbUtils;


public class viewUser extends javax.swing.JFrame {

    
    public viewUser() {
        initComponents();
        displayData();
    }
    
    Color navColor = new Color(153,153,255);
    Color HoverColor = new Color(204,204,204);
    
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT u_id, u_fname, u_lname, u_email, u_status, u_type FROM tbl_users");
            userTable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());

        }

    }
    

    public static String usrid;

public boolean idcheck() {
    dbConnector dbc = new dbConnector();
    String userId = userID.getText(); 
    boolean found = false;

    try {

        ResultSet rs1 = dbc.getData("SELECT * FROM tbl_diagnose WHERE u_id = '" + userId + "'");
        if (rs1.next()) found = true;
        rs1.close();

        ResultSet rs2 = dbc.getData("SELECT * FROM tbl_doctor_specialist WHERE user_id = '" + userId + "'");
        if (rs2.next()) found = true;
        rs2.close();

        ResultSet rs4 = dbc.getData("SELECT * FROM tbl_logs WHERE user_id = '" + userId + "'");
        if (rs4.next()) found = true;
        rs4.close();

        ResultSet rs5 = dbc.getData("SELECT * FROM tbl_patients WHERE user_id = '" + userId + "'");
        if (rs5.next()) found = true;
        rs5.close();

        ResultSet rs7 = dbc.getData("SELECT * FROM tbl_recover WHERE u_id = '" + userId + "'");
        if (rs7.next()) found = true;
        rs7.close();

        if (found) {
            usrid = userId;
            JOptionPane.showMessageDialog(null, 
                "Sorry, this user already has a connection\nfrom another table and cannot be deleted!");
            return true; // Block deletion
        } else {
            return false; // Safe to delete
        }

    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex.getMessage());
        return false;
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        viewdetails = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        uname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        userID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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

        viewdetails.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        viewdetails.setText("VIEW DETAILS");
        viewdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewdetailsMouseClicked(evt);
            }
        });
        jPanel2.add(viewdetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 50));

        delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 410));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        uname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 260, 50));

        fname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 260, 50));

        lname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel3.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 260, 50));

        mail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 260, 50));

        userID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        userID.setText("ID");
        jPanel3.add(userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 40, 30));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(userTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 360, 390));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("User ID:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 650, 410));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Patient Diagnose System");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 460, 70));

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
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 40));

        close.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("X");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       userForm uf = new userForm();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
       
   
        Session ses = Session.getInstance();
        dbConnector dbc = new dbConnector();
        
        int cuser = ses.getUid();
        if(userID.getText().isEmpty()||lname.getText().isEmpty()||fname.getText().isEmpty()||mail.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Please select a user!");
        return;
        }if(idcheck()){
         if(userID.getText().equals(cuser)){
             JOptionPane.showMessageDialog(null, "failed to delete user");
         }
        }else{
        dbc.deleteData("DELETE FROM tbl_users WHERE u_id = '"+userID.getText()+"'");
        displayData();
        userForm uf = new userForm();
        uf.setVisible(true);
        this.dispose();
        String action = "Deleted Users with ID No: " + userID.getText();
         dbc.insertData("INSERT INTO tbl_logs (user_id, Action, date) VALUES ('" + ses.getUid() + "', '" + action + "', '" + LocalDateTime.now() + "')");
        }

    }//GEN-LAST:event_deleteMouseClicked

    private void viewdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewdetailsMouseClicked
       Session ses = Session.getInstance();
        int rowIndex = userTable.getSelectedRow();

        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select a User!");
        }else {
            try {
                dbConnector dbc = new dbConnector();
                TableModel tbl = userTable.getModel();
                ResultSet rs = dbc.getData("SELECT * FROM tbl_users WHERE u_id = '" + tbl.getValueAt(rowIndex, 0) + "'");

                if (rs.next()) {
                    userID.setText(""+rs.getInt("u_id"));
                    fname.setText(""+rs.getString("u_fname"));
                    lname.setText(""+rs.getString("u_lname")); 
                    mail.setText(""+rs.getString("u_email"));
                    uname.setText(""+rs.getString("u_username"));
                    
                     
                }

            } catch (SQLException ex) {
                System.out.println("" + ex);
            }
        }
    }//GEN-LAST:event_viewdetailsMouseClicked

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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
            Session ses = Session.getInstance(); 
            if(ses.getUid() == 0){
            JOptionPane.showMessageDialog(null, "No account, login first!");
            loginForm lf = new loginForm();
            lf.setVisible(true); 
            this.dispose(); 
    }//GEN-LAST:event_formWindowActivated
    }
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
            java.util.logging.Logger.getLogger(viewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    public javax.swing.JButton delete;
    public javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField lname;
    public javax.swing.JTextField mail;
    private javax.swing.JLabel minimize;
    public javax.swing.JTextField uname;
    public javax.swing.JLabel userID;
    private javax.swing.JTable userTable;
    public javax.swing.JButton viewdetails;
    // End of variables declaration//GEN-END:variables
}
