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
    private static int loggedInUserID;
    
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
    
    public static void filterMonthlyAppointments() {
        LocalDate today = LocalDate.now();
        int monthOfYear = today.getMonthValue();
        for(Appointment appointment : allAppointments) {
            if(appointment.getStart().getMonthValue() == monthOfYear)
                monthlyAppointments.add(appointment);
        }
    }
    
    public static ObservableList<Appointment> getMonthlyAppointments() {
        return monthlyAppointments;
    }
    
    public static void clearMonthlyAppointments() {
        monthlyAppointments.clear();
    }
    
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
    
    public static ObservableList<Appointment> getWeeklyAppointments() {
        return weeklyAppointments;
    }
    
    public static void clearWeeklyAppointments() {
        weeklyAppointments.clear();
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
    
    public static ObservableList<Appointment> getUserAppointments(int userID) {
        for(Appointment appointment : allAppointments) {
            if(appointment.getUserID() == userID)
                addUserAppointment(appointment);
        }
        return userAppointments;
    }
    
    public static void addUserAppointment(Appointment appointment) {
        userAppointments.add(appointment);
    }
    
    public static void clearUserAppointments() {
        userAppointments.clear();
    }
    
    public static void setLoggedInUserID(int userID) {
        loggedInUserID = userID;
    }
    
    public static int getLoggedInUserID() {
        return loggedInUserID;
    }
    
    public static ObservableList<String> getAllTypes() {
        return appointmentTypes;
    }
    
    public static void addType(String type) {
        appointmentTypes.add(type);
    }
    
    public static void clearTypes() {
        appointmentTypes.clear();
    }
    
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
    
    public static ObservableList<Appointment> getAppointmentsByContact() {
        return appointmentsByContact;
    }
    
    public static void addAppointmentByContact(Appointment appointment) {
        appointmentsByContact.add(appointment);
    }
    
    public static void clearAppointmentsByContact() {
        appointmentsByContact.clear();
    }
}
