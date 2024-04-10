/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal6_RequestMedicalCampaign;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Rayhan.User5.Goal6_Campaign.CampaignTableView;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RequestMedicalCampaignSceneFxmlController implements Initializable {

    @FXML
    private TextField ddTextField;
    @FXML
    private TextField mmTextField;
    @FXML
    private TextField yyyyTextField;
    @FXML
    private ComboBox<?> timeComboBox;
    @FXML
    private ComboBox<?> placeComboBox;
    @FXML
    private TextField reasonTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TableView<?> medicalCampaignTableView;
    @FXML
    private TableColumn<?, ?> reasonIdTableColumn;
    @FXML
    private TableColumn<?, ?> reasonTableColumn;
    @FXML
    private TableColumn<?, ?> dateTableColumn;
    @FXML
    private TableColumn<?, ?> timeTableColumn;
    @FXML
    private TableColumn<?, ?> descriptionTableColumn;
    @FXML
    private TableColumn<?, ?> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    Alert alert ;
    Doctor user ;
    ObservableList<Campaign> list = FXCollections.observableArrayList() ;
    
    
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
    private void backOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void applyOnMouseClicked(MouseEvent event) {
    }
    
}
