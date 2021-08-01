/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class AppointmentAddController implements Initializable {

    @FXML
    private TextField titleTF;
    @FXML
    private TextArea descriptionTA;
    @FXML
    private ComboBox<?> contactCombo;
    @FXML
    private TextField locationTF;
    @FXML
    private TextField typeTF;
    @FXML
    private DatePicker startDatePick;
    @FXML
    private ComboBox<?> startTimeCombo;
    @FXML
    private DatePicker endDatePick;
    @FXML
    private ComboBox<?> endTimeCombo;
    @FXML
    private ComboBox<?> customerCombo;
    @FXML
    private ComboBox<?> userCombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSave(ActionEvent event) {
    }

    @FXML
    private void onClear(ActionEvent event) {
    }

    @FXML
    private void onCancel(ActionEvent event) {
    }
    
}
