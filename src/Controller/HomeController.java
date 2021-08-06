/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AppointmentDAO;
import Model.Appointment;
import Model.Data;
import Utilities.AppointmentAlertInterface;
import Utilities.DateAndTime;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class HomeController implements Initializable {

    @FXML
    private Label apptNoticeLabel;
    
    private int userID;
    private ObservableList<Appointment> userAppointments = FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AppointmentDAO.selectAppointments();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        Data.clearUserAppointments();
        userID = Data.getLoggedInUserID();
        System.out.println(userID);
        userAppointments = Data.getUserAppointments(userID);
        System.out.println(userAppointments.toString());
        LocalDateTime currentDateTime = LocalDateTime.now();
        currentDateTime.toString();
        LocalDateTime nowPlus15 = currentDateTime.plusMinutes(15);
        System.out.println(nowPlus15.toString());
        for(Appointment appointment : userAppointments) {
            LocalDateTime appointmentStart = appointment.getStart();
            LocalTime startTime = appointmentStart.toLocalTime();
            if(appointmentStart.isBefore(nowPlus15) && appointmentStart.isAfter(currentDateTime)) {
                String popupTitle = "Appointment Notification";
                String popupText = "You have an appointment in the next 15 minutes";
                AppointmentAlertInterface appointmentAlert = () -> {
                    Alert popup = new Alert(Alert.AlertType.INFORMATION);
                    popup.setTitle(popupTitle);
                    popup.setContentText(popupText);
                    popup.showAndWait();
                };
                appointmentAlert.displayAlert();
                apptNoticeLabel.setText("You have an upcoming appointment at " + startTime.toString());
                
            }
        }    
    }    
    /*
    public void passUserID(int userID) {
        this.userID = userID;
        System.out.println(userID);
    }
    */
    @FXML
    private void onCustomers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Customers");
        stage.show();
    }

    @FXML
    private void onAppointments(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Appointments");
        stage.show();
    }

    @FXML
    private void onReports(ActionEvent event) {
    }

    @FXML
    private void onLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("User Login");
        stage.show();
    }
    
}
