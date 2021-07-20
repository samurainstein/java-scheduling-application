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
 *This class is used to establish a connection to the database. 
 * @author Eric
 */
public class DBConnection {
    
    //JDBC URL Parts
    /**
     * This variable holds the protocol used to connect to the database. 
     */
    private static final String protocol = "jdbc";
    /**
     * This variable holds the vendor name used to connect to the database. 
     */
    private static final String vendorName = ":mysql:";
    /**
     * This variable holds the ipAddress or domain name used to connect to the database. 
     */
    private static final String ipAddress = "//wgudb.ucertify.com:3306/";
    /**
     * This variable holds the name of the database. 
     */
    private static final String dbName = "WJ08KU0";
    /**
     * This variable holds the statement needed to auto-convert time information on
     * the server from UTC to local time. 
     */
    //Required for MySQL Connector/J driver 8.0.23 and above
    private static final String timeConv = "?connectionTimeZone=SERVER";
    /**
     * This variable holds the complete string used to connect to the database. 
     */
    private static final String jdbcUrl = protocol + vendorName + ipAddress + dbName + timeConv;
    
    //Driver and connection interface reference
    /**
     * This variable holds the reference to the JDBC driver interface. 
     */
    private static final String MYSQLJDBCDriver = "com.mysql.cj.jdbc.Driver"; //"com.mysql.jdbc.Driver";
    /**
     * This variable holds the reference to the connection interface. 
     */
    private static Connection conn = null;
    /**
     * This variable holds the username used to login to the database. 
     */
    private static final String username = "U08KU0";
    /**
     * This variable holds the password used to login to the database. 
     */
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
