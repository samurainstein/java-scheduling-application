/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author Eric
 */
public class Appointment {
    
    //Members
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
    
    //Methods
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
    
    public int getAppointmentID() {
        return appointmentID;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getType() {
        return type;
    }
    
    public LocalDateTime getStart() {
        return start;
    }
    
    public LocalDateTime getEnd() {
        return end;
    }
    
    public int getCustomerID() {
        return customerID;
    }
    
    public int getContactID() {
        return contactID;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public String getContactName() {
        return contactName;
    }
    
}
