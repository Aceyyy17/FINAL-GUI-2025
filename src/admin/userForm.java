/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author MARITIME 1
 */
public class userForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashBoard
     */
    public userForm() {
        initComponents();
    }
    
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT u_id, u_fname, u_lname, u_email, u_status, u_type FROM tbl_user");
            usersTable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());

        }

    }
    
    Color navColor = new Color(153,153,255);
    Color HoverColor = new Color(204,204,204);

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        deletebutton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        editbutton = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        addbutton = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        acc_id = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
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

        deletebutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        deletebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletebuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletebuttonMouseExited(evt);
            }
        });
        deletebutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DELETE");
        deletebutton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 0, 70, 30));

        jPanel2.add(deletebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 110, 30));

        editbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        editbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editbuttonMouseExited(evt);
            }
        });
        editbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("EDIT");
        editbutton.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 0, 70, 30));

        jPanel2.add(editbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 110, 30));

        addbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addbuttonMouseExited(evt);
            }
        });
        addbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ADD");
        addbutton.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 0, 70, 30));

        jPanel2.add(addbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-users-100.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 110, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 410));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(usersTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 520, 370));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 560, 410));

        acc_id.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        acc_id.setText("Current User ID:");
        jPanel1.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 50));

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 90, 70));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Patient Diagnose System");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, -1));

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
       AdminDashBoard adb = new AdminDashBoard();
       adb.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void addbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseClicked
        AddUserForm auf = new AddUserForm();
        auf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addbuttonMouseClicked

    private void addbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseEntered
        addbutton.setBackground(navColor);
    }//GEN-LAST:event_addbuttonMouseEntered

    private void addbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseExited
       addbutton.setBackground(HoverColor);
    }//GEN-LAST:event_addbuttonMouseExited

    private void editbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseEntered
        editbutton.setBackground(navColor);
    }//GEN-LAST:event_editbuttonMouseEntered

    private void editbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseExited
       editbutton.setBackground(HoverColor);
    }//GEN-LAST:event_editbuttonMouseExited

    private void deletebuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseEntered
       deletebutton.setBackground(navColor);
    }//GEN-LAST:event_deletebuttonMouseEntered

    private void deletebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseExited
        deletebutton.setBackground(HoverColor);
    }//GEN-LAST:event_deletebuttonMouseExited

    private void editbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseClicked
        int rowIndex = usersTable.getSelectedRow(); 
        
        if(rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please Select an Item!");
            
        }else{
            try{  
                
               dbConnector dbc = new dbConnector();
               TableModel tbl = usersTable.getModel();
               ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '"+tbl. getValueAt(rowIndex, 0)+"'");
               if(rs.next()){
                   
                AddUserForm auf = new AddUserForm(); 
                auf.uid.setText(""+rs.getString("u_id"));
                auf.fname.setText(""+rs.getString("u_fname"));
                auf.lname.setText(""+rs.getString("u_lname"));
                auf.mail.setText(""+rs.getString("u_email"));
                auf.uname.setText(""+rs.getString("u_username"));
                auf.pass.setText(""+rs.getString("u_password"));
                auf.type.setSelectedItem(""+rs.getString("u_type"));
                auf.ustat.setSelectedItem(""+rs.getString("u_status"));
                auf.image.setIcon(auf.ResizeImage(rs.getString("u_image"), null, auf.image));
                auf.oldpath = rs.getString("u_image");
                auf.path = rs.getString("u_image");
                auf.destination = rs.getString("u_image");
                auf.addUser.setEnabled(false);
                auf.updateUser.setEnabled(true);
                auf.setVisible(true);
                this.dispose();     
                if(rs.getString("u_image").isEmpty()){
                auf.select.setEnabled(true);
                auf.remove.setEnabled(false);
                
                }else{
                auf.select.setEnabled(false);
                auf.remove.setEnabled(true);

                }
                
               } 
             
            
        }catch(SQLException ex){
            
                System.out.println(""+ex);
        }
            }
    }//GEN-LAST:event_editbuttonMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session ses = Session.getInstance();
       acc_id.setText(""+ses.getUid());
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(userForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_id;
    private javax.swing.JPanel addbutton;
    private javax.swing.JPanel deletebutton;
    private javax.swing.JPanel editbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
