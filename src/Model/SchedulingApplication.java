/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utilities.DBConnection;
import Utilities.DBQuery;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eric
 */
public class SchedulingApplication extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBConnection.startConnection();
        Connection conn = DBConnection.getConnection();
        
        ResourceBundle rb = ResourceBundle.getBundle("/Utilities/RB", Locale.getDefault());
        if(Locale.getDefault().getLanguage().equals("ja"))
            System.out.println(rb.getString("hello") + " " + rb.getStringArray("world"));
        
        String selectStatement = "SELECT * FROM countries;";
        
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement preparedStatement = DBQuery.getPreparedStatement();
        
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while(resultSet.next()) {
            int countryID = resultSet.getInt("Country_ID");
            String countryName = resultSet.getString("Country");
            LocalDate date = resultSet.getDate("Create_Date").toLocalDate();
            LocalTime time = resultSet.getTime("Create_Date").toLocalTime();
            String createdBy = resultSet.getString("Created_By");
            LocalDateTime lastUpdate = resultSet.getTimestamp("Last_Update").toLocalDateTime();

            System.out.println(countryID + " | " + countryName + " | " + date + " | " + time + " | " + createdBy + " | " + lastUpdate);
            }
        
        launch(args);
        DBConnection.closeConnection();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/SchedulingApplication.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Scheduling Application");
        stage.show();
    }
}
