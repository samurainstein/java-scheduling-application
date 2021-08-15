/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AppointmentDAO;
import Model.Appointment;
import Model.Data;
import Utilities.Alerts;
import Utilities.AppointmentAlertInterface;
import Utilities.DateAndTime;
import Utilities.PageLoader;
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
        userAppointments = Data.getUserAppointments(userID);
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime nowPlus15 = currentDateTime.plusMinutes(15);
        for(Appointment appointment : userAppointments) {
            LocalDateTime appointmentStart = appointment.getStart();
            LocalTime startTime = appointmentStart.toLocalTime();
            if(appointmentStart.isBefore(nowPlus15) && appointmentStart.isAfter(currentDateTime)) {
                //Lambda Expression
                AppointmentAlertInterface appointmentAlert = () -> Alerts.appointmentUpcomingAlert();
                appointmentAlert.displayAlert();
                apptNoticeLabel.setText("You have an upcoming appointment at " + startTime.toString());
                
            }
        }    
    }    

    @FXML
    private void onCustomers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        String pageTitle = PageLoader.getCustomersTitle();
        PageLoader.pageLoad(event, root, pageTitle);
    }

    @FXML
    private void onAppointments(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        String pageTitle = PageLoader.getAppointmentsTitle();;
        PageLoader.pageLoad(event, root, pageTitle);
    }

    @FXML
    private void onReports(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Reports.fxml"));
        String pageTitle = PageLoader.getReportsTitle();
        PageLoader.pageLoad(event, root, pageTitle);
    }

    @FXML
    private void onLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        String pageTitle = PageLoader.getLoginTitle();
        PageLoader.pageLoad(event, root, pageTitle);
    }
    
}
