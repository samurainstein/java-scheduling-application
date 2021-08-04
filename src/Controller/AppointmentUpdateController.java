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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AppointmentUpdateController implements Initializable {

    @FXML
    private TextField idTF;
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
        contactCombo.setItems(Data.getAllContacts());
        
        UserDAO.selectUsers();
        userCombo.setItems(Data.getAllUsers());
        
        CustomerDAO.selectCustomers();
        customerCombo.setItems(Data.getAllCustomers());
        
        DateAndTime.setAppointmentTimes();
        DateAndTime.convertAppointmentTimes();
        startTimeCombo.setItems(DateAndTime.getConvertedStartTimes());
    }    
    
    
    public void passAppointmentData(Appointment appointment) {
        idTF.setText(Integer.toString(appointment.getAppointmentID()));
        titleTF.setText(appointment.getTitle());
        descriptionTA.setText(appointment.getDescription());
        
        int contactID = appointment.getContactID();
        contactCombo.setValue(Data.getContactObject(contactID));
        
        locationTF.setText(appointment.getLocation());
        typeTF.setText(appointment.getType());
        
        LocalDateTime start = appointment.getStart();
        LocalDate startDate = start.toLocalDate();
        LocalTime startTime = start.toLocalTime();
        startDatePick.setValue(startDate);
        startTimeCombo.setValue(startTime);
        
        LocalDateTime end = appointment.getEnd();
        LocalDate endDate = end.toLocalDate();
        LocalTime endTime = end.toLocalTime();
        endDatePick.setValue(endDate);
        endTimeCombo.setValue(endTime);
        
        int customerID = appointment.getCustomerID();
        customerCombo.setValue(Data.getCustomerObject(customerID));
        
        int userID = appointment.getUserID();
        userCombo.setValue(Data.getUserObject(userID));
    }
    

    @FXML
    private void onSelectStartDate(ActionEvent event) {
        endDatePick.setValue(startDatePick.getValue());
    }

    @FXML
    private void onSelectStartTime(ActionEvent event) {
        endTimeCombo.setItems(DateAndTime.getConvertedEndTimes(startTimeCombo.getSelectionModel().getSelectedItem()));
    }

    @FXML
    private void onSave(ActionEvent event) throws SQLException, IOException {
        try {
            int appointmentID = Integer.parseInt(idTF.getText());
            String title = titleTF.getText();
            String description = descriptionTA.getText();
            String location = locationTF.getText();
            String type = typeTF.getText();

            LocalDate startDate = startDatePick.getValue();
            LocalTime startTime = startTimeCombo.getValue();
            LocalDateTime start = LocalDateTime.of(startDate, startTime);

            LocalDate endDate = endDatePick.getValue();
            LocalTime endTime = endTimeCombo.getValue();
            LocalDateTime end = LocalDateTime.of(endDate, endTime);

            int customerID = customerCombo.getValue().getCustomerID();
            int userID = userCombo.getValue().getUserID();
            int contactID = contactCombo.getValue().getContactID();

            AppointmentDAO.updateAppointment(appointmentID, title, description, location, type, start, end, customerID, userID, contactID);

            Parent root = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Appointments");
            stage.show();
        }
        catch(SQLException exception) {
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
}
