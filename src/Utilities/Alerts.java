/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import javafx.scene.control.Alert;

/**
 *
 * @author Eric
 */
public abstract class Alerts {
    public static void appointmentNullAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Selection");
        alert.setContentText("Please select an appointment");
        alert.showAndWait();
    }
    
    public static void appointmentDeleteConfirm(int appointmentID, String type) {
        Alert confirmAlert = new Alert(Alert.AlertType.INFORMATION);
            confirmAlert.setTitle("Confirmation");
            confirmAlert.setContentText("Appointment was deleted\n" + "Appointment ID: " + appointmentID + "\n" + "Appointment Type: " + type);
            confirmAlert.showAndWait();
    }
    
    public static void appointmentOverlap() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Appointment overlap");
        alert.setContentText("Selected time overlaps with another appointment.  Please select a different time");
        alert.showAndWait();
    }
    
    public static void appointmentUpcomingAlert() {
        String popupTitle = "Appointment Notification";
        String popupText = "You have an appointment in the next 15 minutes";
        Alert popup = new Alert(Alert.AlertType.INFORMATION);
        popup.setTitle(popupTitle);
        popup.setContentText(popupText);
        popup.showAndWait();
    }
    
    public static void customerNullAlert() {
        Alert invalidAlert = new Alert(Alert.AlertType.ERROR);
        invalidAlert.setTitle("Invalid Selection");
        invalidAlert.setContentText("Please select a customer");
        invalidAlert.showAndWait();
    }
    
    public static void customerDeleteConfirm() {
        Alert confirmAlert = new Alert(Alert.AlertType.INFORMATION);
        confirmAlert.setTitle("Confirmation");
        confirmAlert.setContentText("Customer was deleted");
        confirmAlert.showAndWait();
    }
    
    public static void loginInvalid(String alertTitle, String alertText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(alertTitle);
        alert.setContentText(alertText);
        alert.showAndWait();
    }
}
