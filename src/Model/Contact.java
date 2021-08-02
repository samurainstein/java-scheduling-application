/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Eric
 */
public class Contact {
    private int contactID;
    private String contactName;
    private String email;
    
    public Contact(int contactID, String contactName, String email) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.email = email;
    }
    
    public int getContactID() {
        return contactID;
    }
    
    public String getContactName() {
        return contactName;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return("[" + Integer.toString(contactID) + "] " + contactName);
    }
    
}
