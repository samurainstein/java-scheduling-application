/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class AppointmentsController implements Initializable {

    @FXML
    private TableView<?> monthViewTable;
    @FXML
    private TableView<?> weekViewTable;
    @FXML
    private Tab monthTab;
    @FXML
    private Tab weekTab;
    @FXML
    private TableColumn<?, ?> monthApptIDCol;
    @FXML
    private TableColumn<?, ?> monthTitleCol;
    @FXML
    private TableColumn<?, ?> monthDescriptionCol;
    @FXML
    private TableColumn<?, ?> monthLocationCol;
    @FXML
    private TableColumn<?, ?> monthContactCol;
    @FXML
    private TableColumn<?, ?> monthTypeCol;
    @FXML
    private TableColumn<?, ?> monthStartCol;
    @FXML
    private TableColumn<?, ?> monthEndCol;
    @FXML
    private TableColumn<?, ?> monthCustIDCol;
    @FXML
    private TableColumn<?, ?> weekApptIDCol;
    @FXML
    private TableColumn<?, ?> weekTitleCol;
    @FXML
    private TableColumn<?, ?> weekDescriptionCol;
    @FXML
    private TableColumn<?, ?> weekLocationCol;
    @FXML
    private TableColumn<?, ?> weekContactCol;
    @FXML
    private TableColumn<?, ?> weekTypeCol;
    @FXML
    private TableColumn<?, ?> weekStartCol;
    @FXML
    private TableColumn<?, ?> weekEndCol;
    @FXML
    private TableColumn<?, ?> weekCustIDCol;
    @FXML
    private Tab allTab;
    @FXML
    private TableView<?> allViewTable;
    @FXML
    private TableColumn<?, ?> allApptIDCol;
    @FXML
    private TableColumn<?, ?> allTitleCol;
    @FXML
    private TableColumn<?, ?> allDescriptionCol;
    @FXML
    private TableColumn<?, ?> allLocationCol;
    @FXML
    private TableColumn<?, ?> allContactCol;
    @FXML
    private TableColumn<?, ?> allTypeCol;
    @FXML
    private TableColumn<?, ?> allStartCol;
    @FXML
    private TableColumn<?, ?> allEndCol;
    @FXML
    private TableColumn<?, ?> allCustomerIDCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onAdd(ActionEvent event) {
    }

    @FXML
    private void onUpdate(ActionEvent event) {
    }

    @FXML
    private void onDelete(ActionEvent event) {
    }

    @FXML
    private void onHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }
    
}
