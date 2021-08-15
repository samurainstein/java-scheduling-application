/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Data;
import Model.Division;
import Utilities.DBConnection;
import Utilities.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to send queries to the first_level_divisions table in the database
 * @author Eric Matelyan
 */
public abstract class DivisionDAO {
    /**
     * Select statement for all rows in the first_level_divisions table. 
     * 
     */
    public static void selectDivisions() {
        try {
            Data.clearDivisions();
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT * from first_level_divisions;";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                int divisionID = resultSet.getInt("Division_ID");
                String divisionName = resultSet.getString("Division");
                int countryID = resultSet.getInt("COUNTRY_ID");
                
                Division division = new Division(divisionID, divisionName, countryID);
                Data.addDivision(division);
            }
        }
 
        
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }   
    
    /**
     * Select statement for all rows in the first_level_divisions table that are associated with a specific country ID. 
     * @param filterID Country ID to be searched for
     */
    public static void selectFilteredDivisions(int filterID) {
        try {
            Data.clearFilteredDivisions();
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT * from first_level_divisions "
                                + "WHERE Country_ID = ? ORDER BY Division;";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.setInt(1, filterID);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                int divisionID = resultSet.getInt("Division_ID");
                String divisionName = resultSet.getString("Division");
                int countryID = resultSet.getInt("COUNTRY_ID");
                
                Division division = new Division(divisionID, divisionName, countryID);
                Data.addFilteredDivision(division);
            }
        }
 
        
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
}
