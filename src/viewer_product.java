
import java.awt.Color;
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
public class viewer_product extends javax.swing.JFrame {

    /**
     * Creates new form viewer_product
     */
    set_id ob;
    int permission_emp;
    new_order_sales new_sale;
    int sale_trig = 0;
    new_supply trig_new_sup;
    int new_sup;
    
    String id, brand, shape, design, material, quantity, cost_price, selling_price, query;
    
    public viewer_product(set_id obj, int x, String search) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        product_info(x, search);
        
        ob = obj;
        permission_emp = ob.employee_perm;
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
    }
    
   public viewer_product(set_id obj, int x, int y, String search, new_order_sales ns) {
        initComponents();
        
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        sale_trig = y;
        product_info(x, search);
        new_sale = ns;
        
        ob = obj;
        permission_emp = ob.employee_perm;
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
    }
   
   public viewer_product(set_id obj, int x, int y, String search, new_supply ns) {
        initComponents();
        
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        new_sup = y;
        product_info(x, search);
        trig_new_sup = ns;
        
        ob = obj;
        permission_emp = ob.employee_perm;
        
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
        button_goback = new javax.swing.JButton();
        label_products = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        label_products.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        label_products.setForeground(new java.awt.Color(0, 0, 0));
        label_products.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_products.setText("PRODUCTS");
        label_products.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_products.setAlignmentY(0.0F);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table_product.setBackground(new java.awt.Color(102, 255, 255));
        table_product.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_product.setForeground(new java.awt.Color(0, 0, 0));
        table_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT ID", "BRAND", "SHAPE", "DESIGN", "MATERIAL", "STOCK", "COST PRICE", "SELLING PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_product);

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
                            .addComponent(label_products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(285, 285, 285))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
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
                .addComponent(label_products, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
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

    private void button_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gobackActionPerformed
        // TODO add your handling code here:
        if (sale_trig == 1){
            new_sale.show();
            dispose();
        }
        
        else if(new_sup == 1){
            trig_new_sup.show();
            dispose();
        }
        
        else{
            if (permission_emp == 1)
            {
                dispose();

                cat_in_store obj = new cat_in_store(ob);
                obj.show();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ACCESS");
            }
        }
    }//GEN-LAST:event_button_gobackActionPerformed

    private void table_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            int srow = table_product.getSelectedRow();
            
            if (sale_trig == 1){
                new_sale.prod(table_product.getValueAt(srow, 0).toString());
                new_sale.show();
                dispose();
                
            }
            
            else if (new_sup == 1){
                trig_new_sup.sup(2,table_product.getValueAt(srow, 0).toString());
                trig_new_sup.show();
                dispose();
                
            }
            
            else{
                id = table_product.getValueAt(srow, 0).toString();
                brand = table_product.getValueAt(srow, 1).toString(); 
                shape = table_product.getValueAt(srow, 2).toString();
                design = table_product.getValueAt(srow, 3).toString();
                material = table_product.getValueAt(srow, 4).toString();
                quantity = table_product.getValueAt(srow, 5).toString();
                cost_price = table_product.getValueAt(srow, 6).toString();
                selling_price = table_product.getValueAt(srow, 7).toString();

                dispose();
                cat_in_store obj = new cat_in_store(ob, id, brand, shape, design, material, quantity, cost_price, selling_price);
                obj.show();
            }            
            
        }
    }//GEN-LAST:event_table_productMouseClicked

    
    void product_info(int x, String search)
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs;
            
            if (x == 2)
                query = "SELECT * from product_info WHERE brand = '" + search + "'";

            else if (x == 3)
                query = "SELECT * from product_info WHERE shape = '" + search + "'";

            else if (x == 4)
                query = "SELECT * from product_info WHERE design = '" + search + "'";

            else if (x == 5)
                query = "SELECT * from product_info WHERE material = '" + search + "'";
            
            else
                query = "SELECT * from product_info";
            
            rs = stm.executeQuery(query);
            
            while (rs.next()) {
                id = rs.getString("product_id");
                brand = rs.getString("brand");
                shape = rs.getString("shape");
                design = rs.getString("design");
                material = rs.getString("material");
                quantity = rs.getString("quantity");
                cost_price = rs.getString("unit_cost_price");
                selling_price = rs.getString("unit_selling_price");                

                String[] tbdata = {id, brand, shape, design, material, quantity, cost_price, selling_price};

                DefaultTableModel tblmod = (DefaultTableModel) table_product.getModel();
                tblmod.addRow(tbdata);
                
                }
            
            con.close();
        }
        catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp);
        }
    }
        
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_goback;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_products;
    private javax.swing.JLabel label_title;
    private javax.swing.JTable table_product;
    // End of variables declaration//GEN-END:variables
}
