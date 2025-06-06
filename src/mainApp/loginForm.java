/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainApp;


import accounts.accountDetails;
import accounts.forgotPassword;
import accounts.passRecover;
import admin.*;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

import user.userDashBoard;



public class loginForm extends javax.swing.JFrame {

   
    public loginForm() {
        initComponents();
    }
    
    Color navColor = new Color(153,153,255);
    Color HoverColor = new Color(204,204,204);
    
     static String status;
     static String type;
      static String uid;
    
    public static boolean loginAcc(String username, String password){
        dbConnector dbc = new dbConnector();
        
        try{
            String query = "SELECT * FROM  tbl_users WHERE u_username =   '" + username + "'";
            ResultSet resultSet = dbc.getData(query);
            if(resultSet.next()){
                
                
                String hashedPass = resultSet.getString("u_password");
                String rehashedPass = passwordHasher.hashPassword(password);
                
                 if(hashedPass.equals(rehashedPass)){
                 uid = resultSet.getString("u_id");
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
                Session ses = Session.getInstance();
                    ses.setUid(resultSet.getInt("u_id"));
                    ses.setFname(resultSet.getString("u_fname"));
                    ses.setLname(resultSet.getString("u_lname"));
                    ses.setEmail(resultSet.getString("u_email"));
                    ses.setUsername(resultSet.getString("u_username"));
                    ses.setType(resultSet.getString("u_type"));
                    ses.setStatus(resultSet.getString("u_status"));
                return true;    
                 }else{
                 return false;
                 } 
            }else{ 
                return false;  
            }
        }catch (SQLException | NoSuchAlgorithmException ex){
            return false;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        showpass = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        minimize2 = new javax.swing.JLabel();
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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoback-Photoroom.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 390));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-Photoroom.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 200, 300));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gradient color.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 410));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 290, 410));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Password:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 100, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Username:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 100, 40));

        username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel3.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 280, 40));

        password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel3.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 280, 40));

        showpass.setBackground(new java.awt.Color(255, 255, 255));
        showpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showpass.setText("View password");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel3.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 130, 30));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel10.setText("Forgot password?");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 120, 30));

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("SIGN UP");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 90, 30));

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("LOGIN");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 100, 30));

        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 280, 20));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("New account? Click sign up to register.");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 260, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 510, 410));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Patient Diagnose System");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN FORM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 590, 70));

        minimize2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        minimize2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize2.setText("—");
        minimize2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimize2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize2MouseExited(evt);
            }
        });
        jPanel1.add(minimize2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 40, 40));

        close.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("X");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 40));

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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
    }//GEN-LAST:event_formWindowActivated

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        if(showpass.isSelected()){
            
            password.setEchoChar((char)0);
            
        }  else {
            password.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.dispose();
        forgotPassword fp = new forgotPassword();
        fp.setVisible(true);
        
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        registrationForm rf = new registrationForm();
        rf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
                dbConnector dbc = new dbConnector();

               if(loginAcc(username.getText(), password.getText())){
                if(!status.equals("Active")){
                        JOptionPane.showMessageDialog(null,"Inactive account, please contact the admin!");
                }else{
                    switch (type) {
                        case "Admin":
                            {
                                JOptionPane.showMessageDialog(null," Login Success!");
                                AdminDashBoard adb = new AdminDashBoard();
                                adb.setVisible(true);
                                this.dispose();
                                String action = "User ID: "+uid+" logged in";
                                dbc.insertData("INSERT INTO tbl_logs (user_id, Action, date) VALUES ('" + uid + "', '" + action + "', '" + LocalDateTime.now() + "')");
                                break;
                            }
                        case "User":
                            {
                                JOptionPane.showMessageDialog(null," Login Success!");
                                userDashBoard udb = new userDashBoard();
                                udb.setVisible(true);
                                this.dispose();
                                String action = "User ID: "+uid+" logged in";
                                dbc.insertData("INSERT INTO tbl_logs (user_id, Action, date) VALUES ('" + uid + "', '" + action + "', '" + LocalDateTime.now() + "')");
                                break;
                            }
                        default:
                            JOptionPane.showMessageDialog(null,"No account type found, please contact the admin!");
                            break;
                    }
                }
        }else{
        JOptionPane.showMessageDialog(null," Invalid Account!");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void minimize2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize2MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimize2MouseClicked

    private void minimize2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize2MouseEntered

    }//GEN-LAST:event_minimize2MouseEntered

    private void minimize2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_minimize2MouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Do you want to Exit?");
        if (a == JOptionPane. YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_closeMouseClicked

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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel error;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel minimize2;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox showpass;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
