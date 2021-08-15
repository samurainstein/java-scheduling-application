/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.CustomerDAO;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class contains various data that is pulled from the database or individually defined, as well as methods for retrieving and manipulating the data.  
 * @author Eric Matelyan
 */
public abstract class Data {
    
    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
    private static ObservableList<Country> allCountries = FXCollections.observableArrayList();
    private static ObservableList<Division> allDivisions = FXCollections.observableArrayList();
    private static ObservableList<Division> filteredDivisions = FXCollections.observableArrayList();//add to UML
    private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
    private static ObservableList<Appointment> monthlyAppointments = FXCollections.observableArrayList();
    private static ObservableList<Appointment> weeklyAppointments = FXCollections.observableArrayList();
    private static ObservableList<Contact> allContacts = FXCollections.observableArrayList();
    private static ObservableList<User> allUsers = FXCollections.observableArrayList();
    private static ObservableList<ZonedDateTime> zonedAppointmentTimes = FXCollections.observableArrayList();
    private static ObservableList<LocalTime> appointmentTimes = FXCollections.observableArrayList();
    private static ObservableList<Appointment> userAppointments = FXCollections.observableArrayList();
    private static ObservableList<Appointment> customerAppointments = FXCollections.observableArrayList();
    private static ObservableList<String> appointmentTypes = FXCollections.observableArrayList();
    private static ObservableList<Appointment> appointmentsByContact = FXCollections.observableArrayList();
    private static ObservableList<Customer> customersByCountry = FXCollections.observableArrayList();
    private static int loggedInUserID;
    
