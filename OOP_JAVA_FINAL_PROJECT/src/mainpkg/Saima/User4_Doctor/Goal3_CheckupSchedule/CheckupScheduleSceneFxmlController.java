/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal3_CheckupSchedule;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CheckupScheduleSceneFxmlController implements Initializable {

    @FXML    private Label genderLabel;
    @FXML    private Label ddLabel;
    @FXML    private Label mmLabel;
    @FXML    private Label yyyyLabel;
    @FXML    private Label nameLabel;
    @FXML    private ComboBox<String> appoinmentIdComboBox;
    @FXML    private Label checkupTimeLabel;
    @FXML    private Label refugeeIdLabel;
    @FXML    private Label totalAppoinmentLabel;
    @FXML    private TableView<CheckupSchedule> checkupScheduleTableView;
    @FXML    private TableColumn<CheckupSchedule, String> appoinmetIdTableColumn;
    @FXML    private TableColumn<CheckupSchedule, String> refugeeIdTableColumn;
    @FXML    private TableColumn<CheckupSchedule, String> nameTableColumn;
    @FXML    private TableColumn<CheckupSchedule, String> genderTableColumn;
    @FXML    private TableColumn<CheckupSchedule, Date> checkupDateTableColumn;
    @FXML    private TableColumn<CheckupSchedule, String> checkupTimeTableColumn;
 
    /**
     * Initializes the controller class.
     */
    Alert alert ;
    Doctor user ;
    ObservableList<CheckupSchedule> list = FXCollections.observableArrayList() ;
    
    
    public Doctor get() {
        return user ;
    }
    public void set(Doctor u) {
        user = u ;
    }
    
    public void setComboBox() {
        for(CheckupSchedule sh: list) {
            appoinmentIdComboBox.getItems().add(sh.getAppointmentId()) ;
        }
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        appoinmetIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("appoinmentId")) ;
        refugeeIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("refugeeId")) ;
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("refugeeName")) ;
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender")) ;
        checkupDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("checkupDate")) ;
        checkupTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("checkupTime")) ;
    
        
        
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DoctorDashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor") ;
        stage.show() ;
    
    }

    @FXML
    private void appoinmentIdOnMouseClicked(MouseEvent event) {
        CheckupSchedule sh = user.scheduleInfo(appoinmentIdComboBox.getValue(), list) ;
        if (sh!= null) {
            refugeeIdLabel.setText(sh.getRefugeeId()) ;
            totalAppoinmentLabel.setText(sh.getAppointmentId()) ;
            
            checkupTimeLabel.setText(sh.getCheckupTime()) ;
            nameLabel.setText(sh.getName()) ;
            genderLabel.setText(sh.getGender()) ;
            
            ddLabel.setText(sh.getCheckupDate().toString()) ;
            mmLabel.setText(sh.getCheckupDate().toString()) ;
            yyyyLabel.setText(sh.getCheckupDate().toString()) ;
            
        }
    }
    
}
