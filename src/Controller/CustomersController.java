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
                //FIX THIS: Do I need a confirmation that it was actually deleted from the db?
                CustomerDAO.deleteCustomer(customerID);
                CustomerDAO.selectCustomers();
                custTable.setItems(Data.getAllCustomers());
                Alert confirmAlert = new Alert(Alert.AlertType.INFORMATION);
                confirmAlert.setTitle("Confirmation");
                confirmAlert.setContentText("Customer was deleted");
                confirmAlert.showAndWait();
            }
        }    
    }

    @FXML
    private void onUpdate(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CustomerUpdate.fxml"));
            Parent root = loader.load();
            CustomerUpdateController updateCont = loader.getController();
            updateCont.passCustomerData(custTable.getSelectionModel().getSelectedItem());
            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Update Customer");
            stage.setScene(scene);
            stage.show();
        }
        catch(NullPointerException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Selection");
            alert.setContentText("Please select a customer");
            alert.showAndWait();
        }
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
