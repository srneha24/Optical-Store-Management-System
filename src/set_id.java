import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

class set_id {
    int product_perm, supplier_perm, sales_perm, supplies_perm, orders_perm, client_perm, appointment_perm, employee_perm;
    String current_emp;
    
    set_id(String sign_id)
    {
        current_emp = sign_id;
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/optical_store_management_system", "root", "");
            Statement stm = con.createStatement();
            String query;
            ResultSet rs;
            
            query = "SELECT * from employee_permissions WHERE employee_id = '" + sign_id + "'";
            rs = stm.executeQuery(query);
            
            if (rs.next()){
                
                product_perm = rs.getInt("product");
                supplier_perm = rs.getInt("supplier");
                sales_perm = rs.getInt("sales");
                supplies_perm = rs.getInt("supplies");
                orders_perm = rs.getInt("orders");
                client_perm = rs.getInt("client");
                appointment_perm = rs.getInt("appointment");
                employee_perm = rs.getInt("employee");
                
                
            }
            
            con.close();
            
        }
        catch(SQLException sqlExp) {
            JOptionPane.showMessageDialog(null,"DATABASE CONNECTION FAILED");
        }
    }
}
