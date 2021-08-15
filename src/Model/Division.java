/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * This class defines the attributes and methods of Customer objects
 * @author Eric Matelyan
 */
public class Division {
    
    
    private int divisionID;
    private String divisionName;
    private int countryID;
    
    /**
     * Constructor for Division objects. 
     * @param divisionID ID of division
     * @param divisionName Name of division
     * @param countryID ID of associated country
     */
    public Division(int divisionID, String divisionName, int countryID) {
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.countryID = countryID;
    }
    
    /**
     * Method for getting a division ID. 
     * @return Returns a division ID
     */
    public int getDivisionID() {
        return divisionID;
    }
    
    /**
     * Method for getting a division name. 
     * @return Returns a division name
     */
    public String getDivisionName() {
        return divisionName;
    }
    
    /**
     * Method for getting a country ID that is associated with a division. 
     * @return Returns a country ID
     */
    public int getCountryID() {
        return countryID;
    }
    
    /**
     * Overrides toString() method, and returns a division name. 
     * @return Returns a country name
     */
    @Override
    public String toString() {
        return (divisionName);
    }
}
