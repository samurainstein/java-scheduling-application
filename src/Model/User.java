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
public class User {
    
    //Members
    /**
     * This variable holds the user's userID. 
     */
    private int userID;
    
    /**
     * This variable holds the user's username. 
     */
    private String username;
    
    /**
     * This variable holds the user's password. 
     */
    private String password;

    //Methods
    /**
     * This is the constructor for making a user object. 
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
     * This method returns a usernname. 
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
}