    /**
     * Method for returning a list of all customers. 
     * @return Returns an observable list of all customers
     */
    public static ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }
    
    /**
     * Method for adding a customer to the list of all customers. 
     * @param customer Customer to be added
     */
    public static void addCustomer(Customer customer) {
        allCustomers.add(customer);
    }
     
    /**
     * Method for clearing the the list of all customers. 
     */
    public static void clearCustomers() { //add to uml
        allCustomers.clear();
    }
    
    /**
     * Method for returning a list of all customers in a specific country. 
     * @return Returns an observable list of all customers in a specific country
     */
    public static ObservableList<Customer> getCustomersByCountry() {
        return customersByCountry;
    }
    
    /**
     * Method for adding a customer to the list country specific customers. 
     * @param customer Customer to be added
     */
    public static void addCustomerByCountry(Customer customer) {
        customersByCountry.add(customer);
    }
     
    /**
     * Method for clearing the the list of country specific customers. 
     */
    public static void clearCustomersByCountry() { //add to uml
        customersByCountry.clear();
    }
    
    /**
     * Method for returning a list of all countries. 
     * @return Returns an observable list of all countries
     */
    public static ObservableList<Country> getAllCountries() {
        return allCountries;
    }
    
    /**
     * Method for adding a country to the list of all countries. 
     * @param country Country to be added
     */
    public static void addCountry(Country country) {
        allCountries.add(country);
    }
    
    /**
     * Method for clearing the the list of all countries. 
     */
    public static void clearCountries() { //add to uml
        allCountries.clear();
    }
    
    /**
     * Method for returning a list of all divisions. 
     * @return Returns an observable list of all divisions
     */
    public static ObservableList<Division> getAllDivisions() {
        return allDivisions;
    }
    
    /**
     * Method for adding a division to the list of all divisions. 
     * @param division Division to be added
     */
    public static void addDivision(Division division) {
        allDivisions.add(division);
    }
    
    /**
     * Method for clearing the list of all divisions. 
     */
    public static void clearDivisions() {
        allDivisions.clear();
    }
    
    /**
     * Method for returning a list of country specific divisions. 
     * @return Returns an observable list of country specific divisions
     */
    public static ObservableList<Division> getFilteredDivisions() {
        return filteredDivisions;
    }
    
    /**
     * Method for adding a division to the list of country specific divisions. 
     * @param division Division to be added
     */
    public static void addFilteredDivision(Division division) {
        filteredDivisions.add(division);
    }
       
    /**
     * Method for clearing the list of country specific divisions. 
     */
    public static void clearFilteredDivisions() { //add to uml
        filteredDivisions.clear();
    }
    
    /**
     * Method for returning a list of all appointments. 
     * @return Returns an observable list of appointments
     */
    public static ObservableList<Appointment> getAllAppointments() {
        return allAppointments;
    }
    
    /**
     * Method for adding an appointment to the list of all appointments. 
     * @param appointment Appointment to be added
     */
    public static void addAppointment(Appointment appointment) {
        allAppointments.add(appointment);        
    }
    
    /**
     * Method for clearing the list of all appointments. 
     */
    public static void clearAppointments() {
        allAppointments.clear();
    }
    
    /**
     * Method for filtering all appointments in the current month. 
     */
    public static void filterMonthlyAppointments() {
        LocalDate today = LocalDate.now();
        int monthOfYear = today.getMonthValue();
        for(Appointment appointment : allAppointments) {
            if(appointment.getStart().getMonthValue() == monthOfYear)
                monthlyAppointments.add(appointment);
        }
    }
    
    /**
     * Method for returning a list of appointments in the current month. 
     * @return Returns an observable list of appointments in the current month
     */
    public static ObservableList<Appointment> getMonthlyAppointments() {
        return monthlyAppointments;
    }
    
    /**
     * Method for clearing the list of appointments in the current month. 
     */
    public static void clearMonthlyAppointments() {
        monthlyAppointments.clear();
    }
    
    /**
     * Method for filtering all appointments in the current week. 
     */
    public static void filterWeeklyAppointments() {
        LocalDate startDate = LocalDate.now(); 
        DayOfWeek dayOfWeek = startDate.getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY:
                return;
            case TUESDAY:
                startDate = startDate.minusDays(1);
                break;
            case WEDNESDAY:
                startDate = startDate.minusDays(2);
                break;
            case THURSDAY:
                startDate = startDate.minusDays(3);
                break;
            case FRIDAY:
                startDate = startDate.minusDays(4);
                break;
            case SATURDAY:
                startDate = startDate.minusDays(5);
                break;
            case SUNDAY:
                startDate = startDate.minusDays(6);
                break;
            default:
                break;
        }
        
        LocalDate endDate = startDate.plusDays(6);
        for(Appointment appointment : allAppointments) {
            LocalDate appointmentDate = appointment.getStart().toLocalDate();
            if((appointmentDate.isEqual(startDate) || appointmentDate.isAfter(startDate)) && 
                (appointmentDate.isEqual(endDate) || appointmentDate.isBefore(endDate)))
                weeklyAppointments.add(appointment);
                }
    }
    
    /**
     * Method for returning a list of appointments in the current week. 
     * @return Returns an observable list of appointments in the current week
     */
    public static ObservableList<Appointment> getWeeklyAppointments() {
        return weeklyAppointments;
    }
    
    /**
     * Method for clearing the list of appointments in the current week. 
     */
    public static void clearWeeklyAppointments() {
        weeklyAppointments.clear();
    }
    
    /**
     * Method for returning a list of all contacts. 
     * @return Returns an observable list of all contacts
     */
    public static ObservableList<Contact> getAllContacts() {
        return allContacts;
    }
    
    /**
     * Method for adding a contact to the list of all contacts. 
     * @param contact Contact to be added
     */
    public static void addContact(Contact contact) {
        allContacts.add(contact);
    }
    
    /**
     * Method for clearing the list of all contacts. 
     */
    public static void clearContacts() {
        allContacts.clear();
    }
    
    /**
     * Method for returning a list of all users. 
     * @return Returns an observable list of all users
     */
    public static ObservableList<User> getAllUsers() {
        return allUsers;
    }
    
    /**
     * Method for adding a user to the list of all users. 
     * @param user User to be added
     */
    public static void addUser(User user) {
        allUsers.add(user);
    }
    
    /**
     * Method for clearing the list of all users. 
     */
    public static void clearUsers() {
        allUsers.clear();
    }
    
    /**
     * Method for returning a list of all EST business hour appointment times. 
     * @return Returns an observable list of EST business hour appointment times
     */
    public static ObservableList<ZonedDateTime> getAllAppointmentTimes() {
        return zonedAppointmentTimes;
    }
    
    /**
     * Method for adding an appointment time to the list of appointment times. 
     * @param appointmentTime Appointment time to be added
     */
    public static void addAppointmentTime(ZonedDateTime appointmentTime) {
        zonedAppointmentTimes.add(appointmentTime);
    }
    
    /**
     * Method for clearing the list of appointment times.  
     */
    public static void clearAppointmentTimes() {
        zonedAppointmentTimes.clear();
    }
    
    /**
     * Method for returning a contact object from the list of all contacts by contact ID. 
     * @param contactID Contact ID to be searched
     * @return Returns a contact object
     */
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
    
    /**
     * Method for returning a customer object from the list of all customers by customer ID. 
     * @param customerID Customer ID to be searched
     * @return Returns a customer object
     */
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
    
    /**
     * Method for returning a user object from the list of all users by user ID. 
     * @param userID User ID to be searched
     * @return Returns a user object
     */
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
    
    /**
     * Method for returning a list of appointments that are associated with a specific user ID. 
     * @param userID User ID to be searched
     * @return Returns an observable list of appointments
     */
    public static ObservableList<Appointment> getUserAppointments(int userID) {
        for(Appointment appointment : allAppointments) {
            if(appointment.getUserID() == userID)
                userAppointments.add(appointment);
        }
        return userAppointments;
    }
    
    /**
     * Method for clearing the list of user specific appointments. 
     */
    public static void clearUserAppointments() {
        userAppointments.clear();
    }
    
    /**
     * Method for setting the currently logged in user ID. 
     * @param userID User ID to set
     */
    public static void setLoggedInUserID(int userID) {
        loggedInUserID = userID;
    }
    
    /**
     * Method for returning the currently logged in user ID. 
     * @return Returns a user ID
     */
    public static int getLoggedInUserID() {
        return loggedInUserID;
    }
    
    /**
     * Method for returning a list of all types of appointments in the database. 
     * @return Returns an observable list of all appointment types
     */
    public static ObservableList<String> getAllTypes() {
        return appointmentTypes;
    }
    
    /**
     * Method for adding a type to the list of all appointment types. 
     * @param type Type of appointment to add
     */
    public static void addType(String type) {
        appointmentTypes.add(type);
    }
    
    /**
     * Method for clearing the list of all appointment types. 
     */
    public static void clearTypes() {
        appointmentTypes.clear();
    }
    
    /**
     * Method for checking if any appointments are associated with a specific customer ID. 
     * @param customerID Customer ID to check
     * @return Returns a boolean of whether any appointments are associated with the customer ID
     */
    public static boolean checkAssociatedAppointments(int customerID) {
        boolean associated = false;
        for(Appointment appointment : allAppointments) {
            if(associated == true) {
                break;
            }
            if(appointment.getCustomerID() == customerID) {
                associated = true;
            }
        }
        
        return associated;
    }
    
    /**
     * Method for checking if a new or updated customer appointment conflicts with another appointment of the same user. 
     * @param customerID Customer ID to be checked
     * @param startTime Start time of new or updated appointment
     * @param endTime End time of new or updated appointment
     * @param startDate Start date of appointment
     * @return Returns a boolean of whether or not the new or updated appointment conflicts with another appointment
     */
    public static boolean checkOverlap(int customerID, LocalTime startTime, LocalTime endTime, LocalDate startDate) {
        boolean overlap = false;
        customerAppointments.clear();
        for(Appointment appointment : allAppointments) {
            if(appointment.getCustomerID() == customerID) {
                customerAppointments.add(appointment);
            }
        }
        for(Appointment appointment : customerAppointments) {
            if(overlap == true) {
                break;
            }
            LocalTime custStartTime = appointment.getStart().toLocalTime();
            LocalTime custEndTime = appointment.getEnd().toLocalTime();
            LocalDate custStartDate = appointment.getStart().toLocalDate();
            if(custStartDate.equals(startDate)) {
                System.out.println("dates match");
                if(startTime.equals(custStartTime)  || endTime.equals(custEndTime)) {
                    System.out.println("if(startTime.equals(custStartTime)  || endTime.equals(custEndTime)) OVERLAP!");
                    overlap = true;  
                }
                else if(startTime.isAfter(custStartTime) && startTime.isBefore(custEndTime)) /*&& endTime.equals(custEndTime))*/  {
                    System.out.println("if(startTime.isAfter(custStartTime) && startTime.isBefore(custEndTime)) OVERLAP!");
                    overlap = true;
                }
                else if(endTime.isAfter(custStartTime) && endTime.isBefore(custEndTime)) {
                    System.out.println("if(endTime.isAfter(custStartTime) && endTime.isBefore(custEndTime)) OVERLAP!");
                    overlap = true;
                }
                else {
                    System.out.println("NO OVERLAP!"); 
                    overlap = false;
                }
            }
        }             
        return overlap;
    }
    
    /**
     * Method for returning a list of appointments with a specific contact. 
     * @return Returns an observable list of contact specific appointments
     */
    public static ObservableList<Appointment> getAppointmentsByContact() {
        return appointmentsByContact;
    }
    
    /**
     * Method for adding an appointment to the list of contact specific appointments. 
     * @param appointment Appointment to be added
     */
    public static void addAppointmentByContact(Appointment appointment) {
        appointmentsByContact.add(appointment);
    }
    
    /**
     * Method for clearing the list of contact specific appointments. 
     */
    public static void clearAppointmentsByContact() {
        appointmentsByContact.clear();
    }
}
