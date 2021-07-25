/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import Model.Data;
import Utilities.DBConnection;
import Utilities.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Eric
 */
public abstract class CustomerDAO {
    //Methods
    public static void selectCustomers() {
        try {
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT * FROM customers; ";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                int customerID = resultSet.getInt("Customer_ID");
                String customerName = resultSet.getString("Customer_Name");
                String address = resultSet.getString("Address");
                String postalCode = resultSet.getString("Postal_Code");
                String phone = resultSet.getString("phone");
                int divisionID = resultSet.getInt("Division_ID");
                //String country = 
                
                Customer customer = new Customer(customerID, customerName, address, postalCode, phone, divisionID);
                Data.addCustomer(customer);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
