import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import java.io.FileOutputStream; 
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.text.SimpleDateFormat;  
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date; 
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class appoint_menu extends javax.swing.JFrame {

    /**
     * Creates new form appoint_menu
     */
    JSpinner.DateEditor de;
    String id;
    
    set_id ob;
    int permission_emp;
    int permission_appoint;
    
    public appoint_menu(set_id obj) {
        initComponents();
        de = new JSpinner.DateEditor(spinner_time, "hh:mm");
        spinner_time.setEditor(de);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ob = obj;
        permission_emp = ob.employee_perm;
        permission_appoint = ob.appointment_perm;
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
    }
    
    public void client_select(String s){
        id = s;
        textfield_id.setText(id);
    }
    
    String name, filename;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    Date date = new Date();
        
    void client(){
        id = textfield_id.getText();
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs;
            
            String query = "SELECT client_id, client_name from client_info WHERE client_id = '" + id + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                id = rs.getString("client_id");
                name = rs.getString("client_name");
            }
            
            con.close();
            
        }
        catch (SQLException sqlExp) {
            JOptionPane.showMessageDialog(null, sqlExp);
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
    
    int file_search(String fname)
    {
        filename = fname;
        
        File directory = new File(".\\Appointments"); 
  
        search_filter filter = new search_filter(filename); 
 
        String[] flist = directory.list(filter); 

        if (flist == null) {   
            return 0;     
        } 
        else { 
            if (flist.length == 0){   
                return 0;
            }
            else
                return 1;
        }
    }
    
    void create_file(int x, String fname)
    {
        try{  
            filename = fname;
            String dir = ".\\Appointments\\" + filename;

            XSSFWorkbook xwb = new XSSFWorkbook();
            FileOutputStream fo = new FileOutputStream(new File(dir));
            XSSFSheet xss = xwb.createSheet("Appointments");
            xwb.write(fo);
            fo.close();

            FileInputStream fi = new FileInputStream(dir);
            Workbook wb = WorkbookFactory.create(fi);
            Sheet ss = wb.getSheet("Appointments");

            Row new_row = ss.createRow(0);

            Cell new_cell = new_row.createCell(0);
            new_cell.setCellValue("CLIENT ID");
            new_cell = new_row.createCell(1);
            new_cell.setCellValue("NAME");
            new_cell = new_row.createCell(2);
            new_cell.setCellValue("APPOINTMENT TIME");

            fo = new FileOutputStream(new File(dir));

            wb.write(fo);
            fo.flush();
            fo.close();
                
        }
        catch (Exception e)
        {
            System.out.println(e);
        } 
    }
    
    void new_app()
    {
        String fname = "Appointment" + formatter.format(date_new.getDate()) + ".xlsx";
        String dir = ".\\Appointments\\" + fname;
        
        if (file_search(fname) == 0)
            create_file(2, fname);
        
        client();
        
        try{
            String time = de.getFormat().format(spinner_time.getValue()) + combobox_time.getSelectedItem().toString();

            FileInputStream fi = new FileInputStream(dir);
            Workbook wb = WorkbookFactory.create(fi);
            Sheet ss = wb.getSheet("Appointments");

            int row_num = ss.getLastRowNum();
            int new_row_num = row_num + 1;
            Row new_row = ss.createRow(new_row_num);

            Cell new_cell = new_row.createCell(0);
            new_cell.setCellValue(id);
            new_cell = new_row.createCell(1);
            new_cell.setCellValue(name);
            new_cell = new_row.createCell(2);
            new_cell.setCellValue(time);

            FileOutputStream fo = new FileOutputStream(new File(dir));

            wb.write(fo);
            fo.flush();
            fo.close();

            JOptionPane.showMessageDialog(null, "APPOINTMENT SET");

            appoint_menu main = new appoint_menu(ob);
            main.show();
            this.dispose();

            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
                Statement stm = null;

                String app_in = "INSERT INTO appointment (`client_id`, `appointment_date`, `complete`) VALUES ('" + id + "', '" + de.getFormat().format(spinner_time.getValue()) + "', 'NO')";

                stm = con.createStatement();

                stm.executeUpdate(app_in);

                con.close();
            }
            catch(SQLException e){

            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException | EncryptedDocumentException ex) {
            JOptionPane.showMessageDialog(null, ex);
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
        button_logout = new javax.swing.JButton();
        label_title = new javax.swing.JLabel();
        button_goback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label_appointment = new javax.swing.JLabel();
        button_new_appoint = new javax.swing.JButton();
        button_today = new javax.swing.JButton();
        label_id = new javax.swing.JLabel();
        textfield_id = new javax.swing.JTextField();
        button_search = new javax.swing.JButton();
        label_time = new javax.swing.JLabel();
        label_date_new = new javax.swing.JLabel();
        date_new = new com.toedter.calendar.JDateChooser();
        spinner_time = new javax.swing.JSpinner();
        combobox_time = new javax.swing.JComboBox<>();
        label_date_all = new javax.swing.JLabel();
        date_all = new com.toedter.calendar.JDateChooser();
        button_charge = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        button_logout.setBackground(new java.awt.Color(51, 0, 153));
        button_logout.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        button_logout.setText("LOG OUT");
        button_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logoutActionPerformed(evt);
            }
        });

        label_title.setFont(new java.awt.Font("Cinzel Black", 1, 16)); // NOI18N
        label_title.setForeground(new java.awt.Color(0, 0, 0));
        label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_title.setText("MUJNABIN OPTIC'S");
        label_title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_title.setAlignmentY(0.0F);

        button_goback.setBackground(new java.awt.Color(0, 204, 204));
        button_goback.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
        button_goback.setText("GO BACK");
        button_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gobackActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        label_appointment.setFont(new java.awt.Font("Engravers MT", 3, 14)); // NOI18N
        label_appointment.setForeground(new java.awt.Color(51, 0, 153));
        label_appointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_appointment.setText("APPOINTMENTS");
        label_appointment.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_appointment.setAlignmentY(0.0F);

        button_new_appoint.setBackground(new java.awt.Color(0, 0, 102));
        button_new_appoint.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_new_appoint.setText("NEW APPOINTMENT");
        button_new_appoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_new_appointActionPerformed(evt);
            }
        });

        button_today.setBackground(new java.awt.Color(51, 0, 102));
        button_today.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_today.setText("SHOW APPOINTMENTS");
        button_today.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_todayActionPerformed(evt);
            }
        });

        label_id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_id.setForeground(new java.awt.Color(0, 0, 0));
        label_id.setText("ENTER CLIENT ID:");

        textfield_id.setBackground(new java.awt.Color(255, 255, 255));
        textfield_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_id.setForeground(new java.awt.Color(0, 0, 0));
        textfield_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_idActionPerformed(evt);
            }
        });

        button_search.setBackground(new java.awt.Color(0, 0, 153));
        button_search.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_search.setText("SEARCH");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });

        label_time.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_time.setForeground(new java.awt.Color(0, 0, 0));
        label_time.setText("APPOINTMENT TIME:");

        label_date_new.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_date_new.setForeground(new java.awt.Color(0, 0, 0));
        label_date_new.setText("APPOINTMENT DATE:");

        date_new.setDateFormatString("yyyy-MM-dd");
        date_new.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        spinner_time.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        spinner_time.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.AM_PM));

        combobox_time.setBackground(new java.awt.Color(255, 255, 255));
        combobox_time.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        combobox_time.setForeground(new java.awt.Color(0, 0, 0));
        combobox_time.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        label_date_all.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_date_all.setForeground(new java.awt.Color(0, 0, 0));
        label_date_all.setText("CHOOSE DATE:");

        date_all.setDateFormatString("yyyy-MM-dd");
        date_all.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        button_charge.setBackground(new java.awt.Color(51, 0, 102));
        button_charge.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_charge.setText("ADD APPOINTMENT CHARGE");
        button_charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_chargeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(label_appointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(110, 110, 110))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(button_new_appoint, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addGap(247, 247, 247))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(textfield_id, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_id)
                                    .addComponent(label_date_new)
                                    .addComponent(label_time))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date_new, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(spinner_time, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(combobox_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_search, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_date_all)
                        .addGap(33, 33, 33)
                        .addComponent(date_all, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_charge)
                            .addComponent(button_today, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_appointment)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_date_all)
                            .addComponent(date_all, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_today, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(button_charge, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_id)
                            .addComponent(textfield_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_search, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(label_date_new))
                    .addComponent(date_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_time)
                    .addComponent(spinner_time, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_time, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(button_new_appoint, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_goback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_logout))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(180, 180, 180)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_title)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_goback)
                    .addComponent(button_logout))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void button_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_logoutActionPerformed
        // TODO add your handling code here:
        dispose();

        login_main obj = new login_main();
        obj.show();
    }//GEN-LAST:event_button_logoutActionPerformed

    private void button_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gobackActionPerformed
        // TODO add your handling code here:
        dispose();

        homepage ob_home = new homepage(ob);
        ob_home.show();

    }//GEN-LAST:event_button_gobackActionPerformed

    private void button_new_appointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_new_appointActionPerformed
        // TODO add your handling code here:
        if (textfield_id.getText().length() == 0 || de.getFormat().format(spinner_time.getValue()).isBlank()  || combobox_time.getSelectedItem().toString().isBlank()){
            JOptionPane.showMessageDialog(null, "NO CLIENT/DATE/TIME ADDED");
        }
        
        else{
            Date date_today = null;
            Date date_app = null;            
            
            try {
                date_today = new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString());
            } catch (ParseException ex) {
                Logger.getLogger(appoint_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                date_app = new SimpleDateFormat("yyyy-MM-dd").parse(formatter.format(date_new.getDate()));
            } catch (ParseException ex) {
                Logger.getLogger(new_supply.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            long diff = date_app.getTime() - date_today.getTime();

            TimeUnit time = TimeUnit.DAYS; 
            long difference = time.convert(diff, TimeUnit.MILLISECONDS);            
            
            if(difference < 0){
                JOptionPane.showMessageDialog(null, "DATE HAS PASSED");
            }
            else
                new_app();

        }
        
    }//GEN-LAST:event_button_new_appointActionPerformed

    private void button_todayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_todayActionPerformed
        // TODO add your handling code here:
        Date base_date = null;
        Date date_app = null;            

        try {
            base_date = new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString());
        } catch (ParseException ex) {
            Logger.getLogger(appoint_menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            date_app = new SimpleDateFormat("yyyy-MM-dd").parse(formatter.format(date_all.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(new_supply.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LocalDateTime ldt = LocalDateTime.ofInstant(base_date.toInstant(), ZoneId.systemDefault());
        ldt = ldt.minusDays(1);
        base_date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        long diff = date_app.getTime() - base_date.getTime();

        TimeUnit time = TimeUnit.DAYS; 
        long difference = time.convert(diff, TimeUnit.MILLISECONDS); 
        
        if (difference < 0){
            JOptionPane.showMessageDialog(null, "CANNOT VIEW PAST APPOINTMENTS");
        }
        else{
            String fname = "Appointment" + formatter.format(date_all.getDate()) +".xlsx";
            if (file_search(fname) == 1)
            {
                dispose();

                viewer_appoint obj = new viewer_appoint(ob, filename, 1);
                obj.show();
            }
            else
            {
                create_file(1, fname);

                dispose();

                viewer_appoint obj = new viewer_appoint(ob, filename, 1);
                obj.show();
            }
        }
          
    }//GEN-LAST:event_button_todayActionPerformed

    private void textfield_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_idActionPerformed

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
        // TODO add your handling code here:
        dispose();
        
        viewer_client obj = new viewer_client(ob, 1, this);
        obj.show();
    }//GEN-LAST:event_button_searchActionPerformed

    private void button_chargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_chargeActionPerformed
        // TODO add your handling code here:
        Date base_date = null;
        Date date_app = null;            

        try {
            base_date = new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString());
        } catch (ParseException ex) {
            Logger.getLogger(appoint_menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            date_app = new SimpleDateFormat("yyyy-MM-dd").parse(formatter.format(date_all.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(new_supply.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LocalDateTime ldt = LocalDateTime.ofInstant(base_date.toInstant(), ZoneId.systemDefault());
        ldt = ldt.minusDays(1);
        base_date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        long diff = date_app.getTime() - base_date.getTime();

        TimeUnit time = TimeUnit.DAYS; 
        long difference = time.convert(diff, TimeUnit.MILLISECONDS); 
        
        if (difference < 0){
            JOptionPane.showMessageDialog(null, "CANNOT VIEW PAST APPOINTMENTS");
        }
        
        else{
            String fname = "Appointment" + formatter.format(date_all.getDate()) +".xlsx";
            if (file_search(fname) == 1)
            {
                dispose();

                viewer_appoint obj = new viewer_appoint(ob, filename, 2);
                obj.show();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "NO APPOINTMENTS ON SELECTED DATE");
            }
        }
    }//GEN-LAST:event_button_chargeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_charge;
    private javax.swing.JButton button_goback;
    private javax.swing.JButton button_logout;
    private javax.swing.JButton button_new_appoint;
    private javax.swing.JButton button_search;
    private javax.swing.JButton button_today;
    private javax.swing.JComboBox<String> combobox_time;
    private com.toedter.calendar.JDateChooser date_all;
    private com.toedter.calendar.JDateChooser date_new;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_appointment;
    private javax.swing.JLabel label_date_all;
    private javax.swing.JLabel label_date_new;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_time;
    private javax.swing.JLabel label_title;
    private javax.swing.JSpinner spinner_time;
    private javax.swing.JTextField textfield_id;
    // End of variables declaration//GEN-END:variables
}
