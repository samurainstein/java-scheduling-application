/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDateTime;

/**
 * This class defines the attributes and methods of Appointment objects
 * @author Eric Matelyan
 */
public class Appointment {
    
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private int customerID;
    private int contactID;
    private int userID;
    private String contactName;
    
    /**
     * Constructor for Appointment objects. 
     * 
     * @param appointmentID ID number of appointment
     * @param title Title of appointment
     * @param description Description of appointment
     * @param location Location of appointment
     * @param type Type of appointment
     * @param start Start date and time of appointment
     * @param end End date and time of appointment
     * @param customerID Customer ID associated with appointment
     * @param contactID Contact ID associated with appointment
     * @param userID User ID associated with appointment
     * @param contactName Name of associated Contact ID
     */
    public Appointment(int appointmentID, String title, String description,String location, 
            String type, LocalDateTime start, LocalDateTime end, int customerID, int contactID, int userID, String contactName) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.customerID = customerID;
        this.contactID = contactID;
        this.userID = userID;
        this.contactName = contactName;
    }
    
    /**
     * Method for getting an appointment ID. 
     * @return Returns an appointment ID
     */
    public int getAppointmentID() {
        return appointmentID;
    }
    
    /**
     * Method for getting the title of an appointment. 
     * @return Returns a title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Method for getting the description of an appointment. 
     * @return Returns a description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Method for getting the location of an appointment. 
     * @return Returns a location
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * Method for getting the type of an appointment. 
     * @return Returns a type
     */
    public String getType() {
        return type;
    }
    
    /**
     * Method for getting the start date/time of an appointment. 
     * @return Returns a start date/time
     */
    public LocalDateTime getStart() {
        return start;
    }
    
    /**
     * Method for getting the end date/time of an appointment. 
     * @return Returns an end date/time
     */
    public LocalDateTime getEnd() {
        return end;
    }
    
    /**
     * Method for getting the associated customer ID of an appointment. 
     * @return Returns a customer ID
     */
    public int getCustomerID() {
        return customerID;
    }
    
    /**
     * Method for getting the associated contact ID of an appointment. 
     * @return Returns a contact ID
     */
    public int getContactID() {
        return contactID;
    }
    
    /**
     * Method for getting the associated user ID of an appointment. 
     * @return Returns a user ID
     */
    public int getUserID() {
        return userID;
    }
    
    /**
     * Method for getting the name of contact associated with the appointment. 
     * @return Returns a contact name
     */
    public String getContactName() {
        return contactName;
    }
    
}
