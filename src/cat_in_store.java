
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class cat_in_store extends javax.swing.JFrame {

    /**
     * Creates new form cat_in_store
     */
    
    set_id ob;
    String search, query, id, brand, shape, design, material, quantity, cost_price, selling_price;
    ResultSet rs;
    int permission_emp, permission_supplies;
    int permission_product;
    
    public cat_in_store(set_id obj) {
        initComponents();
        label_id_gen.setVisible(false);
        textfield_id.setVisible(false);
        button_ok.setVisible(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ob = obj;
        permission_emp = ob.employee_perm;
        permission_product = ob.product_perm;
        permission_supplies = ob.supplies_perm;
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
    }
    
    public cat_in_store(set_id obj, int x) {
        initComponents();
        label_id_gen.setVisible(false);
        textfield_id.setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ob = obj;
        permission_emp = ob.employee_perm;
        permission_product = ob.product_perm;
        permission_supplies = ob.supplies_perm;
        
        setIconImage(new ImageIcon(".\\icons\\Icon.png").getImage());
    }
    
    public cat_in_store(set_id obj, String sid,String sbrand,String sshape, String sdesign, String smaterial, String squantity, String scost_price, String sselling_price) {
        initComponents();
     
        textfield_id.setVisible(false);
        button_ok.setVisible(false);
        
        label_id_gen.setText(sid);
        label_id_gen.setVisible(true);
        textfield_brand.setText(sbrand);
        textfield_shape.setText(sshape);
        textfield_design.setText(sdesign);
        textfield_material.setText(smaterial);
        textfield_quantity.setText(squantity);
        textfield_cost_price.setText(scost_price);
        textfield_selling_price.setText(sselling_price);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ob = obj;
        permission_emp = ob.employee_perm;
        permission_product = ob.product_perm;
        permission_supplies = ob.supplies_perm;
        
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
        jPanel2 = new javax.swing.JPanel();
        button_viewall = new javax.swing.JButton();
        textfield_search = new javax.swing.JTextField();
        button_search = new javax.swing.JButton();
        label_id = new javax.swing.JLabel();
        label_brand = new javax.swing.JLabel();
        textfield_brand = new javax.swing.JTextField();
        label_shape = new javax.swing.JLabel();
        textfield_shape = new javax.swing.JTextField();
        label_design = new javax.swing.JLabel();
        textfield_design = new javax.swing.JTextField();
        button_add = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        combobox_search = new javax.swing.JComboBox<>();
        label_material = new javax.swing.JLabel();
        label_quantity = new javax.swing.JLabel();
        label_costprice = new javax.swing.JLabel();
        textfield_material = new javax.swing.JTextField();
        textfield_quantity = new javax.swing.JTextField();
        label_search = new javax.swing.JLabel();
        label_sellingprice = new javax.swing.JLabel();
        textfield_selling_price = new javax.swing.JTextField();
        textfield_cost_price = new javax.swing.JTextField();
        label_id_gen = new javax.swing.JLabel();
        textfield_id = new javax.swing.JTextField();
        button_ok = new javax.swing.JButton();
        button_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        button_viewall.setBackground(new java.awt.Color(0, 0, 153));
        button_viewall.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_viewall.setText("VIEW ALL");
        button_viewall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_viewallActionPerformed(evt);
            }
        });

        textfield_search.setBackground(new java.awt.Color(255, 255, 255));
        textfield_search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_search.setForeground(new java.awt.Color(0, 0, 0));

        button_search.setBackground(new java.awt.Color(0, 0, 153));
        button_search.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_search.setText("SEARCH");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });

        label_id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_id.setForeground(new java.awt.Color(0, 0, 153));
        label_id.setText("PRODUCT ID:");

        label_brand.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_brand.setForeground(new java.awt.Color(0, 0, 153));
        label_brand.setText("BRAND:");

        textfield_brand.setBackground(new java.awt.Color(255, 255, 255));
        textfield_brand.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_brand.setForeground(new java.awt.Color(0, 0, 0));

        label_shape.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_shape.setForeground(new java.awt.Color(0, 0, 153));
        label_shape.setText("SHAPE:");

        textfield_shape.setBackground(new java.awt.Color(255, 255, 255));
        textfield_shape.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_shape.setForeground(new java.awt.Color(0, 0, 0));

        label_design.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_design.setForeground(new java.awt.Color(0, 0, 153));
        label_design.setText("DESIGN:");

        textfield_design.setBackground(new java.awt.Color(255, 255, 255));
        textfield_design.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_design.setForeground(new java.awt.Color(0, 0, 0));

        button_add.setBackground(new java.awt.Color(51, 0, 153));
        button_add.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_add.setText("ADD NEW PRODUCT");
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_update.setBackground(new java.awt.Color(51, 0, 153));
        button_update.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_update.setText("UPDATE");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        button_delete.setBackground(new java.awt.Color(51, 0, 153));
        button_delete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_delete.setText("REMOVE");
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        combobox_search.setBackground(new java.awt.Color(255, 255, 255));
        combobox_search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combobox_search.setForeground(new java.awt.Color(0, 0, 0));
        combobox_search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Product ID", "Brand", "Shape", "Design", "Material" }));

        label_material.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_material.setForeground(new java.awt.Color(0, 0, 153));
        label_material.setText("MATERIAL:");

        label_quantity.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_quantity.setForeground(new java.awt.Color(0, 0, 153));
        label_quantity.setText("STOCK:");

        label_costprice.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_costprice.setForeground(new java.awt.Color(0, 0, 153));
        label_costprice.setText("COST PRICE:");

        textfield_material.setBackground(new java.awt.Color(255, 255, 255));
        textfield_material.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_material.setForeground(new java.awt.Color(0, 0, 0));

        textfield_quantity.setBackground(new java.awt.Color(255, 255, 255));
        textfield_quantity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_quantity.setForeground(new java.awt.Color(0, 0, 0));

        label_search.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_search.setForeground(new java.awt.Color(0, 0, 0));
        label_search.setText("ENTER KEYWORD:");

        label_sellingprice.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_sellingprice.setForeground(new java.awt.Color(0, 0, 153));
        label_sellingprice.setText("SELLING PRICE:");

        textfield_selling_price.setBackground(new java.awt.Color(255, 255, 255));
        textfield_selling_price.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_selling_price.setForeground(new java.awt.Color(0, 0, 0));

        textfield_cost_price.setBackground(new java.awt.Color(255, 255, 255));
        textfield_cost_price.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_cost_price.setForeground(new java.awt.Color(0, 0, 0));

        label_id_gen.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        label_id_gen.setForeground(new java.awt.Color(0, 0, 0));
        label_id_gen.setText("ID");

        textfield_id.setBackground(new java.awt.Color(255, 255, 255));
        textfield_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textfield_id.setForeground(new java.awt.Color(0, 0, 0));

        button_ok.setBackground(new java.awt.Color(0, 0, 153));
        button_ok.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_ok.setText("OK");
        button_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_costprice)
                                .addComponent(label_quantity)
                                .addComponent(label_material)
                                .addComponent(label_design)
                                .addComponent(label_shape))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(label_brand)
                                .addGap(39, 39, 39)))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(button_viewall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(139, 139, 139))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfield_shape, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfield_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfield_design, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfield_material, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfield_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label_id_gen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textfield_id, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(textfield_cost_price, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label_sellingprice)
                                        .addGap(43, 43, 43)
                                        .addComponent(textfield_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(64, 64, 64)
                                .addComponent(button_ok, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addGap(108, 108, 108))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(button_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(100, 100, 100)
                                .addComponent(button_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(107, 107, 107)
                                .addComponent(button_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(label_search)
                                .addGap(33, 33, 33)
                                .addComponent(textfield_search, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(combobox_search, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(button_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_id)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_viewall)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfield_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_search)
                            .addComponent(combobox_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_search))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_id)
                            .addComponent(label_id_gen)
                            .addComponent(textfield_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(textfield_brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_brand))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfield_shape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_shape))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfield_design, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_design)))
                    .addComponent(button_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfield_material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_material))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfield_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_quantity))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_sellingprice)
                    .addComponent(textfield_selling_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfield_cost_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_costprice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_add)
                    .addComponent(button_delete)
                    .addComponent(button_update))
                .addGap(47, 47, 47))
        );

        button_logout.setBackground(new java.awt.Color(51, 0, 153));
        button_logout.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        button_logout.setText("LOG OUT");
        button_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logoutActionPerformed(evt);
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(191, 191, 191))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_goback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_logout)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_title)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_logout, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_goback))
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
        if (permission_emp == 1 || permission_product == 1 || permission_supplies == 1)
        {
            dispose();
            
            catalogue obj = new catalogue(ob);
            obj.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ACCESS");
        }
        
    }//GEN-LAST:event_button_gobackActionPerformed

    private void button_viewallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_viewallActionPerformed
        // TODO add your handling code here:
            dispose();

            viewer_product obj = new viewer_product(ob, 1, null);
            obj.show();
    }//GEN-LAST:event_button_viewallActionPerformed

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
        // TODO add your handling code here:
        String keyword = combobox_search.getSelectedItem().toString();
        search = textfield_search.getText();
        
        if (keyword.equals("Brand")){
            dispose();

            viewer_product obj = new viewer_product(ob, 2, search);
            obj.show();
        }
        
        else if (keyword.equals("Shape")){
            dispose();

            viewer_product obj = new viewer_product(ob, 3, search);
            obj.show();
        }
        
        else if (keyword.equals("Design")){
            dispose();

            viewer_product obj = new viewer_product(ob, 4, search);
            obj.show();
        }
        
        else if (keyword.equals("Material")){
            dispose();

            viewer_product obj = new viewer_product(ob, 5, search);
            obj.show();
        }
        
        else {
            
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
                Statement stm = con.createStatement();

                query = "SELECT * from product_info WHERE product_id = '" + search + "'";
                rs = stm.executeQuery(query);

                if (rs.next()){
                    id = rs.getString("product_id");
                    brand = rs.getString("brand");
                    shape = rs.getString("shape");
                    design = rs.getString("design");
                    material = rs.getString("material");
                    quantity = rs.getString("quantity");
                    cost_price = rs.getString("unit_cost_price");
                    selling_price = rs.getString("unit_selling_price"); 

                    label_id_gen.setText(id);
                    label_id_gen.setVisible(true);
                    textfield_brand.setText(brand);
                    textfield_shape.setText(shape);
                    textfield_design.setText(design);
                    textfield_material.setText(material);
                    textfield_quantity.setText(quantity);
                    textfield_cost_price.setText(cost_price);
                    textfield_selling_price.setText(selling_price);
                }

                else
                    JOptionPane.showMessageDialog(null, "PRODUCT NOT INCLUDED IN THE DATABASE");

                    con.close();
            
            }
            catch (SQLException sqlExp) {
                JOptionPane.showMessageDialog(null, sqlExp);
            }
            
        }
            
    }//GEN-LAST:event_button_searchActionPerformed

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        // TODO add your handling code here:
        cat_in_store main = new cat_in_store(ob, 1);
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_addActionPerformed

    private void button_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_okActionPerformed
        // TODO add your handling code here:
        String id;
        
        try {
            id = textfield_id.getText();
            brand = textfield_brand.getText();
            shape = textfield_shape.getText();
            design = textfield_design.getText();
            material = textfield_material.getText();
            quantity = textfield_quantity.getText();
            cost_price = textfield_cost_price.getText();
            selling_price = textfield_selling_price.getText();
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = null;
                                    
            if (textfield_id.getText().length()==0 || textfield_quantity.getText().length()==0 || textfield_cost_price.getText().length()==0 || textfield_selling_price.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "NECESSARY INFORMATION MISSING");
            }
            
            else if (product_check() == true){
                JOptionPane.showMessageDialog(null,"PRODUCT ALREADY EXISTS");
            }
            
            else {
                String acc_emp = "INSERT INTO `product_info`(`product_id`, `brand`, `shape`, `design`, `material`, `quantity`, `unit_cost_price`, `unit_selling_price`) VALUES ('" + id + "', '" + brand + "', '" + shape + "', '" + design + "', '" + material + "', " + quantity + ", " + cost_price + ", " + selling_price + ")";
            
                stm = con.createStatement();
            
                stm.executeUpdate(acc_emp);
                
                JOptionPane.showMessageDialog(null, "PRODUCT ADDED TO DATABASE");
            
                con.close();
                
                cat_in_store main = new cat_in_store(ob);
                main.setVisible(true);
                this.dispose();
            }
            
            con.close();
        }
            
        catch(SQLException sqlExp) {
            JOptionPane.showMessageDialog(null,sqlExp);
        }
        catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null,"PRODUCT ADDITION FAILED");
        }
    }//GEN-LAST:event_button_okActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        // TODO add your handling code here:
        try {
            brand = textfield_brand.getText();
            shape = textfield_shape.getText();
            design = textfield_design.getText();
            material = textfield_material.getText();
            quantity = textfield_quantity.getText();
            cost_price = textfield_cost_price.getText();
            selling_price = textfield_selling_price.getText();
            
            if (textfield_quantity.getText().length()==0 || textfield_cost_price.getText().length()==0 || textfield_selling_price.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "NECESSARY INFORMATION MISSING");
            }
            
            else
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
                Statement stm = con.createStatement();
                stm.execute("SET FOREIGN_KEY_CHECKS=0");
            
                query = "UPDATE `product_info` SET `brand` = '" + brand + "',`shape` = '" + shape + "',`design` = '" + design + "',`material` = '" + material + "',`quantity` = " + quantity + ",`unit_cost_price` = " + cost_price + ",`unit_selling_price` = " + selling_price + " WHERE product_id = '" + label_id_gen.getText() + "'";
                stm.executeUpdate(query);
            
                stm.execute("SET FOREIGN_KEY_CHECKS=1");            
                con.close();
            
                JOptionPane.showMessageDialog(null, "CHANGES SAVED");
            }
        }
        catch (SQLException sqlExp) {
            JOptionPane.showMessageDialog(null, sqlExp);
        }
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        // TODO add your handling code here:
        int delcon = JOptionPane.showConfirmDialog(null,"ARE YOU SURE?"); 
        
        if(delcon == JOptionPane.YES_OPTION){
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
                Statement stm = con.createStatement();
                stm.execute("SET FOREIGN_KEY_CHECKS=0");

                query = "DELETE FROM product_info WHERE product_id = '" + label_id_gen.getText() + "'";
                stm.executeUpdate(query);

                stm.execute("SET FOREIGN_KEY_CHECKS=1");            
                con.close();

                JOptionPane.showMessageDialog(null, "PRODUCT REMOVED FROM STORE DATABASE");

                dispose();
                cat_in_store main = new cat_in_store(ob);
                main.setVisible(true);
            }
            catch (SQLException sqlExp) {
                JOptionPane.showMessageDialog(null, sqlExp);
            }
        }
    }//GEN-LAST:event_button_deleteActionPerformed

    
    boolean product_check()
    {
        int x = 0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            PreparedStatement stm;
            ResultSet rs;

            String id_given = textfield_id.getText();

            stm = con.prepareStatement("Select product_id from product_info where product_id = ?");

            stm.setString(1, id_given);
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
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_goback;
    private javax.swing.JButton button_logout;
    private javax.swing.JButton button_ok;
    private javax.swing.JButton button_search;
    private javax.swing.JButton button_update;
    private javax.swing.JButton button_viewall;
    private javax.swing.JComboBox<String> combobox_search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_brand;
    private javax.swing.JLabel label_costprice;
    private javax.swing.JLabel label_design;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_id_gen;
    private javax.swing.JLabel label_material;
    private javax.swing.JLabel label_quantity;
    private javax.swing.JLabel label_search;
    private javax.swing.JLabel label_sellingprice;
    private javax.swing.JLabel label_shape;
    private javax.swing.JLabel label_title;
    private javax.swing.JTextField textfield_brand;
    private javax.swing.JTextField textfield_cost_price;
    private javax.swing.JTextField textfield_design;
    private javax.swing.JTextField textfield_id;
    private javax.swing.JTextField textfield_material;
    private javax.swing.JTextField textfield_quantity;
    private javax.swing.JTextField textfield_search;
    private javax.swing.JTextField textfield_selling_price;
    private javax.swing.JTextField textfield_shape;
    // End of variables declaration//GEN-END:variables
}
