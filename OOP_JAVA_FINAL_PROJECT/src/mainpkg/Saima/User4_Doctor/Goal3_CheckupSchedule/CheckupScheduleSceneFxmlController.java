/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal3_CheckupSchedule;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CheckupScheduleSceneFxmlController implements Initializable {

    @FXML
    private Label genderLabel;
    @FXML
    private Label ddLabel;
    @FXML
    private Label mmLabel;
    @FXML
    private Label yyyyLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private ComboBox<?> appoinmentIdComboBox;
    @FXML
    private Label checkupTimeLabel;
    @FXML
    private Label refugeeIdLabel;
    @FXML
    private Label totalAppoinmentLabel;
    @FXML
    private TableView<?> checkupScheduleTableView;
    @FXML
    private TableColumn<?, ?> appoinmetIdTableColumn;
    @FXML
    private TableColumn<?, ?> refugeeIdTableColumn;
    @FXML
    private TableColumn<?, ?> nameTableColumn;
    @FXML
    private TableColumn<?, ?> genderTableColumn;
    @FXML
    private TableColumn<?, ?> checkupDateTableColumn;
    @FXML
    private TableColumn<?, ?> checkupTimeTableColumn;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) {
    }
    
}
