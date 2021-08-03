/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Data;
import Model.User;
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
public abstract class UserDAO {
       
    //Methods
    public static int userLogin(String username, String password) {
        try {           
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT * FROM users "
                                + "WHERE User_Name = ? "
                                + "AND Password = ?";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                int userID = resultSet.getInt("User_ID");
                return userID;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void selectUsers() {
        try {
            Data.clearUsers();
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT * from users";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                int userID = resultSet.getInt("User_ID");
                String username = resultSet.getString("User_Name");
                String password = resultSet.getString("Password");
                
                User user = new User(userID, username, password);
                Data.addUser(user);
                System.out.println(user);
            }
        }
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
}
