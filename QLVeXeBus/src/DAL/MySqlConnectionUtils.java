/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection; // Chua ket noi
import java.sql.DriverManager; // Khoi tao driver cua csdl
import java.sql.SQLException; // Bat loi
import java.sql.Statement; // Chuyen thuc hien cau lenh
import java.sql.PreparedStatement; // Cau lenh can chuan bi truoc

/**
 *
 * @author Administrator
 */
public class MySqlConnectionUtils {

    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String databaseName = "qlvexe";
        String user = "root";
        String password = "1234";
        return getMyConnection(hostName, databaseName, user, password);
    }

    public static Connection getMyConnection(String hostName, String databaseName, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        // jdbc la DriverManager, csdl dung mysql
        String urlConnection = "jdbc:mysql://" + hostName + ":3306/" + databaseName;
        Connection conn = (Connection) DriverManager.getConnection(urlConnection, user, password);
        // jdbs:mysql://localhost:3306/data?/
        System.out.println("Connected!");
        return conn;
    }
}
