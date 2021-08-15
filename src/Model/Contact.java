/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * This class defines the attributes and methods of Contact objects
 * @author Eric Matelyan
 */
public class Contact {
    
    private int contactID;
    private String contactName;
    private String email;
    
    /**
     * Constructor for Contact objects. 
     * @param contactID Contact ID of contact
     * @param contactName Name of contact
     * @param email Email address of contact
     */
    public Contact(int contactID, String contactName, String email) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.email = email;
    }
    
    /**
     * Method for getting a contact ID. 
     * @return Returns a contact ID
     */
    public int getContactID() {
        return contactID;
    }
    
    /**
     * Method for getting a contact's name. 
     * @return Returns a contact name
     */
    public String getContactName() {
        return contactName;
    }
    
    /**
     * Method for getting a contact's appointment. 
     * @return Returns an email address
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Overrides toString() method, and returns a formatted ID and name. 
     * @return Returns a formatted ID and name
     */
    @Override
    public String toString() {
        return("[" + Integer.toString(contactID) + "] " + contactName);
    }
    
}
