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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class CustomerAddController implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField postalTF;
    @FXML
    private ComboBox<?> countryCombo;
    @FXML
    private ComboBox<?> divisionCombo;

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
    private void onCancel(ActionEvent event) {
    }
    
}
