/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * This class defines the attributes and methods of User objects
 * @author Eric Matelyan
 */
public class User {

    private int userID;
    private String username;
    private String password;

    /**
     * Constructor for user objects. 
     * @param userID The userID to be assigned to the user object
     * @param username The username to be assigned to the user object
     * @param password The password to be assigned to the user object
     */
    public User(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }
    
    /**
     * This method returns a user ID. 
     * @return Returns the user's ID
     */
    public int getUserID() {
        return userID;
    }
    
    /**
     * This method returns a username. 
     * @return Returns the user's username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * This method returns a password. 
     * @return Returns the user's password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Overrides toString() method, and returns a formatted ID and username. 
     * @return Returns a formatted ID and username
     */
    @Override
    public String toString() {
        return ("[" + userID + "] " + username);
    }
}
