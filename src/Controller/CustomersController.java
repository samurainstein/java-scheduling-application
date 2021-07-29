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
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
        //FIX THIS - How do I stop initialize from running everytime?
        //custTable.getItems().clear();
        //Data.clearCustomers();
        CustomerDAO.selectCustomers();
        custTable.setItems(Data.getAllCustomers());
    }    

    @FXML
    private void onAddCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CustomerAdd.fxml"));
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Customer");
        stage.show();
    }

    @FXML
    private void onDelete(ActionEvent event) {
        Customer customer = custTable.getSelectionModel().getSelectedItem();
        int customerID = customer.getCustomerID();
        if (customer == null){
                JOptionPane.showMessageDialog(null, "Please Select a Customer");
                return;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this customer?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) { 
                CustomerDAO.deleteCustomer(customerID);
                //FIX THIS: How to refresh the table after delete?
                //Data.clearCustomers();
                //CustomerDAO.selectCustomers();
                custTable.setItems(Data.getAllCustomers());
                JOptionPane.showMessageDialog(null, "Selected customer was deleted");
            }
        //else {
        //    JOptionPane.showMessageDialog(null, "No parts were deleted");
        //}          
        }
        /*
        if (customer == null){
            Alert invalidAlert = new Alert(Alert.AlertType.ERROR);
            invalidAlert.setTitle("Invalid Selection");
            invalidAlert.setContentText("Please select a customer");
            invalidAlert.showAndWait();
            return;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this customer?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) { 
                CustomerDAO.deleteCustomer(customerID);
                Alert confirmAlert = new Alert(Alert.AlertType.INFORMATION);
                confirmAlert.setTitle("Confirmation");
                confirmAlert.setContentText("Customer was deleted");
                confirmAlert.showAndWait();
            }
        }
        
            else  {
            Alert confirmAlert = new Alert(Alert.AlertType.INFORMATION);
            confirmAlert.setTitle("Confirmation");
            confirmAlert.setContentText("Customer was deleted");
            confirmAlert.showAndWait();
            }         
        }*/
        
    }

    @FXML
    private void onUpdate(ActionEvent event) {
    }

    @FXML
    private void onHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }
    
}
