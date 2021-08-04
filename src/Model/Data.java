/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.CustomerDAO;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
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
    private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
    private static ObservableList<Contact> allContacts = FXCollections.observableArrayList();
    private static ObservableList<User> allUsers = FXCollections.observableArrayList();
    private static ObservableList<ZonedDateTime> zonedAppointmentTimes = FXCollections.observableArrayList();
    private static ObservableList<LocalTime> appointmentTimes = FXCollections.observableArrayList();
     
    
    //Methods
    public static ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }
    
    public static void addCustomer(Customer customer) {
        allCustomers.add(customer);
    }
     
    public static void clearCustomers() { //add to uml
        allCustomers.clear();
    }
    
    public static ObservableList<Country> getAllCountries() {
        return allCountries;
    }
    
    public static void addCountry(Country country) {
        allCountries.add(country);
    }
    
    public static void clearCountries() { //add to uml
        allCountries.clear();
    }
    
    public static ObservableList<Division> getAllDivisions() {
        return allDivisions;
    }
    
    public static void addDivision(Division division) {
        allDivisions.add(division);
    }
    
    public static void clearDivisions() { //add to uml
        allDivisions.clear();
    }
    
    public static ObservableList<Division> getFilteredDivisions() { //add to uml
        return filteredDivisions;
    }
    
    public static void addFilteredDivision(Division division) { //add to uml
        filteredDivisions.add(division);
    }
       
    public static void clearFilteredDivisions() { //add to uml
        filteredDivisions.clear();
    }
    
    public static ObservableList<Appointment> getAllAppointments() {
        return allAppointments;
    }
    
    public static void addAppointment(Appointment appointment) {
        allAppointments.add(appointment);        
    }
    
    public static void clearAppointments() {
        allAppointments.clear();
    }
    
    public static ObservableList<Contact> getAllContacts() {
        return allContacts;
    }
    
    public static void addContact(Contact contact) {
        allContacts.add(contact);
    }
    
    public static void clearContacts() {
        allContacts.clear();
    }
    
    public static ObservableList<User> getAllUsers() {
        return allUsers;
    }
    
    public static void addUser(User user) {
        allUsers.add(user);
    }
    
    public static void clearUsers() {
        allUsers.clear();
    }
    
    public static ObservableList<ZonedDateTime> getAllAppointmentTimes() {
        return zonedAppointmentTimes;
    }
    
    public static void addAppointmentTime(ZonedDateTime appointmentTime) {
        zonedAppointmentTimes.add(appointmentTime);
    }
    
    public static void clearAppointmentTimes() {
        zonedAppointmentTimes.clear();
    }
    
    public static Contact getContactObject(int contactID) {
        Contact contactObject = null;
        for(Contact contact : allContacts) {
            if(contact.getContactID() == contactID) {
                contactObject = contact;
                break;
            }
        }
        return contactObject;
    }
    
    public static Customer getCustomerObject(int customerID) {
        Customer customerObject = null;
        for(Customer customer : allCustomers) {
            if(customer.getCustomerID() == customerID) {
                customerObject = customer;
                break;
            }
        }
        return customerObject;
    }
    
    public static User getUserObject(int userID) {
        User userObject = null;
        for(User user : allUsers) {
            if(user.getUserID() == userID) {
                userObject = user;
                break;
            }
        }
        return userObject;
    }
}
