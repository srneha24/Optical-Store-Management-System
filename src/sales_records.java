
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.IOException;
import javax.swing.ImageIcon;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class sales_records extends javax.swing.JFrame {

    /**
     * Creates new form sales_records
     */
    set_id ob;
    int permission_emp;
    int permission_sales, permission_orders;
    String search; 
    ResultSet rs;
    String query;
    
    public sales_records(set_id obj) {
        initComponents();
        
        label_total_unit_sold_value.setVisible(false);
        label_total_unit_cost_value.setVisible(false);
        label_total_sold_value.setVisible(false);
        label_total_cost_value.setVisible(false);
        label_most_sold_value.setVisible(false);
        label_most_sold_cost_value.setVisible(false);
        
        ob = obj;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        permission_emp = ob.employee_perm;
        permission_sales = ob.sales_perm; 
        permission_orders = ob.orders_perm;
       
        
        addMouseListenerRecrusively(date_search);
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
    }
    
    void date_search(String search_choice){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            int max_count = 0;
            String most_prod = null;
            double most_cost;
            
            query = "SELECT SUM(quantity) FROM sales_records, client_order_specs WHERE sales_records.receipt_no = client_order_specs.receipt_no AND order_date = '" + search_choice + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                label_total_sold_value.setText(rs.getString(1));
                label_total_sold_value.setVisible(true);
            }
            
            query = "SELECT SUM(unit_selling_price * client_order_specs.quantity) FROM product_info, sales_records, client_order_specs WHERE product_info.product_id = client_order_specs.product_id AND client_order_specs.receipt_no = sales_records.receipt_no AND order_date = '" + search_choice + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                label_total_cost_value.setText(rs.getString(1));
                label_total_cost_value.setVisible(true);
            }
            
            query = "SELECT product_id, SUM(quantity) FROM client_order_specs, sales_records WHERE client_order_specs.receipt_no = sales_records.receipt_no AND order_date = '" + search_choice + "' GROUP BY product_id";
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                if (rs.getInt("SUM(quantity)") > max_count){
                    max_count = rs.getInt("SUM(quantity)");
                    most_prod = rs.getString("product_id");
                    label_most_sold_value.setText(most_prod);
                }
            }
            
            label_most_sold_value.setVisible(true);
            
            query = "SELECT unit_selling_price FROM product_info WHERE product_id = '" + most_prod + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                most_cost = max_count * rs.getDouble(1);
                
                label_most_sold_cost_value.setText(String.valueOf(most_cost));
                label_most_sold_cost_value.setVisible(true);
            }
            
            con.close();
            
        }
        catch (SQLException sqlExp) {
            JOptionPane.showMessageDialog(null, sqlExp);
        }
    }
    
    void client_search(String search_choice){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            int max_count = 0;
            String most_prod = null;
            double most_cost;
            
            query = "SELECT SUM(quantity) FROM sales_records, client_order_specs WHERE sales_records.receipt_no = client_order_specs.receipt_no AND client_id = '" + search_choice + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                label_total_sold_value.setText(rs.getString(1));
                label_total_sold_value.setVisible(true);
            }
            
            query = "SELECT SUM(unit_selling_price * client_order_specs.quantity) FROM product_info, sales_records, client_order_specs WHERE product_info.product_id = client_order_specs.product_id AND client_order_specs.receipt_no = sales_records.receipt_no AND client_id = '" + search_choice + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                label_total_cost_value.setText(rs.getString(1));
                label_total_cost_value.setVisible(true);
            }
            
            query = "SELECT product_id, SUM(quantity) FROM client_order_specs, sales_records WHERE client_order_specs.receipt_no = sales_records.receipt_no AND client_id = '" + search_choice + "' GROUP BY product_id";
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                if (rs.getInt("SUM(quantity)") > max_count){
                    max_count = rs.getInt("SUM(quantity)");
                    most_prod = rs.getString("product_id");
                    label_most_sold_value.setText(most_prod);
                }
            }
            
            label_most_sold_value.setVisible(true);
            
            query = "SELECT unit_selling_price FROM product_info WHERE product_id = '" + most_prod + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                most_cost = max_count * rs.getDouble(1);
                
                label_most_sold_cost_value.setText(String.valueOf(most_cost));
                label_most_sold_cost_value.setVisible(true);
            }
            
            con.close();
            
        }
        catch (SQLException sqlExp) {
            JOptionPane.showMessageDialog(null, sqlExp);
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
        jPanel2 = new javax.swing.JPanel();
        label_receipt = new javax.swing.JLabel();
        textfield_search = new javax.swing.JTextField();
        button_receipt_search = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        label_history = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        date_search = new com.toedter.calendar.JDateChooser();
        button_ok = new javax.swing.JButton();
        label_client_id = new javax.swing.JLabel();
        textfield_client_id = new javax.swing.JTextField();
        button_report = new javax.swing.JButton();
        month_chooser = new com.toedter.calendar.JMonthChooser();
        year_chooser = new com.toedter.calendar.JYearChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        label_total_sold_value = new javax.swing.JLabel();
        label_total_cost_value = new javax.swing.JLabel();
        label_most_sold_value = new javax.swing.JLabel();
        label_most_sold_cost_value = new javax.swing.JLabel();
        button_logout = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        label_product_id = new javax.swing.JLabel();
        textfield_product_id = new javax.swing.JTextField();
        label_total_sold = new javax.swing.JLabel();
        label_total_unit_sold_value = new javax.swing.JLabel();
        label_total_cost = new javax.swing.JLabel();
        label_total_unit_cost_value = new javax.swing.JLabel();
        button_product_search = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        label_receipt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_receipt.setForeground(new java.awt.Color(0, 0, 153));
        label_receipt.setText("ENTER RECEIPT NO.:");

        textfield_search.setBackground(new java.awt.Color(255, 255, 255));
        textfield_search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_search.setForeground(new java.awt.Color(0, 0, 0));

        button_receipt_search.setBackground(new java.awt.Color(0, 0, 153));
        button_receipt_search.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_receipt_search.setText("SEARCH");
        button_receipt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_receipt_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_receipt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfield_search, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_receipt_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_receipt)
                    .addComponent(textfield_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_receipt_search))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 0, 255));

        label_history.setFont(new java.awt.Font("Engravers MT", 3, 14)); // NOI18N
        label_history.setForeground(new java.awt.Color(0, 0, 153));
        label_history.setText("HISTORY");

        label_date.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_date.setForeground(new java.awt.Color(0, 0, 0));
        label_date.setText("ENTER DATE:");

        date_search.setDateFormatString("yyyy-MM-dd");
        date_search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        button_ok.setBackground(new java.awt.Color(0, 0, 153));
        button_ok.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_ok.setText("OK");
        button_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_okActionPerformed(evt);
            }
        });

        label_client_id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_client_id.setForeground(new java.awt.Color(0, 0, 0));
        label_client_id.setText("ENTER CLIENT ID:");

        textfield_client_id.setBackground(new java.awt.Color(255, 255, 255));
        textfield_client_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_client_id.setForeground(new java.awt.Color(0, 0, 0));
        textfield_client_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textfield_client_idMouseClicked(evt);
            }
        });

        button_report.setBackground(new java.awt.Color(51, 0, 102));
        button_report.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_report.setText("GENERATE MONTHLY REPORT");
        button_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_reportActionPerformed(evt);
            }
        });

        month_chooser.setForeground(new java.awt.Color(255, 255, 255));
        month_chooser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        year_chooser.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label_client_id, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textfield_client_id, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label_date)
                                .addGap(63, 63, 63)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date_search, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(label_history, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(month_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(year_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(button_ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(136, 136, 136))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(label_history)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_date, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_client_id)
                    .addComponent(textfield_client_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(button_ok)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(month_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(year_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_report)
                .addGap(25, 25, 25))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NUMBER OF PRODUCTS SOLD:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TOTAL COST OF SALES:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MOST SOLD PRODUCT ID:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL COST OF MOST SOLD PRODUCT:");

        label_total_sold_value.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label_total_sold_value.setForeground(new java.awt.Color(0, 0, 0));
        label_total_sold_value.setText("TOTAL SOLD");

        label_total_cost_value.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label_total_cost_value.setForeground(new java.awt.Color(0, 0, 0));
        label_total_cost_value.setText("TOTAL SOLD");

        label_most_sold_value.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label_most_sold_value.setForeground(new java.awt.Color(0, 0, 0));
        label_most_sold_value.setText("TOTAL SOLD");

        label_most_sold_cost_value.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label_most_sold_cost_value.setForeground(new java.awt.Color(0, 0, 0));
        label_most_sold_cost_value.setText("TOTAL SOLD");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70)
                        .addComponent(label_total_sold_value))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(101, 101, 101)
                        .addComponent(label_most_sold_value))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(116, 116, 116)
                        .addComponent(label_total_cost_value))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_most_sold_cost_value)))
                .addGap(42, 42, 42))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(label_total_sold_value))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(label_total_cost_value))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(label_most_sold_value))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(label_most_sold_cost_value))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        button_logout.setBackground(new java.awt.Color(51, 0, 153));
        button_logout.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        button_logout.setText("LOG OUT");
        button_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logoutActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        label_product_id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_product_id.setForeground(new java.awt.Color(0, 0, 0));
        label_product_id.setText("ENTER PRODUCT ID:");

        textfield_product_id.setBackground(new java.awt.Color(255, 255, 255));
        textfield_product_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_product_id.setForeground(new java.awt.Color(0, 0, 0));

        label_total_sold.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_total_sold.setForeground(new java.awt.Color(255, 255, 255));
        label_total_sold.setText("TOTAL UNITS SOLD:");

        label_total_unit_sold_value.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label_total_unit_sold_value.setForeground(new java.awt.Color(0, 0, 0));
        label_total_unit_sold_value.setText("TOTAL SOLD");

        label_total_cost.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_total_cost.setForeground(new java.awt.Color(255, 255, 255));
        label_total_cost.setText("TOTAL PRICE OF SOLD UNITS:");

        label_total_unit_cost_value.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label_total_unit_cost_value.setForeground(new java.awt.Color(0, 0, 0));
        label_total_unit_cost_value.setText("TOTAL SOLD");

        button_product_search.setBackground(new java.awt.Color(0, 0, 153));
        button_product_search.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_product_search.setText("OK");
        button_product_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_product_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(label_total_cost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_total_unit_cost_value))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(label_total_sold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)
                                .addComponent(label_total_unit_sold_value)))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(label_product_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textfield_product_id, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(button_product_search, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_product_id)
                    .addComponent(textfield_product_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(button_product_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_total_sold)
                    .addComponent(label_total_unit_sold_value))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_total_unit_cost_value)
                    .addComponent(label_total_cost))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_goback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_logout))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(149, 149, 149)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(291, 291, 291))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_goback)
                    .addComponent(button_logout))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
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

    private void button_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_okActionPerformed
        // TODO add your handling code here:
        if (textfield_client_id.getText().isEmpty() == false){
            search = textfield_client_id.getText();
            client_search(search);
        }
            
        else
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
            search = formatter.format(date_search.getDate());
            
            date_search(search);
        }
    }//GEN-LAST:event_button_okActionPerformed

    private void button_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_logoutActionPerformed
        // TODO add your handling code here:
        dispose();
        
        login_main obj = new login_main();
        obj.show();
    }//GEN-LAST:event_button_logoutActionPerformed

    private void button_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gobackActionPerformed
        // TODO add your handling code here:
        if (permission_emp == 1 || permission_sales == 1 || permission_orders == 1)
        {
            dispose();
        
            sales obj = new sales(ob);
            obj.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ACCESS");
        }
        
    }//GEN-LAST:event_button_gobackActionPerformed

    private void button_product_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_product_searchActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            
            query = "SELECT SUM(client_order_specs.quantity), (unit_selling_price * SUM(client_order_specs.quantity)) FROM client_order_specs, product_info WHERE client_order_specs.product_id = product_info.product_id AND client_order_specs.product_id = '" + textfield_product_id.getText() + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                label_total_unit_sold_value.setText(rs.getString(1));
                label_total_unit_sold_value.setVisible(true);
                
                label_total_unit_cost_value.setText(rs.getString(2));
                label_total_unit_cost_value.setVisible(true);
            }
                        
            con.close();
            
        }
        catch (SQLException sqlExp) {
            JOptionPane.showMessageDialog(null, sqlExp);
        }
    }//GEN-LAST:event_button_product_searchActionPerformed

    private void button_receipt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_receipt_searchActionPerformed
        // TODO add your handling code here:
        if (textfield_search.getText().length() == 0)
            JOptionPane.showMessageDialog(null, "ENTER RECEIPT NO. TO SEARCH");
        
        else{
            if (permission_emp == 1)
            {
                dispose();

                viewer_sales obj = new viewer_sales(ob, 1, textfield_search.getText());
                obj.show();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ACCESS");
            }
        }
               
    }//GEN-LAST:event_button_receipt_searchActionPerformed

    private void textfield_client_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textfield_client_idMouseClicked
        // TODO add your handling code here:
        date_search.setDate(null);
    }//GEN-LAST:event_textfield_client_idMouseClicked

    private void button_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_reportActionPerformed
        // TODO add your handling code here:
        JComboBox s = (JComboBox) month_chooser.getComboBox();
        
        int month_int = month_chooser.getMonth() + 1;
        int year_int = year_chooser.getYear();
        
        int total_sup = 0;
        int total_prod = 0;
        int most_prod_quantity = 0;
        int patients = 0;
        double total_sup_cost = 0;
        double total_prod_cost = 0;
        double most_prod_cost = 0;
        double total_charge = 0;
        double income = 0;
        double income_due = 0;
        double profit = 0;
        double total_sale_cost = 0.0;
        double total_payment = 0.0;
        double total_due = 0;
        String most_prod = null;
        String filename = null;
        
        String month_str, year_str;
        
        if(month_int == 10 || month_int == 11 || month_int == 12)
            month_str = String.valueOf(month_int);
        else
            month_str = "0" + String.valueOf(month_int);
        
        year_str = String.valueOf(year_int);
        
        String min_date = year_str + "-" + month_str + "-" + "01";
        String max_date = year_str + "-" + month_str + "-" + "31";
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            int max_count = 0;
            String most_prod_temp = null;
            double most_cost;
            
            query = "SELECT SUM(quantity) FROM supplies_info, ordered_supplies WHERE supplies_info.supply_no = ordered_supplies.supply_no AND order_date BETWEEN '" + min_date + "' AND '" + max_date + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                total_sup = rs.getInt(1);
            }
            
            query = "SELECT SUM(ordered_supplies.quantity * unit_cost_price) FROM supplies_info, ordered_supplies, product_info WHERE supplies_info.supply_no = ordered_supplies.supply_no AND ordered_supplies.product_id = product_info.product_id AND order_date BETWEEN '" + min_date + "' AND '" + max_date + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                total_sup_cost = rs.getDouble(1);
            }
            
            query = "SELECT SUM(quantity) FROM sales_records, client_order_specs WHERE sales_records.receipt_no = client_order_specs.receipt_no AND order_date BETWEEN '" + min_date + "' AND '" + max_date + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                total_prod = rs.getInt(1);
            }
            
            query = "SELECT SUM(unit_selling_price * client_order_specs.quantity) FROM product_info, sales_records, client_order_specs WHERE product_info.product_id = client_order_specs.product_id AND client_order_specs.receipt_no = sales_records.receipt_no AND order_date BETWEEN '" + min_date + "' AND '" + max_date + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                total_prod_cost = rs.getDouble(1);
            }
            
            query = "SELECT product_id, SUM(quantity) FROM client_order_specs, sales_records WHERE client_order_specs.receipt_no = sales_records.receipt_no AND order_date BETWEEN '" + min_date + "' AND '" + max_date + "' GROUP BY product_id";
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                if (rs.getInt("SUM(quantity)") > max_count){
                    max_count = rs.getInt("SUM(quantity)");
                    most_prod_temp = rs.getString("product_id");
                }
            }
            
            most_prod = most_prod_temp;
            most_prod_quantity = max_count;
            
            query = "SELECT unit_selling_price FROM product_info WHERE product_id = '" + most_prod_temp + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                most_cost = max_count * rs.getDouble(1);
                
                most_prod_cost = most_cost;
            }
            
            query = "SELECT COUNT(client_id) FROM appointment WHERE appointment_date BETWEEN '" + min_date + "' AND '" + max_date + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                patients = rs.getInt(1);
            }
            
            query = "SELECT SUM(charge) FROM appointment WHERE appointment_date BETWEEN '" + min_date + "' AND '" + max_date + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                total_charge = rs.getDouble(1);
            }
            
            query = "SELECT payment, pay_cleared, (client_order_specs.quantity * unit_selling_price) AS 'total_price' FROM client_order_specs, sales_records, product_info WHERE client_order_specs.receipt_no = sales_records.receipt_no AND client_order_specs.product_id = product_info.product_id AND order_date BETWEEN '" + min_date + "' AND '" + max_date + "'";
            rs = stm.executeQuery(query);
            
            while (rs.next()){
                if (rs.getString("pay_cleared").equals("NO")){
                    total_payment = total_payment + rs.getDouble("payment");
                    total_sale_cost = total_sale_cost + rs.getDouble("total_price");
                }
            }
            
            total_due = total_sale_cost - total_payment;
            
            con.close();
            
        }
        catch (SQLException sqlExp) {
            JOptionPane.showMessageDialog(null, sqlExp);
        }
        
        income = total_prod_cost + total_charge;
        profit = income - total_sup_cost;
        income_due = income - total_due;
        
        try{
            filename = ".\\Monthly Reports\\" + s.getSelectedItem().toString().toUpperCase() + year_str + ".pdf";
            String value;
            
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            
            page.setMediaBox(PDRectangle.A4);
            PDRectangle pageSize = page.getMediaBox();
            
            doc.addPage(page);
            
            PDPageContentStream content = new PDPageContentStream(doc, page);
            
            content.beginText();
            content.setLeading(14.5f);
            
            content.setFont(PDType1Font.TIMES_BOLD, 16);
            content.newLineAtOffset(228.41f, pageSize.getHeight() - 86.900024f);
            content.showText("MUJNABIN OPTIC'S");
            
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 20);
            content.moveTextPositionByAmount(230.21f - 228.41f, 0);
            content.showText("SALES REPORT");
            
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.newLineAtOffset(205.25f - 228.41f , 0);
            value = "FOR THE MONTH OF " + s.getSelectedItem().toString().toUpperCase();
            content.showText(value);
            
            content.newLine();
            content.newLine();
            content.newLine();
            content.newLine();
            
            content.newLineAtOffset(72.024f - 228.41f , 0);
            content.showText("TOTAL SUPPLIES BOUGHT: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(total_sup);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("COST: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(total_sup_cost);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("TOTAL PRODUCTS SOLD: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(total_prod);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("COST: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(total_prod_cost);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("TOTAL DUE: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(total_due);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("MOST SOLD PRODUCT: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            content.showText(most_prod);
            
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("TOTAL UNITS SOLD OF MOST SOLD PRODUCT: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(most_prod_quantity);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("COST: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(most_prod_cost);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("NUMBER OF PATIENTS SEEN: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(patients);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("TOTAL CHARGE: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(total_charge);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("TOTAL INCOME: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(income);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("TOTAL INCOME (WITH DUE): ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(income_due);
            content.showText(value);
            
            content.newLine();
            content.newLine();
            content.newLine();
            content.newLine();
            
            content.setFont(PDType1Font.TIMES_BOLD, 14);
            content.showText("PROFIT: ");
            content.setFont(PDType1Font.TIMES_ITALIC, 14);
            value = String.valueOf(profit);
            content.showText(value);
            
            content.newLine();
            
            content.endText();
            
            content.close();
            doc.save(filename);
            doc.close();
        }
        catch(IOException e){
            
        }
        
        try{
            File file = new File(filename);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }
        catch(IOException e){
            
        }
    }//GEN-LAST:event_button_reportActionPerformed

    private void addMouseListenerRecrusively(Container container){

   for (Component component:container.getComponents()){
     if (component instanceof Container)
        addMouseListenerRecrusively((Container) component); 
   }

   container.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            textfield_client_id.setText(null);
        }
    });

}
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_goback;
    private javax.swing.JButton button_logout;
    private javax.swing.JButton button_ok;
    private javax.swing.JButton button_product_search;
    private javax.swing.JButton button_receipt_search;
    private javax.swing.JButton button_report;
    private com.toedter.calendar.JDateChooser date_search;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel label_client_id;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_history;
    private javax.swing.JLabel label_most_sold_cost_value;
    private javax.swing.JLabel label_most_sold_value;
    private javax.swing.JLabel label_product_id;
    private javax.swing.JLabel label_receipt;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_total_cost;
    private javax.swing.JLabel label_total_cost_value;
    private javax.swing.JLabel label_total_sold;
    private javax.swing.JLabel label_total_sold_value;
    private javax.swing.JLabel label_total_unit_cost_value;
    private javax.swing.JLabel label_total_unit_sold_value;
    private com.toedter.calendar.JMonthChooser month_chooser;
    private javax.swing.JTextField textfield_client_id;
    private javax.swing.JTextField textfield_product_id;
    private javax.swing.JTextField textfield_search;
    private com.toedter.calendar.JYearChooser year_chooser;
    // End of variables declaration//GEN-END:variables
}
