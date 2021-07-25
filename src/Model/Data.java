/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Eric
 */
public class Data {
    //Members
    private ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
    
    //Methods
    public ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }
    
    public void addCustomer(Customer customer) {
        allCustomers.add(customer);
    }
}
