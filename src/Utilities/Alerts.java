/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import javafx.scene.control.Alert;

/**
 * This class is used to define various alerts that are generated in the program. 
 * @author Eric Matelyan
 */
public abstract class Alerts {
    
    /**
     * Method for generating an alert to indicate an invalid appointment selection. 
     */
    public static void appointmentNullAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Selection");
        alert.setContentText("Please select an appointment");
        alert.showAndWait();
    }
    
    /**
     * Method for generating an alert to confirm that an appointment was deleted. 
     * @param appointmentID ID of appointment that was deleted
     * @param type Type of appointment that was deleted
     */
    public static void appointmentDeleteConfirm(int appointmentID, String type) {
        Alert confirmAlert = new Alert(Alert.AlertType.INFORMATION);
            confirmAlert.setTitle("Confirmation");
            confirmAlert.setContentText("Appointment was deleted\n" + "Appointment ID: " + appointmentID + "\n" + "Appointment Type: " + type);
            confirmAlert.showAndWait();
    }
    
    /**
     * Method for generating an alert to indicate that the entered appointment conflicts with another appointment. 
     */
    public static void appointmentOverlap() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Appointment overlap");
        alert.setContentText("Selected time overlaps with another appointment.  Please select a different time");
        alert.showAndWait();
    }
    
    /**
     * Method for generating an alert to indicate that associated appointments should be deleted before deleting a customer. 
     */
    public static void associatedAppointment() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Associated Appointed");
        alert.setContentText("Please delete all appointments associated with this customer before deleting the customer");
        alert.showAndWait();
    }
    
    /**
     * Method for generating an alert to indicate an upcoming appointment in the next 15 minutes. 
     */
    public static void appointmentUpcomingAlert() {
        String popupTitle = "Appointment Notification";
        String popupText = "You have an appointment in the next 15 minutes";
        Alert popup = new Alert(Alert.AlertType.INFORMATION);
        popup.setTitle(popupTitle);
        popup.setContentText(popupText);
        popup.showAndWait();
    }
    
    /**
     * Method for generating an alert to indicate an invalid customer selection. 
     */
    public static void customerNullAlert() {
        Alert invalidAlert = new Alert(Alert.AlertType.ERROR);
        invalidAlert.setTitle("Invalid Selection");
        invalidAlert.setContentText("Please select a customer");
        invalidAlert.showAndWait();
    }
    
    /**
     * Method for generating an alert to confirm that a customer was deleted. 
     */
    public static void customerDeleteConfirm() {
        Alert confirmAlert = new Alert(Alert.AlertType.INFORMATION);
        confirmAlert.setTitle("Confirmation");
        confirmAlert.setContentText("Customer was deleted");
        confirmAlert.showAndWait();
    }
    
    /**
     * Method for generating an alert to indicate an invalid country or division selection. 
     */
    public static void countryOrDivisionNullAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Selection");
        alert.setContentText("Please select a country and division");
        alert.showAndWait();
    }
    
    /**
     * Method for generating an alert to indicate all fields weren't filled in. 
     */
    public static void invalidFields() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Insufficient Information");
        alert.setContentText("Please fill in all fields");
        alert.showAndWait();
    }
    
    /**
     * Method for generating an alert to indicate an invalid login username or password. 
     */
    public static void loginInvalid(String alertTitle, String alertText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(alertTitle);
        alert.setContentText(alertText);
        alert.showAndWait();
    }
}
