/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal2_MedicalRecords;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class MedicalRecordsSceneFxmlController implements Initializable {

    @FXML    private ComboBox<Integer> refugeeIdComboBox;
    @FXML    private Label medicineNameLabel;
    @FXML    private Label genderLabel;
    @FXML    private Label ddLabel;
    @FXML    private Label mmLabel;
    @FXML    private Label yyyyLabel;
    @FXML    private Label nameLabel;
    @FXML    private Label ageLabel;
    @FXML    private Label diseaseLabel;
    @FXML    private Label treatmentLabel;
    @FXML    private Label checkupNoLabel;

    /**
     * Initializes the controller class.
     */
    Alert alert ;
    Doctor user ;
    
    
    
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
