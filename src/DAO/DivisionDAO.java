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
 *
 * @author Eric
 */
public abstract class DivisionDAO {
    public static void selectDivisions() {
        try {
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
}
