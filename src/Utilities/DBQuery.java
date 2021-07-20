/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *This class is used to execute SQL statements on the database
 * @author Eric
 */
public class DBQuery {
    
    /**
     * This variable holds a reference to a statement. 
     */
    private static Statement statement;
    
    /**
     * This method is used to create a statement object. 
     * @param conn Receives a connection object
     */
    public static void setStatement(Connection conn) throws SQLException {
        statement = conn.createStatement();       
    }
    
    /**
     * This method is used to return a statement object. 
     * @return Returns a statement object
     */
    public static Statement getStatement() {
        return statement;
    }
}
