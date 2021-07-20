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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        DBQuery.setStatement(conn);
        Statement statement = DBQuery.getStatement();
        
        String country, createDate, createdBy, lastUpdateBy;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a country: ");
        country = keyboard.nextLine();
        createDate = "2020-07-20 00:00:00";
        createdBy = "admin";
        lastUpdateBy = "admin";
        
        String insertStatement =    "INSERT INTO countries(Country, Create_Date, Created_By, Last_Updated_By)"
                                    + "VALUES(" +
                                    "'" + country + "'," +
                                    "'" + createDate + "'," +
                                    "'" + createdBy + "'," +
                                    "'" + lastUpdateBy + "');";
        try {
            statement.execute(insertStatement);
            if(statement.getUpdateCount() > 0) {
                System.out.println(statement.getUpdateCount() + "row(s) affected");
            }
            else {
                System.out.println("No change");
            }
        }
        catch(SQLException exception) {
            System.out.println(exception.getMessage());
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
