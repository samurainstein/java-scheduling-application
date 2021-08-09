/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AppointmentDAO;
import Model.Data;
import Utilities.DateAndTime;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class ReportsController implements Initializable {

    @FXML
    private ComboBox<String> typeCombo;
    @FXML
    private ComboBox<Month> monthCombo;
    @FXML
    private Button runButton;
    @FXML
    private Label numberLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthCombo.setItems(DateAndTime.getAllMonths());
        try {
            AppointmentDAO.selectAppointmentTypes();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        typeCombo.setItems(Data.getAllTypes());
    }    

    
    
    @FXML
    private void onRun(ActionEvent event) throws SQLException {
        String type = typeCombo.getSelectionModel().getSelectedItem();
        Month month = monthCombo.getSelectionModel().getSelectedItem();
        LocalDateTime startLDT = DateAndTime.getMonthStart(month);
        LocalDateTime endLDT = DateAndTime.getMonthEnd(month);    
        int total = AppointmentDAO.getCustomerReport(type, startLDT, endLDT);
        numberLabel.setText(String.valueOf(total));
    }
}
