/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.Date;


public class login_main extends javax.swing.JFrame{   
        /**
     * Creates new form login_main
     */    
    public login_main() {
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        start_xampp();
        app_delete();
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
    }
    
    void start_xampp(){
        try {
            Process process = Runtime.getRuntime().exec("D:\\xampp\\xampp_start.exe");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "XAMPP START FAILED");
        }
    }
    
    class search_filter implements FilenameFilter { 
    
    String initials; 
    
    public search_filter(String initials) 
    { 
        this.initials = initials; 
    } 
    public boolean accept(File dir, String name) 
    { 
        return name.startsWith(initials); 
    } 
}
    
    void app_delete(){
        Date base_date = null;
        Date file_date = null;
        String filename, app_date;
        
        try {
            base_date = new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString());
        } catch (ParseException ex) {
            Logger.getLogger(login_main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File directory = new File(".\\Appointments"); 
  
        search_filter filter = new search_filter("Appointment"); 
 
        String[] flist = directory.list(filter);
        
        int i = 0;
        
        while(i < flist.length){
            filename = flist[i];
            
            app_date = filename.substring((filename.lastIndexOf("t") + 1), filename.lastIndexOf("."));
            try {
                file_date = new SimpleDateFormat("yyyy-MM-dd").parse(app_date);
            } catch (ParseException ex) {
                Logger.getLogger(login_main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            LocalDateTime ldt = LocalDateTime.ofInstant(base_date.toInstant(), ZoneId.systemDefault());
            ldt = ldt.minusDays(1);
            base_date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
            
            long diff = file_date.getTime() - base_date.getTime();

            TimeUnit time = TimeUnit.DAYS; 
            long difference = time.convert(diff, TimeUnit.MILLISECONDS);
            
            if (difference < 0){
                File app_file = new File(directory, flist[i]);
                app_file.delete();
            }
            
            i++;
        }
    }

    
    void login(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            
            String id_input = textfield_id.getText();
            char[] pass_input_char = passwordfield_pass.getPassword();
            String pass_input = String.valueOf(pass_input_char);
        
            PreparedStatement stm = con.prepareStatement("Select login_info.employee_id, pass from login_info, employee_information where login_info.employee_id = ? and pass = ? and login_info.employee_id = employee_information.employee_id AND designation = 'Owner'");
        
            stm.setString(1, id_input);
            stm.setString(2, pass_input);
            ResultSet rs = stm.executeQuery();
            
            if(textfield_id.getText().length()==0)  // Checking for empty field
            JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
            
            else if(passwordfield_pass.getPassword().length==0)  // Checking for empty field
            JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
            
            else {
                if (rs.next()) {
                    
                    dispose();
                    con.close();
                    
                    set_id ob = new set_id("100");
                    
                    homepage obj_home = new homepage(ob);
                    obj_home.show();
                    
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Username or Password Wrong\nTRY AGAIN");
                    con.close();
                }
            }
        
        
        }
        catch (SQLException sqlExp) {
            JOptionPane.showMessageDialog(null,"DATABASE CONNECTION FAILED");
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        label_id = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        textfield_id = new javax.swing.JTextField();
        passwordfield_pass = new javax.swing.JPasswordField();
        button_login = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        button_emp_login = new javax.swing.JButton();
        label_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(909, 626));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));

        label_id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_id.setForeground(new java.awt.Color(0, 0, 102));
        label_id.setText("ID:");

        label_password.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_password.setForeground(new java.awt.Color(0, 0, 102));
        label_password.setText("PASSWORD:");

        textfield_id.setBackground(new java.awt.Color(255, 255, 255));
        textfield_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_id.setForeground(new java.awt.Color(0, 0, 0));

        passwordfield_pass.setBackground(new java.awt.Color(255, 255, 255));
        passwordfield_pass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        passwordfield_pass.setForeground(new java.awt.Color(0, 0, 0));

        button_login.setBackground(new java.awt.Color(0, 0, 102));
        button_login.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_login.setText("LOG IN");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(button_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(92, 92, 92))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_password)
                        .addComponent(label_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passwordfield_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(textfield_id, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                    .addGap(22, 22, 22)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(419, Short.MAX_VALUE)
                .addComponent(button_login)
                .addGap(97, 97, 97))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textfield_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(label_password))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(passwordfield_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(216, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(153, 0, 255));

        button_emp_login.setBackground(new java.awt.Color(0, 0, 102));
        button_emp_login.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_emp_login.setText("LOG IN AS \nAN EMPLOYEE");
        button_emp_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_emp_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(button_emp_login, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addGap(32, 32, 32)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(211, Short.MAX_VALUE)
                    .addComponent(button_emp_login, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(184, Short.MAX_VALUE)))
        );

        label_title.setFont(new java.awt.Font("Cinzel Black", 1, 16)); // NOI18N
        label_title.setForeground(new java.awt.Color(0, 0, 0));
        label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_title.setText("MUJNABIN OPTIC'S");
        label_title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_title.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(186, 186, 186))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_emp_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_emp_loginActionPerformed
        // TODO add your handling code here:
        dispose();

        login_employee obj_logemp = new login_employee();
        obj_logemp.setVisible(true);
    }//GEN-LAST:event_button_emp_loginActionPerformed

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed
        // TODO add your handling code here:
        login(); 
    }//GEN-LAST:event_button_loginActionPerformed

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
            java.util.logging.Logger.getLogger(login_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_emp_login;
    private javax.swing.JButton button_login;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_title;
    private javax.swing.JPasswordField passwordfield_pass;
    private javax.swing.JTextField textfield_id;
    // End of variables declaration//GEN-END:variables
}
