/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *This class is used to execute SQL statements on the database
 * @author Eric
 */
public class DBQuery {
    
    /**
     * This variable holds a reference to a statement. 
     */
    private static PreparedStatement statement;
    
    /**
     * This method is used to create a prepared statement object. 
     * @param conn Receives a connection object
     */
    public static void setPreparedStatement(Connection conn, String sqlStatement) throws SQLException {
        statement = conn.prepareStatement(sqlStatement);       
    }
    
    /**
     * This method is used to return a prepared statement object. 
     * @return Returns a statement object
     */
    public static PreparedStatement getPreparedStatement() {
        return statement;
    }
}
