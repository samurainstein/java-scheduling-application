/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CountryDAO;
import DAO.CustomerDAO;
import Model.Country;
import Model.Customer;
import Model.Data;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class CustomersController implements Initializable {

    @FXML
    private TableColumn<Customer, Integer> custIDCol;
    @FXML
    private TableColumn<Customer, String> custNameCol;
    @FXML
    private TableColumn<Customer, String> custPhoneCol;
    @FXML
    private TableColumn<Customer, String> custAddressCol;
    @FXML
    private TableColumn<Customer, String> custPostalCol;
    @FXML
    private TableColumn<Customer, String> custDivisionCol;
    @FXML
    private TableColumn<Customer, String> custCountryCol;
    @FXML
    private TableView<Customer> custTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        custIDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        custNameCol.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        custPhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        custAddressCol.setCellValueFactory(new PropertyValueFactory<>("CustomerAddress"));
        custPostalCol.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
        custDivisionCol.setCellValueFactory(new PropertyValueFactory<>("Division"));
        custCountryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
        CustomerDAO.selectCustomers();
        custTable.setItems(Data.getAllCustomers());
    }    
    
}
