/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Utilities.DBConnection;
import Utilities.DBQuery;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userNameTF;
    @FXML
    private TextField passwordTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onLogin(ActionEvent event) throws SQLException {
        String username = userNameTF.getText();
        String password = passwordTF.getText();
        Connection conn = DBConnection.getConnection();
        String sqlStatement = "SELECT * FROM users "
                            + "WHERE User_Name = '" + username + "'"
                            + "AND Password = '" + password + "';";
        //UserDAO.selectUser(sqlStatement);
    }
    
}
