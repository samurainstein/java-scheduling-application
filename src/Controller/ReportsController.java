/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AppointmentDAO;
import DAO.ContactDAO;
import DAO.CountryDAO;
import DAO.CustomerDAO;
import Model.Data;
import Model.Contact;
import Model.Country;
import Model.Customer;
import Model.Appointment;
import Utilities.DateAndTime;
import Utilities.PageLoader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class handles events on the Reports screen
 * @author Eric Matelyan
 */
public class ReportsController implements Initializable {

    @FXML
    private ComboBox<String> typeCombo;
    @FXML
    private ComboBox<Month> monthCombo;
    @FXML
    private Button runButton;
    @FXML
    private Label numberLabel;
    @FXML
    private TableView<Appointment> contactTable;
    @FXML
    private TableColumn<Appointment, Integer> apptIDCol;
    @FXML
    private TableColumn<Appointment, String> titleCol;
    @FXML
    private TableColumn<Appointment, String> typeCol;
    @FXML
    private TableColumn<Appointment, String> descriptionCol;
    @FXML
    private TableColumn<Appointment, LocalDateTime> startCol;
    @FXML
    private TableColumn<Appointment, LocalDateTime> endCol;
    @FXML
    private TableColumn<Appointment, Integer> custIDCol;
    @FXML
    private ComboBox<Contact> contactCombo;
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer, Integer> custIDCol2;
    @FXML
    private TableColumn<Customer, String> custNameCol;
    @FXML
    private TableColumn<Customer, String> addressCol;
    @FXML
    private TableColumn<Customer, String> postalCol;
    @FXML
    private TableColumn<Customer, String> divisionCol;
    @FXML
    private ComboBox<Country> countryCombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        
        monthCombo.setItems(DateAndTime.getAllMonths());
        try {
            AppointmentDAO.selectAppointmentTypes();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        typeCombo.setItems(Data.getAllTypes());
    }    
    
    @FXML
    private void onRun(ActionEvent event) throws SQLException {
        String type = typeCombo.getSelectionModel().getSelectedItem();
        Month month = monthCombo.getSelectionModel().getSelectedItem();
        LocalDateTime startLDT = DateAndTime.getMonthStart(month);
        LocalDateTime endLDT = DateAndTime.getMonthEnd(month);    
        int total = AppointmentDAO.getCustomerReport(type, startLDT, endLDT);
        numberLabel.setText(String.valueOf(total));
    }

    @FXML
    private void onCancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("/view/Home.fxml")));
        String pageTitle = PageLoader.getHomeTitle();
        PageLoader.pageLoad(event, root, pageTitle);
    }

    @FXML
    private void onContactTab(Event event) throws SQLException {
        apptIDCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("Start"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("End"));
        custIDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        
        ContactDAO.selectContacts();
        contactCombo.setItems(Data.getAllContacts());
    }

    @FXML
    private void onRunContacts(ActionEvent event) {
        int contactID = contactCombo.getSelectionModel().getSelectedItem().getContactID();
        AppointmentDAO.selectAppointmentsByContact(contactID);
        contactTable.setItems(Data.getAppointmentsByContact());
    }

    @FXML
    private void onRunCustomers(ActionEvent event) {
        int countryID = countryCombo.getSelectionModel().getSelectedItem().getCountryID();
        CustomerDAO.selectCustomersByCountry(countryID);
        customerTable.setItems(Data.getCustomersByCountry());
    }

    @FXML
    private void onCustByCtryTab(Event event) {
        custIDCol2.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        custNameCol.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("CustomerAddress"));
        postalCol.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
        divisionCol.setCellValueFactory(new PropertyValueFactory<>("Division"));
        
        CountryDAO.selectCountries();
        countryCombo.setItems(Data.getAllCountries());
    }
}
