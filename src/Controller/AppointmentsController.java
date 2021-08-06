/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AppointmentDAO;
import DAO.CustomerDAO;
import Model.Appointment;
import Model.Data;
import Utilities.Alerts;
import Utilities.PageLoader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class AppointmentsController implements Initializable {

    @FXML
    private TableView<Appointment> monthViewTable;
    @FXML
    private TableView<Appointment> weekViewTable;
    @FXML
    private Tab monthTab;
    @FXML
    private Tab weekTab;
    @FXML
    private TableColumn<Appointment, Integer> monthApptIDCol;
    @FXML
    private TableColumn<Appointment, String> monthTitleCol;
    @FXML
    private TableColumn<Appointment, String> monthDescriptionCol;
    @FXML
    private TableColumn<Appointment, String> monthLocationCol;
    @FXML
    private TableColumn<Appointment, String> monthContactCol;
    @FXML
    private TableColumn<Appointment, String> monthTypeCol;
    @FXML
    private TableColumn<Appointment, LocalDateTime> monthStartCol;
    @FXML
    private TableColumn<Appointment, LocalDateTime> monthEndCol;
    @FXML
    private TableColumn<Appointment, Integer> monthCustIDCol;
    @FXML
    private TableColumn<Appointment, Integer> weekApptIDCol;
    @FXML
    private TableColumn<Appointment, String> weekTitleCol;
    @FXML
    private TableColumn<Appointment, String> weekDescriptionCol;
    @FXML
    private TableColumn<Appointment, String> weekLocationCol;
    @FXML
    private TableColumn<Appointment, String> weekContactCol;
    @FXML
    private TableColumn<Appointment, String> weekTypeCol;
    @FXML
    private TableColumn<Appointment, LocalDateTime> weekStartCol;
    @FXML
    private TableColumn<Appointment, LocalDateTime> weekEndCol;
    @FXML
    private TableColumn<Appointment, Integer> weekCustIDCol;
    @FXML
    private Tab allTab;
    @FXML
    private TableView<Appointment> allViewTable;
    @FXML
    private TableColumn<Appointment, Integer> allApptIDCol;
    @FXML
    private TableColumn<Appointment, String> allTitleCol;
    @FXML
    private TableColumn<Appointment, String> allDescriptionCol;
    @FXML
    private TableColumn<Appointment, String> allLocationCol;
    @FXML
    private TableColumn<Appointment, String> allContactCol;
    @FXML
    private TableColumn<Appointment, String> allTypeCol;
    @FXML
    private TableColumn<Appointment, LocalDateTime> allStartCol;
    @FXML
    private TableColumn<Appointment, LocalDateTime> allEndCol;
    @FXML
    private TableColumn<Appointment, Integer> allCustomerIDCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allApptIDCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        allTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        allDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        allLocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
        allTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        allStartCol.setCellValueFactory(new PropertyValueFactory<>("Start"));
        allEndCol.setCellValueFactory(new PropertyValueFactory<>("End"));
        allCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        allContactCol.setCellValueFactory(new PropertyValueFactory<>("ContactName"));
        
        monthApptIDCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        monthTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        monthDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        monthLocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
        monthTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        monthStartCol.setCellValueFactory(new PropertyValueFactory<>("Start"));
        monthEndCol.setCellValueFactory(new PropertyValueFactory<>("End"));
        monthCustIDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        monthContactCol.setCellValueFactory(new PropertyValueFactory<>("ContactName"));
        
        weekApptIDCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        weekTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        weekDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        weekLocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
        weekTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        weekStartCol.setCellValueFactory(new PropertyValueFactory<>("Start"));
        weekEndCol.setCellValueFactory(new PropertyValueFactory<>("End"));
        weekCustIDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        weekContactCol.setCellValueFactory(new PropertyValueFactory<>("ContactName"));
        
        try {
            AppointmentDAO.selectAppointments();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        allViewTable.setItems(Data.getAllAppointments());

    }    

    @FXML
    private void onAdd(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("/view/AppointmentAdd.fxml")));
        String pageTitle = PageLoader.getAppointmentAddTitle();
        PageLoader.pageLoad(event, root, pageTitle);
    }
    
    @FXML
    private void onUpdate(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AppointmentUpdate.fxml"));
            Appointment selectedAppointment = allViewTable.getSelectionModel().getSelectedItem();
            String pageTitle = PageLoader.getAppointmentUpdateTitle();
            PageLoader.apptUpdatePageLoad(event, loader, pageTitle, selectedAppointment);
            
        }
        catch(NullPointerException exception) {
            Alerts.appointmentNullAlert();
        }
    }

    @FXML
    private void onDelete(ActionEvent event) throws SQLException {
        try {
            Appointment appointment = allViewTable.getSelectionModel().getSelectedItem();
            int appointmentID = appointment.getAppointmentID();
            allViewTable.setItems(Data.getAllAppointments());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this appointment?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) { 
                AppointmentDAO.deleteAppointment(appointmentID);
                AppointmentDAO.selectAppointments();
                allViewTable.setItems(Data.getAllAppointments());
                Alerts.appointmentDeleteConfirm(appointmentID);
            }
        }
        catch(NullPointerException exception) {
            Alerts.appointmentNullAlert();
        }
    }    
        

    @FXML
    private void onHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        String pageTitle = PageLoader.getHomeTitle();
        PageLoader.pageLoad(event, root, pageTitle);
    }

    @FXML
    private void onAllTab(Event event) {
        try {
            AppointmentDAO.selectAppointments();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        allViewTable.setItems(Data.getAllAppointments());
    }

    @FXML
    private void onMonthTab(Event event) {
        Data.clearMonthlyAppointments();
        try {
            AppointmentDAO.selectAppointments();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        Data.filterMonthlyAppointments();
        monthViewTable.setItems(Data.getMonthlyAppointments());
    }

    @FXML
    private void onWeekTab(Event event) {
        Data.clearWeeklyAppointments();
        try {
            AppointmentDAO.selectAppointments();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        Data.filterWeeklyAppointments();
        weekViewTable.setItems(Data.getWeeklyAppointments());
    }
    
}
