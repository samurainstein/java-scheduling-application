/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

//import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eric
 */
public class DBConnection {
    
    //JDBC URL Parts
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress = "//wgudb.ucertify.com:3306/";
    private static final String dbName = "WJ08KU0";
    private static final String jdbcUrl = protocol + vendorName + ipAddress + dbName;
    
    //Driver and connection interface reference
    private static final String MYSQLJDBCDriver = "com.mysql.cj.jdbc.Driver"; //"com.mysql.jdbc.Driver";
    private static Connection conn = null;
    private static final String username = "U08KU0";
    private static final String password = "53689314432";
    
    public static Connection startConnection() {
        try {
            Class.forName(MYSQLJDBCDriver);
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection Successful");
        }
        catch(ClassNotFoundException exception) {
            //System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        catch(SQLException exception) {
            //System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        
        return conn;
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
    public static void closeConnection() {
        try {
            conn.close();
            System.out.println("Connection Closed");
        }
        catch(SQLException exception) {
            //do nothing
        }
    }
}
