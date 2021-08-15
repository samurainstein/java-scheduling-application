/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Controller.AppointmentUpdateController;
import Controller.CustomerUpdateController;
import Model.Appointment;
import Model.Customer;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class is used to load pages while the application is running. 
 * @author Eric
 */
public abstract class PageLoader {
    
    private static String loginTitle = "Login";
    private static String homeTitle = "Home";
    private static String customersTitle = "Customers";
    private static String appointmentsTitle = "Appointments";
    private static String customerAddTitle = "Add Customer";
    private static String appointmentAddTitle = "Add Appointment";
    private static String customerUpdateTitle = "Update Customer";
    private static String appointmentUpdateTitle = "Update Appointment";
    private static String reportsTitle = "Reports";
    
    /**
     * This method loads an application page, based on the passed in event, root, and page title. 
     * @param event Event object that was generated from an event in the application
     * @param root The root of the page to be loaded
     * @param pageTitle The title of the page that will be set to the new screen
     */
    public static void pageLoad(ActionEvent event, Parent root, String pageTitle) {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle(pageTitle);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * This method loads the customer update page, and passes data from the main customers page. 
     * @param event Event object that was generated from an event in the application
     * @param loader The loader object of the page to be loaded
     * @param pageTitle The title of the page that will be set to the new screen
     * @param selectedCustomer The customer that is being passed to the update page
     */
    public static void custUpdatePageLoad(ActionEvent event, FXMLLoader loader, String pageTitle, Customer selectedCustomer) throws IOException {
        Parent root = loader.load();
        CustomerUpdateController updateCont = loader.getController();
        updateCont.passCustomerData(selectedCustomer);
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle(pageTitle);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * This method loads the appointment update page, and passes data from the main appointments page. 
     * @param event Event object that was generated from an event in the application
     * @param loader The loader object of the page to be loaded
     * @param pageTitle The title of the page that will be set to the new screen
     * @param selectedAppointment The appointment that is being passed to the update page
     */
    public static void apptUpdatePageLoad(ActionEvent event, FXMLLoader loader, String pageTitle, Appointment selectedAppointment) throws IOException {
        Parent root = loader.load();
        AppointmentUpdateController updateCont = loader.getController();
        updateCont.passAppointmentData(selectedAppointment);
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle(pageTitle);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Method for returning the login page title. 
     * @return Returns the login page title
     */
    public static String getLoginTitle() {
        return loginTitle;
    }
    
    /**
     * Method for returning the home page title. 
     * @return Returns the home page title
     */
    public static String getHomeTitle() {
        return homeTitle;
    }
    
    /**
     * Method for returning the customers page title. 
     * @return Returns the customers page title
     */
    public static String getCustomersTitle() {
        return customersTitle;
    }
    
    /**
     * Method for returning the appointments page title. 
     * @return Returns the appointments page title
     */
    public static String getAppointmentsTitle() {
        return appointmentsTitle;
    }
    
    /**
     * Method for returning the add customers page title. 
     * @return Returns the add customers page title
     */
    public static String getCustomerAddTitle() {
        return customerAddTitle;
    }
    
    /**
     * Method for returning the add appointments page title. 
     * @return Returns the add appointments page title
     */
    public static String getAppointmentAddTitle() {
        return appointmentAddTitle;
    }
    
    /**
     * Method for returning the update customers page title. 
     * @return Returns the update customers page title
     */
    public static String getCustomerUpdateTitle() {
        return customerUpdateTitle;
    }
    
    /**
     * Method for returning the update appointments page title. 
     * @return Returns the update appointments page title
     */
    public static String getAppointmentUpdateTitle() {
        return appointmentUpdateTitle;
    }
    
    /**
     * Method for returning the reports page title. 
     * @return Returns the reports page title
     */
    public static String getReportsTitle() {
        return reportsTitle;
    }
    
}
