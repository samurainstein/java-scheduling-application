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
    private int divisionID;
    
    //Methods
    public Customer(int customerID, String customerName, String address, String postalCode, String phone, int divisionID) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.divisionID = divisionID;
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
        return address;
    }
    
    public int getDivisionID() {
        return divisionID;
    }
    
}
