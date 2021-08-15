/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * This class defines the attributes and methods of Country objects
 * @author Eric Matelyan
 */
public class Country {
    
    private int countryID;
    private String countryName;
    
    /**
     * Constructor for Country objects. 
     * @param countryID ID of country
     * @param countryName Name of country
     */
    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }
    
    /**
     * Method for getting a country ID. 
     * @return Returns a country ID
     */
    public int getCountryID() {
        return countryID;
    }
    
    /**
     * Method for getting a country's name. 
     * @return Returns a country name
     */
    public String getCountryName() {
        return countryName;
    }
    
    /**
     * Overrides toString() method, and returns a country name. 
     * @return Returns a country name
     */
    @Override
    public String toString() {
        return (countryName);
    }
}
