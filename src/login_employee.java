/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
import java.sql.*;
import javax.swing.*;

public class login_employee extends javax.swing.JFrame{    
    /**
     * Creates new form login_employee
     */
    int confirm = 0;
    String id;
    String setID;
    
    public login_employee() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        settingID();
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
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
        label_title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label_id_login = new javax.swing.JLabel();
        textfield_id_login = new javax.swing.JTextField();
        label_pass_login = new javax.swing.JLabel();
        passwordfield_pass_login = new javax.swing.JPasswordField();
        button_login = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        textfield_address_signup = new javax.swing.JTextField();
        label_phone_signup = new javax.swing.JLabel();
        textfield_phone_signup = new javax.swing.JTextField();
        label_name_signup = new javax.swing.JLabel();
        textfield_name_signup = new javax.swing.JTextField();
        passwordfield_pass_signup = new javax.swing.JPasswordField();
        passwordfield_passcon_signup = new javax.swing.JPasswordField();
        button_signup = new javax.swing.JButton();
        label_passcon_signup = new javax.swing.JLabel();
        label_pass_signup = new javax.swing.JLabel();
        label_desig_signup = new javax.swing.JLabel();
        textfield_desig_signup = new javax.swing.JTextField();
        label_address_signup = new javax.swing.JLabel();
        label_new_acc = new javax.swing.JLabel();
        button_login1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        label_title.setFont(new java.awt.Font("Cinzel Black", 1, 16)); // NOI18N
        label_title.setForeground(new java.awt.Color(0, 0, 0));
        label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_title.setText("MUJNABIN OPTIC'S");
        label_title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_title.setAlignmentY(0.0F);

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        label_id_login.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        label_id_login.setForeground(new java.awt.Color(0, 0, 102));
        label_id_login.setText("ID:");

        textfield_id_login.setBackground(new java.awt.Color(255, 255, 255));
        textfield_id_login.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_id_login.setForeground(new java.awt.Color(0, 0, 0));

        label_pass_login.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        label_pass_login.setForeground(new java.awt.Color(0, 0, 102));
        label_pass_login.setText("PASSWORD:");

        passwordfield_pass_login.setBackground(new java.awt.Color(255, 255, 255));
        passwordfield_pass_login.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        passwordfield_pass_login.setForeground(new java.awt.Color(0, 0, 0));

