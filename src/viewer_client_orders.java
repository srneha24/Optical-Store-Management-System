
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class viewer_client_orders extends javax.swing.JFrame {

    /**
     * Creates new form viewer_client_orders
     */
    String query, receipt, product, quantity, order_date, delivery_date, order_status;
    set_id ob;
    int permission_emp, permission_orders;
    int total_row;
    
    public viewer_client_orders(set_id obj,int x) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ob = obj;
        permission_emp = ob.employee_perm;
        permission_orders = ob.orders_perm;
        
        if (x == 1)
            viewall();
        if(x == 2)
            factory();
        if (x == 3)
            delivered();
        if (x == 4)
            store();
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
    }
    
    void viewall(){
        total_row = 0;
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs;
            
            query = "SELECT client_order_specs.receipt_no, product_id, quantity, order_date, delivery_date, order_status FROM client_order_specs, sales_records WHERE sales_records.receipt_no = client_order_specs.receipt_no ORDER BY order_date DESC";
            
            rs = stm.executeQuery(query);
            
            while (rs.next()) {
                receipt = rs.getString("receipt_no");
                product = rs.getString("product_id");
                quantity = rs.getString("quantity");
                order_date = rs.getString("order_date");
                delivery_date = rs.getString("delivery_date");
                order_status = rs.getString("order_status");
                
                if (delivery_date.equals("0000-00-00"))
                    delivery_date = "NO DELIVERY";
                
                String[] tbdata = {receipt, product, quantity, order_date, delivery_date, order_status};
                
                DefaultTableModel tblmod = (DefaultTableModel) table_orders.getModel();
                tblmod.addRow(tbdata);
                
                total_row++;
                
            }
            
            con.close();
        }
        catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp);
        }
    }
    
    void factory(){
        total_row = 0;
        
        table_orders.getColumnModel().getColumn(5).setMinWidth(0);
        table_orders.getColumnModel().getColumn(5).setMaxWidth(0);
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs;
            String query;
            
            query = "SELECT client_order_specs.receipt_no, product_id, quantity, order_date, delivery_date FROM client_order_specs, sales_records WHERE sales_records.receipt_no = client_order_specs.receipt_no AND order_status = 'Factory' ORDER BY order_date DESC";
            
            rs = stm.executeQuery(query);
            
            while (rs.next()) {
                receipt = rs.getString("receipt_no");
                product = rs.getString("product_id");
                quantity = rs.getString("quantity");
                order_date = rs.getString("order_date");
                delivery_date = rs.getString("delivery_date");
                
                if (delivery_date.equals("0000-00-00"))
                    delivery_date = "NO DELIVERY";
                
                String[] tbdata = {receipt, product, quantity, order_date, delivery_date};
                
                DefaultTableModel tblmod = (DefaultTableModel) table_orders.getModel();
                tblmod.addRow(tbdata);
                
                total_row++;
                
            }
            
            con.close();
        }
        catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp);
        }
    }
    
    void delivered(){
        total_row = 0;
        
        table_orders.getColumnModel().getColumn(5).setMinWidth(0);
        table_orders.getColumnModel().getColumn(5).setMaxWidth(0);
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs;
            String query;
            
            query = "SELECT client_order_specs.receipt_no, product_id, quantity, order_date, delivery_date FROM client_order_specs, sales_records WHERE sales_records.receipt_no = client_order_specs.receipt_no AND order_status = 'Delivered' ORDER BY order_date DESC";
            
            rs = stm.executeQuery(query);
            
            while (rs.next()) {
                receipt = rs.getString("receipt_no");
                product = rs.getString("product_id");
                quantity = rs.getString("quantity");
                order_date = rs.getString("order_date");
                delivery_date = rs.getString("delivery_date");
                
                if (delivery_date.equals("0000-00-00"))
                    delivery_date = "NO DELIVERY";
                
                String[] tbdata = {receipt, product, quantity, order_date, delivery_date};
                
                DefaultTableModel tblmod = (DefaultTableModel) table_orders.getModel();
                tblmod.addRow(tbdata);
                
                total_row++;
                
            }
            
            con.close();
        }
        catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp);
        }
    }
    
    void store(){
        total_row = 0;
        
        table_orders.getColumnModel().getColumn(5).setMinWidth(0);
        table_orders.getColumnModel().getColumn(5).setMaxWidth(0);
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs;
            String query;
            
            query = "SELECT client_order_specs.receipt_no, product_id, quantity, order_date, delivery_date FROM client_order_specs, sales_records WHERE sales_records.receipt_no = client_order_specs.receipt_no AND order_status = 'Store' ORDER BY order_date DESC";
            
            rs = stm.executeQuery(query);
            
            while (rs.next()) {
                receipt = rs.getString("receipt_no");
                product = rs.getString("product_id");
                quantity = rs.getString("quantity");
                order_date = rs.getString("order_date");
                delivery_date = rs.getString("delivery_date");
                
                if (delivery_date.equals("0000-00-00"))
                    delivery_date = "NO DELIVERY";
                
                String[] tbdata = {receipt, product, quantity, order_date, delivery_date};
                
                DefaultTableModel tblmod = (DefaultTableModel) table_orders.getModel();
                tblmod.addRow(tbdata);
                
                total_row++;
                
            }
            
            con.close();
        }
        catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp);
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
        label_supplier = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_orders = new javax.swing.JTable();
        button_ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(909, 626));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        label_supplier.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        label_supplier.setForeground(new java.awt.Color(0, 0, 0));
        label_supplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_supplier.setText("ORDERS");
        label_supplier.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_supplier.setAlignmentY(0.0F);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table_orders.setBackground(new java.awt.Color(102, 255, 255));
        table_orders.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_orders.setForeground(new java.awt.Color(0, 0, 0));
        table_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RECEIPT NO", "PRODUCT ID", "QUANTITY", "ORDER DATE", "DELIVERY DATE", "ORDER STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ordersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_orders);

        button_ok.setBackground(new java.awt.Color(0, 0, 102));
        button_ok.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_ok.setText("SAVE");
        button_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_okActionPerformed(evt);
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
                            .addComponent(label_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(285, 285, 285))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(626, 626, 626)
                .addComponent(button_ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(67, 67, 67))
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
                .addComponent(label_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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

    private void button_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gobackActionPerformed
        // TODO add your handling code here:
        if (permission_emp == 1 || permission_orders == 1){
            dispose();
        
            sales_client_orders obj = new sales_client_orders(ob);
            obj.show();
        }
        else{
            JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ACCESS");
        }
    }//GEN-LAST:event_button_gobackActionPerformed

    private void table_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ordersMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            int srow = table_orders.getSelectedRow();
            
            String receipt_search = table_orders.getValueAt(srow, 0).toString();
            
            if (permission_emp == 1)
            {
                dispose();

                viewer_sales obj = new viewer_sales(ob, 2, receipt_search, this);
                obj.show();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ACCESS");
            }
        }
    }//GEN-LAST:event_table_ordersMouseClicked

    private void button_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_okActionPerformed
        // TODO add your handling code here:
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            String query, dd;
            
            stm.execute("SET FOREIGN_KEY_CHECKS=0");

            for(int i = 0; i < total_row; i++){
                dd = table_orders.getValueAt(i, 4).toString();
                
                if (dd.equals("NO DELIVERY")){
                    dd = "NULL";
                }
                
                query = "UPDATE client_order_specs SET delivery_date = '" + dd + "', order_status = '" + table_orders.getValueAt(i, 5).toString() + "' WHERE receipt_no = '" + table_orders.getValueAt(i, 0).toString() + "' AND product_id = '" + table_orders.getValueAt(i, 1).toString() + "'";
                stm.executeUpdate(query);
            }
        
            JOptionPane.showMessageDialog(null, "CHANGES SAVED");
            
            stm.execute("SET FOREIGN_KEY_CHECKS=1");
            con.close();
            
        }

        catch (SQLException exp) {
            System.out.println(exp);
        }
        
        if (permission_emp == 1 || permission_orders == 1){
            dispose();
        
            sales_client_orders obj = new sales_client_orders(ob);
            obj.show();
        }
        else{
            JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ACCESS");
        }
    }//GEN-LAST:event_button_okActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_goback;
    private javax.swing.JButton button_ok;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_supplier;
    private javax.swing.JLabel label_title;
    private javax.swing.JTable table_orders;
    // End of variables declaration//GEN-END:variables
}
