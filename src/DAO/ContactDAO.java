/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Contact;
import Model.Data;
import Utilities.DBConnection;
import Utilities.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to send queries to the contacts table in the database
 * @author Eric Matelyan
 */
public abstract class ContactDAO {
    
    /**
     * Select statement for all rows in the contacts table. 
     * 
     */
    public static void selectContacts() throws SQLException {
        try {
            Data.clearContacts();
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT * from contacts;";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                int contactID = resultSet.getInt("Contact_ID");
                String contactName = resultSet.getString("Contact_Name");
                String email = resultSet.getString("Email");

                Contact contact = new Contact(contactID, contactName, email);
                Data.addContact(contact);
            }
        }
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
    
}
