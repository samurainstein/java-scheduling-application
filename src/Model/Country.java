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
public class Country {
    //Members
    private int countryID;
    private String countryName;
    
    //Methods
    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }
    
    public int getCountryID() {
        return countryID;
    }
    
    public String getCountryName() {
        return countryName;
    }
}
