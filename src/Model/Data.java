/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.CustomerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Eric
 */
public abstract class Data {
    //Members
    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
    private static ObservableList<Country> allCountries = FXCollections.observableArrayList();
    private static ObservableList<Division> allDivisions = FXCollections.observableArrayList();
    private static ObservableList<Division> filteredDivisions = FXCollections.observableArrayList();//add to UML
    
    //Methods
    public static ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }
    
    public static void addCustomer(Customer customer) {
        allCustomers.add(customer);
    }
     
    public static void clearCustomers() {
        allCustomers.clear();
    }
    
    public static ObservableList<Country> getAllCountries() {
        return allCountries;
    }
    
    public static void addCountry(Country country) {
        allCountries.add(country);
    }
    
    public static ObservableList<Division> getAllDivisions() {
        return allDivisions;
    }
    
    public static ObservableList<Division> getFilteredDivisions() { //add to uml
        return filteredDivisions;
    }
    
    public static void addDivision(Division division) {
        allDivisions.add(division);
    }
    
    public static void addFilteredDivision(Division division) { //add to uml
        filteredDivisions.add(division);
    }
}
