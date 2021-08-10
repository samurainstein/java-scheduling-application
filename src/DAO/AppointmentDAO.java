/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Appointment;
import Model.Data;
import Utilities.DBConnection;
import Utilities.DBQuery;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Eric
 */
public abstract class AppointmentDAO {
    public static void selectAppointments() throws SQLException {
        try {
            Data.clearAppointments();
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT Appointment_ID, Title, Description, Location, Type, Start, " +
                                "End, Customer_ID, appointments.Contact_ID, User_ID, Contact_Name " +
                                "FROM appointments, contacts " +
                                "WHERE appointments.Contact_ID = contacts.Contact_ID; ";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                int appointmentID = resultSet.getInt("Appointment_ID");
                String title = resultSet.getString("Title");
                String description = resultSet.getString("Description");
                String location = resultSet.getString("Location");
                String type = resultSet.getString("Type");
                Timestamp startTimestamp = resultSet.getTimestamp("Start");
                LocalDateTime start = startTimestamp.toLocalDateTime();
                Timestamp endTimestamp = resultSet.getTimestamp("End");
                LocalDateTime end = endTimestamp.toLocalDateTime();
                int customerID = resultSet.getInt("Customer_ID");
                int contactID = resultSet.getInt("Contact_ID");
                int userID = resultSet.getInt("User_ID");
                String contactName = resultSet.getString("Contact_Name");

                Appointment appointment = new Appointment(appointmentID, title, description, 
                            location, type, start, end, customerID, contactID, userID, contactName);

                Data.addAppointment(appointment);
            }
        }
        catch(SQLException exception) {
                exception.printStackTrace();
        }
        
    }
    
    public static void insertAppointment(String title, String description, String location, String type, LocalDateTime start, LocalDateTime end, int customerID, int userID, int contactID) {
            try {
                Connection conn = DBConnection.getConnection();
                String sqlStatement = "INSERT INTO appointments(Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID) " 
                                    +"Values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
                DBQuery.setPreparedStatement(conn, sqlStatement);
                PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, description);
                preparedStatement.setString(3, location);
                preparedStatement.setString(4, type);
                preparedStatement.setTimestamp(5, Timestamp.valueOf(start));
                preparedStatement.setTimestamp(6, Timestamp.valueOf(end));
                preparedStatement.setInt(7, customerID);
                preparedStatement.setInt(8, contactID);
                preparedStatement.setInt(9, userID);
                preparedStatement.execute();
                
            }
            catch(SQLException exception) {
                exception.printStackTrace();
            }
            
    }
    
    public static void updateAppointment(int appointmentID, String title, String description, String location, String type,
                                            LocalDateTime start, LocalDateTime end, int customerID, int userID, 
                                            int contactID) throws SQLException {
        try {
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "UPDATE appointments "
                                + "SET Title = ?, Description = ?, Location = ?, "
                                + "Type = ?, Start = ?, End = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ? "
                                + "Where Appointment_ID = ?;";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, location);
            preparedStatement.setString(4, type);
            preparedStatement.setTimestamp(5, Timestamp.valueOf(start));
            preparedStatement.setTimestamp(6, Timestamp.valueOf(end));
            preparedStatement.setInt(7, customerID);
            preparedStatement.setInt(8, userID);
            preparedStatement.setInt(9, contactID);
            preparedStatement.setInt(10, appointmentID);
            preparedStatement.execute();
        }
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
    
    public static void deleteAppointment(int appointmentID) throws SQLException {
        try {
            Connection conn = DBConnection.getConnection();
  
            String sqlStatement = "DELETE FROM appointments WHERE Appointment_ID = ?;";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.setInt(1, appointmentID);
            preparedStatement.execute();
            
        }
        catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static int getCustomerReport(String type, LocalDateTime start, LocalDateTime end) throws SQLException {
        Connection conn = DBConnection.getConnection();
        int count = 0;
        String sqlStatement = "SELECT COUNT(*) FROM appointments "
                            + "WHERE type=? AND "
                            + "Start BETWEEN ? and ?;";
        DBQuery.setPreparedStatement(conn, sqlStatement);
        PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
        preparedStatement.setString(1, type);
        preparedStatement.setTimestamp(2, Timestamp.valueOf(start));
        preparedStatement.setTimestamp(3, Timestamp.valueOf(end));
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while(resultSet.next()) {
            count = resultSet.getInt("COUNT(*)");
        }
        return count;
    }
    
    public static void selectAppointmentTypes() throws SQLException {
        try {
            Data.clearTypes();
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT Type from appointments;";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                String type = resultSet.getString("Type");
                Data.addType(type);
            }
        }
        catch(SQLException exception) {
                exception.printStackTrace();
        }
        
    }
}
