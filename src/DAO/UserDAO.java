/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Utilities.DBConnection;
import Utilities.DBQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author Eric
 */
public class UserDAO {
    
    //Members
    private ResultSet resultSet;
    
    //Methods
    public void selectUser(String sqlStatement) throws SQLException {
        Connection conn = DBConnection.getConnection();
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
        
        preparedStatement.execute();
        resultSet = preparedStatement.getResultSet();
        while(resultSet.next()) {
            int userID = resultSet.getInt("User_ID");
            String username = resultSet.getString("User_Name");
            String password = resultSet.getString("Password");
            LocalDate date = resultSet.getDate("Create_Date").toLocalDate();
            LocalTime time = resultSet.getTime("Create_Date").toLocalTime();
            String createdBy = resultSet.getString("Created_By");
            LocalDateTime lastUpdate = resultSet.getTimestamp("Last_Update").toLocalDateTime();
        }
    }
}
