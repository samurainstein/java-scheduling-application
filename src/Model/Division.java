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
public class Division {
    
    //Members
    private int divisionID;
    private String divisionName;
    private int countryID;
    
    //Methods
    public Division(int divisionID, String divisionName, int countryID) {
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.countryID = countryID;
    }
    
    public int getDivisionID() {
        return divisionID;
    }
    
    public String getDivisionName() {
        return divisionName;
    }
    
    public int getCountryID() {
        return countryID;
    }
}
