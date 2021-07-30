/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CountryDAO;
import Model.Country;
import Model.Customer;
import Model.Data;
import Model.Division;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eric
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
    
    private Customer passCustomer;
    
    public void passCustomerData(Customer customer) {
        passCustomer = customer;
        idTF.setText(Integer.toString(customer.getCustomerID()));
        nameTF.setText(customer.getCustomerName());
        phoneTF.setText(customer.getPhone());
        addressTF.setText(customer.getCustomerAddress());
        CountryDAO.selectCountries();
        countryCombo.setItems(Data.getAllCountries());
        //FIX This : How do I set the country and division combo boxes?
        //countryCombo;
        //divisionCombo;
    }

    @FXML
    private void onCountrySelection(ActionEvent event) {
    }

    @FXML
    private void onSave(ActionEvent event) {
    }

    @FXML
    private void onClear(ActionEvent event) {
    }

    @FXML
    private void onCancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Customers.fxml"));
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Customers");
        stage.show();
    }
    
}
