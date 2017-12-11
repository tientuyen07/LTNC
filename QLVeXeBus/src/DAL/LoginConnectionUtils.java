/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class LoginConnectionUtils {

    public static Connection getLoginConnectionUtils() throws SQLException, ClassNotFoundException {
        return MySqlConnectionUtils.getMyConnection();
    }

    public boolean CheckLogin(String user, String password) throws ClassNotFoundException {
        boolean i = false;
        String sql = "select * from tbl_dangnhap where TenDangNhap = '" + user + "' and MatKhau = '" + password + "'";
        try {
            Connection conn = LoginConnectionUtils.getLoginConnectionUtils();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                i = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
