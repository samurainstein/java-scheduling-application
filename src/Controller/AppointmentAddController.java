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
import Model.Contact;
import Model.Customer;
import Model.Data;
import Model.User;
import Utilities.Alerts;
import Utilities.DateAndTime;
import Utilities.PageLoader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * This class handles events on the Add Appointment screen
 * @author Eric Matelyan
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

    /**
     * Method for saving new appointment info to the database. 
     * @param event Event object created by the Save button
     */
    @FXML
    /**
     * Method for saving new appointment info to the database. 
     * @param event Event object created by the Save button
     */
    private void onSave(ActionEvent event) throws IOException {
        String title = titleTF.getText();
        String description = descriptionTA.getText();
        String location = locationTF.getText();
        String type = typeTF.getText();
        if(title.isBlank() || description.isBlank() || location.isBlank() || type.isBlank()) {
            Alerts.invalidFields();
            return;
        }
        try {
            
            LocalDate startDate = startDatePick.getValue();
            LocalTime startTime = startTimeCombo.getValue();
            LocalDate endDate = endDatePick.getValue();
            LocalTime endTime = endTimeCombo.getValue();
            LocalDateTime start = LocalDateTime.of(startDate, startTime);
            LocalDateTime end = LocalDateTime.of(endDate, endTime);
            int customerID = customerCombo.getValue().getCustomerID();
            int contactID = contactCombo.getValue().getContactID();
            int userID = userCombo.getValue().getUserID();
            
            AppointmentDAO.selectAppointments();
            Boolean overlap = Data.checkOverlap(customerID, startTime, endTime, startDate);
            if(!overlap) {

                AppointmentDAO.insertAppointment(title, description, location, type, start, end, customerID, contactID, userID);

                Parent root = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
                String pageTitle = PageLoader.getAppointmentsTitle();
                PageLoader.pageLoad(event, root, pageTitle);
            }
            else if(overlap) {
                Alerts.appointmentOverlap();
            }

        }
        catch(SQLException exception) {
            exception.printStackTrace();
        }
        catch(NullPointerException exception) {
            Alerts.invalidFields();
        }

    }

    /**
     * Method for clearing all fields and selections on the screen. 
     * @param event Event object created by the Clear button
     */
    @FXML
    private void onClear(ActionEvent event) {
        titleTF.setText("");
        descriptionTA.setText("");
        locationTF.setText("");
        typeTF.setText("");
        contactCombo.setValue(null);
        startDatePick.setValue(null);
        endDatePick.setValue(null);
        startTimeCombo.setValue(null);
        endTimeCombo.setValue(null);
        customerCombo.setValue(null);
        userCombo.setValue(null);
    }

    /**
     * Method for returning to the main appointments screen. 
     * @param event Event object created by the Cancel button
     */
    @FXML
    private void onCancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        String pageTitle = PageLoader.getAppointmentsTitle();
        PageLoader.pageLoad(event, root, pageTitle);
        
    }

    /**
     * Method for filtering out end times, based on the selected start time. 
     * @param event Event object created by selecting a start time
     */
    @FXML
    private void onSelectStartTime(ActionEvent event) {
        endTimeCombo.setItems(DateAndTime.getConvertedEndTimes(startTimeCombo.getSelectionModel().getSelectedItem()));
        endTimeCombo.setPromptText("Select an end time");
    }
    
    /**
     * Method for setting the end date to the same as the start date. 
     * @param event Event object created when the start date is selected
     */
    @FXML
    private void onSelectStartDate(ActionEvent event) {
        endDatePick.setValue(startDatePick.getValue());
    }
    
}
