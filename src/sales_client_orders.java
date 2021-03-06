
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class sales_client_orders extends javax.swing.JFrame {

    /**
     * Creates new form sales_client_orders
     */
    int permission_emp, permission_sales, permission_orders;
    set_id ob;
    
    public sales_client_orders(set_id obj) {
        initComponents();
        
        ob = obj;
        permission_emp = ob.employee_perm;
        permission_sales = ob.sales_perm;
        permission_orders = ob.orders_perm;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
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
        button_new = new javax.swing.JButton();
        button_factory = new javax.swing.JButton();
        button_delivered = new javax.swing.JButton();
        button_viewall = new javax.swing.JButton();
        button_store = new javax.swing.JButton();
        button_logout = new javax.swing.JButton();

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
        button_goback.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
        button_goback.setText("GO BACK");
        button_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gobackActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 0, 255));

        button_new.setBackground(new java.awt.Color(51, 0, 153));
        button_new.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_new.setText("NEW ORDER / SALE");
        button_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_newActionPerformed(evt);
            }
        });

        button_factory.setBackground(new java.awt.Color(0, 0, 102));
        button_factory.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_factory.setText("IN-FACTORY");
        button_factory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_factoryActionPerformed(evt);
            }
        });

        button_delivered.setBackground(new java.awt.Color(0, 0, 102));
        button_delivered.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_delivered.setText("DELIVERED");
        button_delivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deliveredActionPerformed(evt);
            }
        });

        button_viewall.setBackground(new java.awt.Color(51, 0, 153));
        button_viewall.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_viewall.setText("VIEW ALL");
        button_viewall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_viewallActionPerformed(evt);
            }
        });

        button_store.setBackground(new java.awt.Color(0, 0, 102));
        button_store.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_store.setText("IN STORE");
        button_store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_storeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(button_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(194, 194, 194))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(button_viewall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(220, 220, 220))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(button_factory, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(98, 98, 98)
                .addComponent(button_delivered, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(66, 66, 66)
                .addComponent(button_store, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(72, 72, 72))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(button_new, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_delivered, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_store, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_factory, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(button_viewall, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
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
                        .addComponent(button_goback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_logout)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(191, 191, 191))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void button_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_newActionPerformed
        // TODO add your handling code here:
            dispose();
        
            new_order_sales obj = new new_order_sales(ob);
            obj.show();
    }//GEN-LAST:event_button_newActionPerformed

    private void button_factoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_factoryActionPerformed
        // TODO add your handling code here:
        dispose();
        
        viewer_client_orders obj = new viewer_client_orders(ob, 2);
        obj.show();
    }//GEN-LAST:event_button_factoryActionPerformed

    private void button_viewallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_viewallActionPerformed
        // TODO add your handling code here:
        dispose();
        
        viewer_client_orders obj = new viewer_client_orders(ob, 1);
        obj.show();
    }//GEN-LAST:event_button_viewallActionPerformed

    private void button_deliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deliveredActionPerformed
        // TODO add your handling code here:
        dispose();
        
        viewer_client_orders obj = new viewer_client_orders(ob, 3);
        obj.show();
    }//GEN-LAST:event_button_deliveredActionPerformed

    private void button_storeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_storeActionPerformed
        // TODO add your handling code here:
        dispose();
        
        viewer_client_orders obj = new viewer_client_orders(ob, 4);
        obj.show();
    }//GEN-LAST:event_button_storeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_delivered;
    private javax.swing.JButton button_factory;
    private javax.swing.JButton button_goback;
    private javax.swing.JButton button_logout;
    private javax.swing.JButton button_new;
    private javax.swing.JButton button_store;
    private javax.swing.JButton button_viewall;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_title;
    // End of variables declaration//GEN-END:variables
}
