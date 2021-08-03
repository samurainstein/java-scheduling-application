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
public class Customer {
    
    //Members
    private int customerID;
    private String customerName;
    private String address;
    private String postalCode;
    private String phone;
    private String division;
    private String country;
    
    //Methods
    public Customer(int customerID, String customerName, String address, String postalCode, String phone, String division, String country) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.division = division;
        this.country = country;
    }
    
    public int getCustomerID() {
        return customerID;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public String getCustomerAddress() {
        return address;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getDivision() {
        return division;
    }
    
    public String getCountry() {
        return country;
    }
    
    @Override
    public String toString() {
        return ("[" + customerID + "] " + customerName);
    }
    
}
