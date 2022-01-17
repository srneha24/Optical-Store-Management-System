
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class viewer_appoint extends javax.swing.JFrame {

    /**
     * Creates new form viewer_appoint
     */
    String filename;
    set_id ob;
    int permission_emp;
    int permission_appoint;
    int a;
    
    public viewer_appoint(set_id obj, String s, int x) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        a = x;
        
        ob = obj;
        permission_emp = ob.employee_perm;
        permission_appoint = ob.appointment_perm;
        
        filename = s;
        get_appoint();
        
        if (a == 1)
            button_save.setVisible(false);
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
    }
    
    void get_appoint()
    {
        try {
            String dir = ".\\Appointments\\" + filename;
            
            FileInputStream fi = new FileInputStream(dir);
            Workbook xwb = WorkbookFactory.create(fi);
            Sheet ss = xwb.getSheet("Appointments");
            int serial = 1;

            for(Row row : ss){
                if (row.getRowNum() != 0){
                    Cell get_id = row.getCell(0);
                    Cell get_name = row.getCell(1);
                    Cell get_time = row.getCell(2);
                    String app_date;
                    String charge = null;
                    
                    if(a == 2){
                        try {
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
                            Statement stm = con.createStatement();
                            ResultSet rs;
                            String query;
                            app_date = filename.substring((filename.lastIndexOf("t") + 1), filename.lastIndexOf("."));

                            query = "SELECT charge from appointment WHERE client_id = '" + get_id.toString() + "' AND appointment_date = '" + app_date + "'";

                            rs = stm.executeQuery(query);

                            while (rs.next()) {
                                charge = rs.getString("charge");
                            }

                            con.close();
                        }
                        catch (SQLException exp) {
                            JOptionPane.showMessageDialog(null, exp);
                        }
                    }

                    DefaultTableModel tblmod = (DefaultTableModel) table_appoint.getModel();
                    tblmod.addRow(new Object[] {serial, get_id, get_name, get_time, charge});
                    serial++;
                }
            }
        }
        
        catch (FileNotFoundException ex) {
        } catch (IOException | EncryptedDocumentException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        if (a == 1){
            table_appoint.getColumnModel().getColumn(4).setMinWidth(0);
            table_appoint.getColumnModel().getColumn(4).setMaxWidth(0);
        }
    }
    
    void charge_include(){
        int i = 0;
        String id, app_date, charge, confirm;
        app_date = filename.substring((filename.lastIndexOf("t") + 1), filename.lastIndexOf("."));

        try{
            id = table_appoint.getValueAt(i, 1).toString();
            charge = table_appoint.getValueAt(i, 4).toString();

            if (charge != null)
                confirm = "YES";
            else
                confirm = "NO";

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            stm.execute("SET FOREIGN_KEY_CHECKS=0");
            
            String query;

            while (i <= table_appoint.getRowCount()){
                 query = "UPDATE appointment SET charge = " + charge + ", complete = '" + confirm + "' WHERE client_id = '" + id + "' AND appointment_date = '" + app_date + "' ";
                stm.executeUpdate(query);
                
                i++;
            }

            stm.execute("SET FOREIGN_KEY_CHECKS=1");            
            con.close();

            }
            catch(SQLException e){
                System.out.println(e);
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
        label_title = new javax.swing.JLabel();
        button_goback = new javax.swing.JButton();
        label_appoint = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_appoint = new javax.swing.JTable();
        button_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(909, 626));

        label_title.setFont(new java.awt.Font("Cinzel Black", 1, 16)); // NOI18N
        label_title.setForeground(new java.awt.Color(0, 0, 0));
        label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_title.setText("MUJNABIN OPTIC'S");
        label_title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_title.setAlignmentY(0.0F);

        button_goback.setBackground(new java.awt.Color(0, 204, 204));
        button_goback.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        button_goback.setText("GO BACK");
        button_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gobackActionPerformed(evt);
            }
        });

        label_appoint.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        label_appoint.setForeground(new java.awt.Color(0, 0, 0));
        label_appoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_appoint.setText("APPOINTMENTS");
        label_appoint.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_appoint.setAlignmentY(0.0F);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table_appoint.setBackground(new java.awt.Color(102, 255, 255));
        table_appoint.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_appoint.setForeground(new java.awt.Color(0, 0, 0));
        table_appoint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SERIAL NO.", "CLIENT ID", "NAME", "APPOINTMENT TIME", "CHARGE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_appoint);

        button_save.setBackground(new java.awt.Color(0, 0, 153));
        button_save.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_save.setText("SAVE APPOINTMENT CHARGES");
        button_save.setToolTipText("");
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_goback)
                        .addGap(214, 214, 214)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_appoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(285, 285, 285))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addComponent(button_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(button_goback)))
                .addGap(45, 45, 45)
                .addComponent(label_appoint, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gobackActionPerformed
        // TODO add your handling code here:
        if (permission_emp == 1 || permission_appoint == 1)
        {
            dispose();

            appoint_menu obj = new appoint_menu(ob);
            obj.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ACCESS");
        }
    }//GEN-LAST:event_button_gobackActionPerformed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        // TODO add your handling code here:
        if (permission_emp == 1 || permission_appoint == 1)
        {
            charge_include();
            
            dispose();

            appoint_menu obj = new appoint_menu(ob);
            obj.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ACCESS");
        }
    }//GEN-LAST:event_button_saveActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_goback;
    private javax.swing.JButton button_save;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_appoint;
    private javax.swing.JLabel label_title;
    private javax.swing.JTable table_appoint;
    // End of variables declaration//GEN-END:variables
}
