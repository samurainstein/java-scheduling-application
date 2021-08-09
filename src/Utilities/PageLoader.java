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
 *
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
    
    public static void pageLoad(ActionEvent event, Parent root, String pageTitle) {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle(pageTitle);
        stage.setScene(scene);
        stage.show();
    }
    
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
    
    public static String getLoginTitle() {
        return loginTitle;
    }
    
    public static String getHomeTitle() {
        return homeTitle;
    }
    
    public static String getCustomersTitle() {
        return customersTitle;
    }
    
    public static String getAppointmentsTitle() {
        return appointmentsTitle;
    }
    
    public static String getCustomerAddTitle() {
        return customerAddTitle;
    }
    
    public static String getAppointmentAddTitle() {
        return appointmentAddTitle;
    }
    
    public static String getCustomerUpdateTitle() {
        return customerUpdateTitle;
    }
    
    public static String getAppointmentUpdateTitle() {
        return appointmentUpdateTitle;
    }
    
    public static String getReportsTitle() {
        return reportsTitle;
    }
    
}
