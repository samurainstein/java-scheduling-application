/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Country;
import Model.Customer;
import Model.Data;
import Utilities.DBConnection;
import Utilities.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Eric
 */
public abstract class CountryDAO {
    //Methods
    public static void selectCountries() {
        try {
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT * FROM countries; ";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                int countryID = resultSet.getInt("Country_ID");
                String countryName = resultSet.getString("Country");
                
                Country country = new Country(countryID, countryName);
                Data.addCountry(country);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}