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
 * This class is used to send queries to the appointments table in the database
 * @author Eric Matelyan
 */
public abstract class AppointmentDAO {
    
    /**
     * Select statement for all rows in the appointments table. 
     * 
     */
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
    
    /**
     * Insert statement for adding a row to the appointments table. 
     * @param title Title data for the new appointment
     * @param description Description data for the new appointment
     * @param location Location data for the new appointment
     * @param type Type data for the new appointment
     * @param start Start timestamp for the new appointment
     * @param end End timestamp for the new appointment
     * @param customerID Associated customer ID for the new appointment
     * @param userID Associated User ID for the new appointment
     * @param contactID Associated Contact ID for the new appointment
     */
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
    
    /**
     * Set statement for updating a row in the appointments table. 
     * @param appointmentID Appointment ID to be updated
     * @param title Updated title data for the row
     * @param description Updated description data for the row
     * @param location Updated location data for the row
     * @param type Updated type data for the row
     * @param start Updated start timestamp for the row
     * @param end Updated end timestamp for the row
     * @param customerID Updated associated customer ID for the row
     * @param userID Updated associated user ID for the row
     * @param contactID Updated associated contact ID for the row
     */
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
    
    /**
     * Delete statement for a row in the appointments table. 
     * @param appointmentID Appointment ID to be deleted
     */
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
    
    /**
     * Select statement for all rows in the appointments table with a specified type, during a specific month. 
     * @param type Type of appointments to be queried
     * @param start Start timestamp for designated month
     * @param end End timestamp for designated month
     */
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
    
    /**
     * Select statement to get all of the different types of appointments in the appointments table. 
     * 
     */
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
    
    /**
     * Select statement for all rows in the appointments table with a certain contact ID associated with them.
     * @param reportContactID Contact ID to be searched for
     */
    public static void selectAppointmentsByContact(int reportContactID) {
        try {
            Data.clearAppointmentsByContact();
            Connection conn = DBConnection.getConnection();
            String sqlStatement = "SELECT Appointment_ID, Title, Description, Location, Type, Start, " +
                                "End, Customer_ID, appointments.Contact_ID, User_ID, Contact_Name " +
                                "FROM appointments, contacts " +
                                "WHERE appointments.Contact_ID = ? AND appointments.Contact_ID = contacts.Contact_ID " +
                                "ORDER BY Start;";
            DBQuery.setPreparedStatement(conn, sqlStatement);
            PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
            preparedStatement.setInt(1, reportContactID);
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

                Data.addAppointmentByContact(appointment);
            }
        }
        catch(SQLException exception) {
                exception.printStackTrace();
        }
    }
}
