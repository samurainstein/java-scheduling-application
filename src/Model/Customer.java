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
public class Customer {
    
    private int customerID;
    private String customerName;
    private String address;
    private String postalCode;
    private String phone;
    private String division;
    private String country;
    
    /**
     * Constructor for Customer objects. 
     * @param customerID ID of customer
     * @param customerName Name of customer
     * @param address Address of customer
     * @param postalCode Postal Code of customer
     * @param phone Phone number of customer
     * @param division Division of customer
     * @param country Country of customer
     */
    public Customer(int customerID, String customerName, String address, String postalCode, String phone, String division, String country) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.division = division;
        this.country = country;
    }
    
    /**
     * Method for getting a customer ID. 
     * @return Returns a customer ID
     */
    public int getCustomerID() {
        return customerID;
    }
    
    /**
     * Method for getting a customer name. 
     * @return Returns a customer name
     */
    public String getCustomerName() {
        return customerName;
    }
    
    /**
     * Method for getting the address of a customer. 
     * @return Returns an address
     */
    public String getCustomerAddress() {
        return address;
    }
    
    /**
     * Method for getting a customer's postal code. 
     * @return Returns a postal code
     */
    public String getPostalCode() {
        return postalCode;
    }
    
    /**
     * Method for getting a customer's phone number. 
     * @return Returns a phone number
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * Method for getting a customer's division. 
     * @return Returns a division name
     */
    public String getDivision() {
        return division;
    }
    
    /**
     * Method for getting a customer's country. 
     * @return Returns a country name
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * Overrides toString() method, and returns a formatted customer ID and name. 
     * @return Returns a formatted customer ID and name
     */
    @Override
    public String toString() {
        return ("[" + customerID + "] " + customerName);
    }
    
}
