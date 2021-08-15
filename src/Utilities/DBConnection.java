/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *This class is used to establish a connection to the database. 
 * @author Eric
 */
public class DBConnection {
    

    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress = "//wgudb.ucertify.com:3306/";
    private static final String dbName = "WJ08KU0";
    //Required for MySQL Connector/J driver 8.0.23 and above
    private static final String timeConv = "?connectionTimeZone=SERVER";
    private static final String jdbcUrl = protocol + vendorName + ipAddress + dbName + timeConv;
    private static final String MYSQLJDBCDriver = "com.mysql.cj.jdbc.Driver"; //"com.mysql.jdbc.Driver";
    private static Connection conn = null;
    private static final String username = "U08KU0";
    private static final String password = "53689314432";
    
    /**
     * This method starts the connection to the database. 
     */
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
    
    /**
     * This method retrieves the connection to the database. 
     */
    public static Connection getConnection() {
        return conn;
    }
    
    /**
     * This method closes the connection to the database. 
     */
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
