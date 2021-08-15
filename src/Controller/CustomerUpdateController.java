/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CountryDAO;
import DAO.CustomerDAO;
import DAO.DivisionDAO;
import Model.Country;
import Model.Customer;
import Model.Data;
import Model.Division;
import Utilities.Alerts;
import Utilities.PageLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * This class handles events on the Update Customer screen
 * @author Eric Matelyan
 */
public class CustomerUpdateController implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField postalTF;
    @FXML
    private ComboBox<Country> countryCombo;
    @FXML
    private ComboBox<Division> divisionCombo;
    @FXML
    private TextField idTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void passCustomerData(Customer customer) {
        idTF.setText(Integer.toString(customer.getCustomerID()));
        nameTF.setText(customer.getCustomerName());
        phoneTF.setText(customer.getPhone());
        addressTF.setText(customer.getCustomerAddress());
        postalTF.setText(customer.getPostalCode());
        String divisionName = customer.getDivision();
        int countryID = 0;
        
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
        }
    }

    @FXML
    private void onCountrySelection(ActionEvent event) {
        if(!(countryCombo.getSelectionModel().isEmpty())) {
            divisionCombo.getItems().clear();
            int countryIDSelection = countryCombo.getValue().getCountryID();
            DivisionDAO.selectFilteredDivisions(countryIDSelection);
            divisionCombo.setItems(Data.getFilteredDivisions());
            divisionCombo.setValue(null);
            divisionCombo.setPromptText("Please Select a Division");
        }
    }

    @FXML
    private void onSave(ActionEvent event) {
        String name = nameTF.getText();
        String phone = phoneTF.getText();
        String address = addressTF.getText();
        String postalCode = postalTF.getText();
        if(name.isBlank() || phone.isBlank() || address.isBlank() || postalCode.isBlank()) {
            Alerts.invalidFields();
            return;
        }
        try {
            
            int divisionID = divisionCombo.getSelectionModel().getSelectedItem().getDivisionID();
            int customerID = Integer.parseInt(idTF.getText());
            
            CustomerDAO.updateCustomer(name, address, postalCode, phone, divisionID, customerID);
            
            Parent root = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
            String pageTitle = PageLoader.getCustomersTitle();
            PageLoader.pageLoad(event, root, pageTitle);
        }
        catch(IOException exception) {
            exception.printStackTrace();
        }
        catch(NullPointerException exception) {
            Alerts.countryOrDivisionNullAlert();
        }
    }

    @FXML
    private void onClear(ActionEvent event) {
        nameTF.setText("");
        phoneTF.setText("");
        addressTF.setText("");
        postalTF.setText("");
        countryCombo.getSelectionModel().clearSelection();
        divisionCombo.getItems().clear();
        divisionCombo.setValue(null);
    }

    @FXML
    private void onCancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        String pageTitle = PageLoader.getCustomersTitle();
        PageLoader.pageLoad(event, root, pageTitle);
    }
    
}
