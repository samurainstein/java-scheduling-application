/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Appointment;
import Model.Contact;
import Model.Customer;
import Model.User;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
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
        // TODO
    }    
    
    
    public void passAppointmentData(Appointment appointment) {
        idTF.setText(Integer.toString(appointment.getAppointmentID()));
        titleTF.setText(appointment.getTitle());
        descriptionTA.setText(appointment.getDescription());
        //contactCombo.setValue(arg0);
        locationTF.setText(appointment.getLocation());
        typeTF.setText(appointment.getType());
        //startDatePick.setValue();
        //startTimeCombo.setValue();
        //endDatePick.setValue();
        //endTimeCombo.setValue();
        //customerCombo.setValue(arg0);
        //userCombo.setValue(arg0);

        /*
        ObservableList<Division> allDivisions = FXCollections.observableArrayList();
        ObservableList<Division> filteredDivisions = FXCollections.observableArrayList();
        DivisionDAO.selectDivisions();
        allDivisions = Data.getAllDivisions();
        for(Division div : allDivisions) {
            if(divisionName.equals(div.getDivisionName())) {
                countryID = div.getCountryID();
                DivisionDAO.selectFilteredDivisions(countryID);
                filteredDivisions = Data.getFilteredDivisions();
                divisionCombo.setItems(filteredDivisions);
                divisionCombo.setValue(div);
                break;
            }
        }
        
        ObservableList<Country> allCountries = FXCollections.observableArrayList();
        CountryDAO.selectCountries();
        allCountries = Data.getAllCountries();
        countryCombo.setItems(allCountries);
        for(Country country : allCountries) {
            if(countryID == country.getCountryID()) {               
                countryCombo.setValue(country);
            }
        }*/
    }
    

    @FXML
    private void onSelectStartDate(ActionEvent event) {
    }

    @FXML
    private void onSelectStartTime(ActionEvent event) {
    }

    @FXML
    private void onSave(ActionEvent event) {
    }

    @FXML
    private void onClear(ActionEvent event) {
    }

    @FXML
    private void onCancel(ActionEvent event) throws IOException {
        
    } 
}
