/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mainApp.loginForm;


public class AddUserForm extends javax.swing.JFrame {

    
    public AddUserForm() {
        initComponents();
    }
    
    Color navColor = new Color(153,153,255);
    Color HoverColor = new Color(204,204,204);

        public static String umail,usname;
        public String destination = "";
        File selectedFile;
        public String oldpath;
        public String path;
    
    public int FileExistenceChecker(String path){
      File file = new File(path);
      String fileName = file.getName();
      
      Path filePath = Paths.get("src/userimages", fileName);
      boolean fileExist = Files.exists(filePath);
    
      if(fileExist){
      return 1;
      }else {
      return 0;
      }
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
    public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    
    public void chooseImage() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Choose Profile Image");
    int result = fileChooser.showOpenDialog(null); 
    if (result == JFileChooser.APPROVE_OPTION) {
        selectedFile = fileChooser.getSelectedFile();

     
        String folderPath = "src/userimages/";
        new File(folderPath).mkdirs();
        destination = folderPath + selectedFile.getName();

  

        JOptionPane.showMessageDialog(null, "Image selected: " + selectedFile.getName());
    } else {
        JOptionPane.showMessageDialog(null, "No image selected.");
    }
}
    
 
     public boolean duplicatecheck(){
        dbConnector dbc = new dbConnector();
   try {
            String query = "SELECT * FROM tbl_users WHERE u_username = '"+ uname.getText()+"'OR u_email ='"+mail.getText() +"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                umail= resultSet.getString("u_email");
                if(umail.equals(mail.getText())){
                JOptionPane.showMessageDialog(null,"email already existed!");
                mail.setText("");
                }
                 usname= resultSet.getString("u_username");
                if(usname.equals(uname.getText())){
                JOptionPane.showMessageDialog(null,"username already existed!");
                uname.setText("");
                }
                return true;
            }
            else{
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println(""+ex);
            return false;
        }
    }
   
    public boolean isValidEmail(String email) {
    
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    if (email == null || !email.matches(emailRegex)) {
        JOptionPane.showMessageDialog(null, 
            "(e.g., user@example.com).",
            "Invalid Email!",
            JOptionPane.ERROR_MESSAGE);
        return false;
    }

    return true;
}

    public boolean updateCheck(){
        dbConnector dbc = new dbConnector();
        
        if (!isValidEmail(mail.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid email format! Please enter a valid email.");
            mail.setText("");
            return true;
        }
        try{
            String query = "SELECT * FROM  tbl_users WHERE (u_username =   '" + uname.getText() + "'  OR u_email = '" + mail.getText() + "') AND u_id != '"+uid.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                
                 umail = resultSet.getString("u_email");
                 if(umail.equals(mail.getText())){
                 JOptionPane.showConfirmDialog(null, "Email is already used!");
                 mail.setText("");
                 }
                 usname = resultSet.getString("u_username");
                 if(usname.equals(uname.getText())){
                 JOptionPane.showConfirmDialog(null, "Username is already used!");
                 uname.setText("");
                 }
                 return true;
            }else{
                return false;
        }
            
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
             
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        addUser = new javax.swing.JButton();
        uid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        uname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        hide = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        type = new javax.swing.JComboBox<>();
        ustat = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        minimize1 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 100, 34));

        addUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addUser.setText("ADD");
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });
        jPanel2.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 100, 50));

        uid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        uid.setText("ID");
        jPanel2.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 30, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Account ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 440));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        uname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 260, 50));

        fname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 260, 50));

        lname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel3.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 260, 50));

        mail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 260, 50));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hidden.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hideMouseReleased(evt);
            }
        });
        jPanel3.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, 40));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                showMouseReleased(evt);
            }
        });
        jPanel3.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, 40));

        pass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel3.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 260, 50));

        type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        type.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Account Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel3.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 260, 50));

        ustat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ustat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending", " " }));
        ustat.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "User Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel3.add(ustat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 260, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 270, 270));

        select.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        select.setText("SELECT");
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
        });
        jPanel3.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 100, 30));

        remove.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remove.setText("REMOVE");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });
        jPanel3.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 100, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 650, 440));

        minimize1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        minimize1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize1.setText("—");
        minimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimize1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize1MouseExited(evt);
            }
        });
        jPanel1.add(minimize1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 40));

        close.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("X");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Patient Diagnose System");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 480, 70));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       userForm uf = new userForm();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        JFileChooser fileChooser = new JFileChooser();
                 int returnValue = fileChooser.showOpenDialog(null);
                 if(returnValue == JFileChooser.APPROVE_OPTION){
                     try{
                     selectedFile = fileChooser.getSelectedFile();
                     destination = "src/userimages/" + selectedFile.getName();
                     path = selectedFile.getAbsolutePath();
                     
                     if(FileExistenceChecker(path) == 1 ){
                         JOptionPane.showConfirmDialog(null, "File Already Exist, Rename or Choose another!");
                          destination = "";
                          path= "";
                     }else{
                           image.setIcon(ResizeImage(path, null, image));
                           select.setEnabled(false);
                           remove.setEnabled(true);
                          
                     }
                     }catch (Exception ex){
                         System.out.println("File Error!");
                     }
                 }
    }//GEN-LAST:event_selectMouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
      remove.setEnabled(false);
      select.setEnabled(true);
      image.setIcon(null);
      destination ="";
      path = "";
    }//GEN-LAST:event_removeMouseClicked

    private void showMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMousePressed
        
    }//GEN-LAST:event_showMousePressed

    private void showMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseReleased
        
    }//GEN-LAST:event_showMouseReleased

    private void hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMousePressed
        show.setVisible(true);
        hide.setVisible(false);
        pass.setEchoChar((char) 0);
        
        
    }//GEN-LAST:event_hideMousePressed

    private void hideMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseReleased
        show.setVisible(false);
        hide.setVisible(true);
        pass.setEchoChar('*');
    }//GEN-LAST:event_hideMouseReleased

    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked
                    dbConnector dbc = new dbConnector();

                   String emailInput = mail.getText();
                   if(fname.getText() .isEmpty() || lname.getText().isEmpty() ||uname.getText() .isEmpty() ||mail.getText() .isEmpty() ||pass.getText().isEmpty()
                   )

                       {
                           JOptionPane.showMessageDialog(null,"All field are required!");     
                       }
                       else if (!isValidEmail(emailInput)) {
                          } 

                       else if(duplicatecheck()){
                              System.out.println("duplicate exist!");

                       }
                        else if (!(pass.getText().length() >= 8)){ 
                       JOptionPane.showMessageDialog(null,"password should have 8 characters and above!");
                       }
                        else if (uname.getText().equals(mail.getText())){
                       JOptionPane.showMessageDialog(null, "username and email should not match!");
                       } else {

               
               if (selectedFile == null || destination.isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Please choose an image before submitting!");
                   return;
               }

               try {
                   String password = passwordHasher.hashPassword(pass.getText());

                   if (dbc.insertData("INSERT INTO tbl_users (u_fname, u_lname, u_email, u_username, u_password, u_type, u_status, u_image) "
                           + "VALUES ('" + fname.getText() + "', '" + lname.getText() + "', '" + mail.getText() + "', '" + uname.getText() + "', '" + password + "', '" + type.getSelectedItem() + "', 'Pending', '" + destination + "')")) {

                       try {
                           Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                           JOptionPane.showMessageDialog(null, "Inserted Successfully!");

                           loginForm lf = new loginForm();
                           lf.setVisible(true);
                           this.dispose();
                       } catch (IOException ex) {
                           System.out.println("Insert Image Error: " + ex);
                       }

                   } else {
                       JOptionPane.showMessageDialog(null, "Connection Failed!");
                   }
               } catch (NoSuchAlgorithmException ex) {
                   System.out.println("" + ex);
               }
           }
    }//GEN-LAST:event_addUserMouseClicked

    private void minimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize1MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimize1MouseClicked

    private void minimize1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize1MouseEntered

    }//GEN-LAST:event_minimize1MouseEntered

    private void minimize1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_minimize1MouseExited

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
            }
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
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addUser;
    private javax.swing.JLabel close;
    public javax.swing.JTextField fname;
    private javax.swing.JLabel hide;
    public javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JTextField lname;
    public javax.swing.JTextField mail;
    private javax.swing.JLabel minimize1;
    public javax.swing.JPasswordField pass;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    private javax.swing.JLabel show;
    public javax.swing.JComboBox<String> type;
    public javax.swing.JLabel uid;
    public javax.swing.JTextField uname;
    public javax.swing.JComboBox<String> ustat;
    // End of variables declaration//GEN-END:variables
}
