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
            if(Data.getAllCustomers().size() > 0)
                return;
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT Customer_ID, Customer_Name, Address, Postal_Code, Phone, Division, Country "
                                + "FROM customers, first_level_divisions, countries "
                                + "WHERE customers.Division_ID = first_level_divisions.Division_ID "
                                + "AND first_level_divisions.Country_ID = countries.Country_ID; ";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                int customerID = resultSet.getInt("Customer_ID");
                String customerName = resultSet.getString("Customer_Name");
                String address = resultSet.getString("Address");
                String postalCode = resultSet.getString("Postal_Code");
                String phone = resultSet.getString("Phone");
                String division = resultSet.getString("Division");
                String country = resultSet.getString("Country");
                
                Customer customer = new Customer(customerID, customerName, address, postalCode, phone, division, country);
                Data.addCustomer(customer);
            }
        }
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    public static void insertCustomer(String name, String address, String postalCode, String phone, int divisionID) {
        try {
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "INSERT INTO customers(Customer_Name, Address, Postal_Code, Phone, Division_ID) "
                                + "VALUES(?, ?, ?, ?, ?);";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, postalCode);
            preparedStatement.setString(4, phone);
            preparedStatement.setInt(5, divisionID);
            preparedStatement.execute();
            Data.clearCustomers();
        }
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    public static void deleteCustomer(int customerID) {
        try {
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "DELETE FROM customers "
                                + "WHERE Customer_ID = ?;";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.setInt(1,customerID);
            preparedStatement.execute();
            Data.clearCustomers();
        }
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
}
