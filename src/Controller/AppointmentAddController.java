/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AppointmentDAO;
import DAO.ContactDAO;
import DAO.CustomerDAO;
import DAO.UserDAO;
import Model.Appointment;
import Model.Contact;
import Model.Customer;
import Model.Data;
import Model.User;
import Utilities.DateAndTime;
import static Utilities.DateAndTime.convertAppointmentTimes;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class AppointmentAddController implements Initializable {

    @FXML
    private TextField titleTF;
    @FXML
    private TextArea descriptionTA;
    @FXML
    private ComboBox<Contact> contactCombo;
    @FXML
    private TextField locationTF;
    @FXML
    private TextField typeTF;
    @FXML
    private DatePicker startDatePick;
    @FXML
    private ComboBox<LocalTime> startTimeCombo;
    @FXML
    private DatePicker endDatePick;
    @FXML
    private ComboBox<LocalTime> endTimeCombo;
    @FXML
    private ComboBox<Customer> customerCombo;
    @FXML
    private ComboBox<User> userCombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ContactDAO.selectContacts();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        CustomerDAO.selectCustomers();
        UserDAO.selectUsers();
        
        contactCombo.setItems(Data.getAllContacts());
        contactCombo.setPromptText("Select a Contact");
        customerCombo.setItems(Data.getAllCustomers());
        customerCombo.setPromptText("Select a Customer");
        userCombo.setItems(Data.getAllUsers());
        userCombo.setPromptText("Select a User");
   
        DateAndTime.setAppointmentTimes();
        DateAndTime.convertAppointmentTimes();
        startTimeCombo.setItems(DateAndTime.getConvertedStartTimes());  
        startTimeCombo.setPromptText("Select a start time");
    }    

    @FXML
    private void onSave(ActionEvent event) throws IOException {
        //FIX THIS:
        try {
            String title = titleTF.getText();
            String description = descriptionTA.getText();
            String location = locationTF.getText();
            String type = typeTF.getText();
            LocalDate startDate = startDatePick.getValue();
            LocalTime startTime = startTimeCombo.getValue();
            LocalDate endDate = endDatePick.getValue();
            LocalTime endTime = endTimeCombo.getValue();
            LocalDateTime start = LocalDateTime.of(startDate, startTime);
            LocalDateTime end = LocalDateTime.of(endDate, endTime);
            int customerID = customerCombo.getValue().getCustomerID();
            int contactID = contactCombo.getValue().getContactID();
            int userID = userCombo.getValue().getUserID();

            AppointmentDAO.insertAppointment(title, description, location, type, start, end, customerID, contactID, userID);

            Parent root = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Appointments");
            stage.setScene(scene);
            stage.show();

        }
        catch(Exception exception) {
            exception.printStackTrace();
        }

    }

    @FXML
    private void onClear(ActionEvent event) {
    }

    @FXML
    private void onCancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Appointments");
        stage.show();
        
    }

    @FXML
    private void onSelectStartTime(ActionEvent event) {
        endTimeCombo.setItems(DateAndTime.getConvertedEndTimes(startTimeCombo.getSelectionModel().getSelectedItem()));
        endTimeCombo.setPromptText("Select an end time");
    }

    @FXML
    private void onSelectStartDate(ActionEvent event) {
        endDatePick.setValue(startDatePick.getValue());
    }
    
}
