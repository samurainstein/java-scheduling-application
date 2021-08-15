/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Utilities.ActivityLog;
import Utilities.Alerts;
import Utilities.PageLoader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * This class handles events on the Login screen
 * @author Eric Matelyan
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
        if(userID == 0) {
            Alerts.loginInvalid(alertTitle, alertText);
            ActivityLog.loginAttempt(userID, username);
        }
        
        else {
            ActivityLog.loginAttempt(userID, username);
            Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
            String pageTitle = PageLoader.getHomeTitle();
            PageLoader.pageLoad(event, root, pageTitle);  
        }
    }
    
}
