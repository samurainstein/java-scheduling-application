/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utilities.DBConnection;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Locale;
import java.util.TimeZone;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

    /**
     * This class creates a schedule management application. 
     * @author Eric Matelyan
     */
public class SchedulingApplication extends Application {
        
    /**
     * This is the main method.This is the first method that runs when you run the program.
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBConnection.startConnection();
        Connection conn = DBConnection.getConnection();

        //Locale.setDefault(new Locale("fr"));  
        //TimeZone.setDefault(TimeZone.getTimeZone("Japan"));
        
        launch(args);
        DBConnection.closeConnection();
    }
    
    /**
     * Overrides start() method.Loads the first screen of the application.  
     * @param stage
     * @throws java.lang.Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        if(Locale.getDefault().getLanguage().equals("fr")){
            stage.setTitle("Utilisateur en ligne");
        }
        else {
            stage.setTitle("User Login");
        }
        stage.show();
    }
}
