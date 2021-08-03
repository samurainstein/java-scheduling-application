/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Utilities.DBConnection;
import Utilities.DBQuery;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class LoginController implements Initializable {

    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Label zoneIDLabel;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label signInLabel;
    @FXML
    private Button loginButton;

    private String alertTitle = "Invalid username or password";
    private String alertText = "Username or password is incorrect";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ZoneId zoneID = ZoneId.systemDefault();
        zoneIDLabel.setText("Location: " + zoneID.toString());
        
        if(Locale.getDefault().getLanguage().equals("fr")) {
            welcomeLabel.setText("Bienvenue!");
            signInLabel.setText("Connectez-vous s'il vous plaît");
            usernameTF.setPromptText("Nom de l'utilisateur");
            passwordTF.setPromptText("Mot de passe");
            loginButton.setText("Se connecter");
            alertTitle = "Nom de l'utilisateur ou mot de passe invalide";
            alertText = "Nom de l’utilisateur ou mot de passe incorrect";
            zoneIDLabel.setText("Lieu: " + zoneID.toString());
        }
          
    }    

    @FXML
    private void onLogin(ActionEvent event) throws SQLException, IOException {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        int userID = UserDAO.userLogin(username, password);
        //System.out.println("The user is " + userID);
        if(userID == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(alertTitle);
            alert.setContentText(alertText);
            alert.showAndWait();
        }
        
        else {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }
    }
    
}