        button_login.setBackground(new java.awt.Color(0, 0, 102));
        button_login.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_login.setText("LOG IN");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_pass_login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordfield_pass_login, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_id_login, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(textfield_id_login)))
                .addGap(54, 54, 54)
                .addComponent(button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_login)
                .addGap(32, 32, 32))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_id_login, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfield_id_login, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_pass_login)
                    .addComponent(passwordfield_pass_login, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 0, 255));

        textfield_address_signup.setBackground(new java.awt.Color(255, 255, 255));
        textfield_address_signup.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_address_signup.setForeground(new java.awt.Color(0, 0, 0));

        label_phone_signup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_phone_signup.setForeground(new java.awt.Color(0, 0, 102));
        label_phone_signup.setText("PHONE NUMBER:");

        textfield_phone_signup.setBackground(new java.awt.Color(255, 255, 255));
        textfield_phone_signup.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_phone_signup.setForeground(new java.awt.Color(0, 0, 0));

        label_name_signup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_name_signup.setForeground(new java.awt.Color(0, 0, 102));
        label_name_signup.setText("NAME:");

        textfield_name_signup.setBackground(new java.awt.Color(255, 255, 255));
        textfield_name_signup.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_name_signup.setForeground(new java.awt.Color(0, 0, 0));

        passwordfield_pass_signup.setBackground(new java.awt.Color(255, 255, 255));
        passwordfield_pass_signup.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        passwordfield_pass_signup.setForeground(new java.awt.Color(0, 0, 0));

        passwordfield_passcon_signup.setBackground(new java.awt.Color(255, 255, 255));
        passwordfield_passcon_signup.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        passwordfield_passcon_signup.setForeground(new java.awt.Color(0, 0, 0));

        button_signup.setBackground(new java.awt.Color(0, 0, 102));
        button_signup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_signup.setText("SIGN UP");
        button_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_signupActionPerformed(evt);
            }
        });

        label_passcon_signup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_passcon_signup.setForeground(new java.awt.Color(0, 0, 102));
        label_passcon_signup.setText("CONFIRM PASSWORD:");

        label_pass_signup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_pass_signup.setForeground(new java.awt.Color(0, 0, 102));
        label_pass_signup.setText("PASSWORD:");

        label_desig_signup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_desig_signup.setForeground(new java.awt.Color(0, 0, 102));
        label_desig_signup.setText("DESIGNATION:");

        textfield_desig_signup.setBackground(new java.awt.Color(255, 255, 255));
        textfield_desig_signup.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_desig_signup.setForeground(new java.awt.Color(0, 0, 0));

        label_address_signup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_address_signup.setForeground(new java.awt.Color(0, 0, 102));
        label_address_signup.setText("ADDRESS:");

        label_new_acc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_new_acc.setForeground(new java.awt.Color(0, 0, 0));
        label_new_acc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_new_acc.setText("CREATE NEW ACCOUNT");
        label_new_acc.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_new_acc.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(782, Short.MAX_VALUE)
                        .addComponent(button_signup))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_name_signup, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_phone_signup, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_address_signup, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(label_desig_signup)
                                .addGap(58, 58, 58)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfield_address_signup, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                                    .addComponent(textfield_desig_signup, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_pass_signup)
                                    .addComponent(label_passcon_signup))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordfield_pass_signup, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                                    .addComponent(passwordfield_passcon_signup)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textfield_name_signup, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                                    .addComponent(textfield_phone_signup, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))))
                        .addGap(182, 182, 182)))
                .addGap(15, 15, 15))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(label_new_acc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(label_new_acc)
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_name_signup)
                    .addComponent(textfield_name_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_phone_signup)
                    .addComponent(textfield_phone_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_address_signup)
                    .addComponent(textfield_address_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_desig_signup)
                    .addComponent(textfield_desig_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_pass_signup)
                    .addComponent(passwordfield_pass_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_passcon_signup)
                    .addComponent(passwordfield_passcon_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(button_signup)
                .addContainerGap())
        );

        button_login1.setBackground(new java.awt.Color(255, 255, 255));
        button_login1.setFont(new java.awt.Font("Times New Roman", 2, 10)); // NOI18N
        button_login1.setForeground(new java.awt.Color(0, 0, 0));
        button_login1.setText("LOG IN AS OWNER");
        button_login1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_login1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(165, 165, 165)
                        .addComponent(button_login1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button_login1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            PreparedStatement stm;
            ResultSet rs;
            
            String id_input = textfield_id_login.getText();
            char[] pass_input_char = passwordfield_pass_login.getPassword();
            String pass_input = String.valueOf(pass_input_char);
        
            stm = con.prepareStatement("Select login_info.employee_id, pass from login_info, employee_information where login_info.employee_id = ? and pass = ? and login_info.employee_id = employee_information.employee_id AND designation != 'Owner'");
        
            stm.setString(1, id_input);
            stm.setString(2, pass_input);
            rs = stm.executeQuery();
            
            if(textfield_id_login.getText().length()==0)  // Checking for empty field
            JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
            
            else if(passwordfield_pass_login.getPassword().length==0)  // Checking for empty field
            JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
            
            else {
                if (rs.next()) {
                    dispose();
                    con.close();
                    
                    set_id ob = new set_id(textfield_id_login.getText());
                    
                    homepage obj_home = new homepage(ob);
                    obj_home.setVisible(true);
                    
                    } 
                else {
                    JOptionPane.showMessageDialog(null, "Username or Password Wrong\nTRY AGAIN");
                }
            }
            
            }
        catch (SQLException sqlExp) {
            JOptionPane.showMessageDialog(null,"DATABASE CONNECTION FAILED");
        }
    }//GEN-LAST:event_button_loginActionPerformed

    private void button_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_signupActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = null;
                                    
            if (textfield_name_signup.getText().length()==0 || textfield_desig_signup.getText().length()==0 || passwordfield_pass_signup.getPassword().length==0 || passwordfield_passcon_signup.getPassword().length==0 || textfield_phone_signup.getText().length()==0 || textfield_address_signup.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
            }
            
            else if (emp_check() == true){
                JOptionPane.showMessageDialog(null,"EMPLOYEE ALREADY EXISTS");
            }
            
            else {
                if (passwordfield_pass_signup.getText().compareTo(passwordfield_passcon_signup.getText()) == 0) {
                
                new access_permission(null, true, setID, 1, this).show();
                    
            if (confirm == 1)
            {
                String acc_emp = "INSERT INTO `employee_information`(`employee_id`, `employee_name`, `employee_phone_num`, `employee_address`, `designation`) VALUES ('" + setID + "', '" + textfield_name_signup.getText() + "', '" + textfield_phone_signup.getText() + "', '" + textfield_address_signup.getText() + "', '" + textfield_desig_signup.getText() + "')";
                String pass_str = String.valueOf(passwordfield_pass_signup.getText());
                String acc_login = "INSERT INTO `login_info`(`employee_id`, `pass`) VALUES ('" + setID + "', '" + pass_str + "')";
            
                stm = con.createStatement();
            
                stm.executeUpdate(acc_emp);
                stm.executeUpdate(acc_login);
            
                JOptionPane.showMessageDialog(null,"SIGN UP SUCCESSFUL");
            
                con.close();
                
                login_employee main = new login_employee();
                main.setVisible(true);
                this.dispose();
            }
            
            else{
                JOptionPane.showMessageDialog(null,"SIGN UP UNSUCCESSFUL");
                con.close();
            }
                
        }
        else
            JOptionPane.showMessageDialog(null,"Passwords Do Not Match\nTry Again");
        }
            }
            
        catch(SQLException sqlExp) {
            JOptionPane.showMessageDialog(null,"DATABASE CONNECTION FAILED");
        }
        catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null,"SIGNUP FAILED");
        } 
        
    }//GEN-LAST:event_button_signupActionPerformed

    private void button_login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_login1ActionPerformed
        // TODO add your handling code here:
        dispose();
        
        login_main obj = new login_main();
        obj.show();
    }//GEN-LAST:event_button_login1ActionPerformed

    void settingID()
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = (Statement) con.createStatement();
            ResultSet rs;
                 
            rs = stm.executeQuery("SELECT MAX(`employee_id`) FROM `employee_information`");
            rs.next();
            
            String set_id_str;
            set_id_str = rs.getString(1);
                
            int new_id = Integer.parseInt(set_id_str) + 1;
            setID = String.valueOf(new_id);
            
        }
        catch(SQLException sqlExp) {
            JOptionPane.showMessageDialog(null,"DATABASE CONNECTION FAILED");
        }
    }
    
    boolean emp_check()
    {
        int x = 0;
        try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
                PreparedStatement stm;
                ResultSet rs;

                String name_given = textfield_name_signup.getText();
                String phone_given = textfield_phone_signup.getText();

                stm = con.prepareStatement("Select employee_name, employee_phone_num from employee_information where employee_name = ? and employee_phone_num = ?");

                stm.setString(1, name_given);
                stm.setString(2, phone_given);
                rs = stm.executeQuery();

                if (rs.next()) {
                    con.close();    
                    x = 1;                    
                }
                
                else {
                    x = 0;
                }
            
            }
        catch (SQLException sqlExp) {
            JOptionPane.showMessageDialog(null,"DATABASE CONNECTION FAILED");
        }
        
        if (x == 1) {
            return true;                    
        } 
        else {
            return false;
        }
    }
           
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_login;
    private javax.swing.JButton button_login1;
    private javax.swing.JButton button_signup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_address_signup;
    private javax.swing.JLabel label_desig_signup;
    private javax.swing.JLabel label_id_login;
    private javax.swing.JLabel label_name_signup;
    private javax.swing.JLabel label_new_acc;
    private javax.swing.JLabel label_pass_login;
    private javax.swing.JLabel label_pass_signup;
    private javax.swing.JLabel label_passcon_signup;
    private javax.swing.JLabel label_phone_signup;
    private javax.swing.JLabel label_title;
    private javax.swing.JPasswordField passwordfield_pass_login;
    private javax.swing.JPasswordField passwordfield_pass_signup;
    private javax.swing.JPasswordField passwordfield_passcon_signup;
    private javax.swing.JTextField textfield_address_signup;
    private javax.swing.JTextField textfield_desig_signup;
    private javax.swing.JTextField textfield_id_login;
    private javax.swing.JTextField textfield_name_signup;
    private javax.swing.JTextField textfield_phone_signup;
    // End of variables declaration//GEN-END:variables
}
