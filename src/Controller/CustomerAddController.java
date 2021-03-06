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
import Model.Data;
import Model.Division;
import Utilities.Alerts;
import Utilities.PageLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * This class handles events on the Add Customer screen
 * @author Eric Matelyan
 */
public class CustomerAddController implements Initializable {

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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CountryDAO.selectCountries();
        countryCombo.setItems(Data.getAllCountries());
        countryCombo.setPromptText("Select a Country");
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
            
            CustomerDAO.insertCustomer(name, address, postalCode, phone, divisionID);
            
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
        
    }
    
    @FXML
    private void onCancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        String pageTitle = PageLoader.getCustomersTitle();
        PageLoader.pageLoad(event, root, pageTitle);
    }

    @FXML
    private void onCountrySelection(ActionEvent event) {
        //Filter Division Combo Box by Country
        if(!(countryCombo.getSelectionModel().isEmpty())) {
            divisionCombo.getItems().clear();
            int countryIDSelection = countryCombo.getValue().getCountryID();
            DivisionDAO.selectFilteredDivisions(countryIDSelection);
            divisionCombo.setItems(Data.getFilteredDivisions());
            divisionCombo.setPromptText("Please Select a Division");
        }
    }
    
}
