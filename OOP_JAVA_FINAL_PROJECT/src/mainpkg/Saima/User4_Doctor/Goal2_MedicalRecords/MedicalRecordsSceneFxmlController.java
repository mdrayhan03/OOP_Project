/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal2_MedicalRecords;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Saima.User4_Doctor.Doctor;
import mainpkg.Saima.User4_Doctor.Patient;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class MedicalRecordsSceneFxmlController implements Initializable {

    
    @FXML    private ComboBox<Integer> patientIdComboBox;
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
    ObservableList<Patient> list = FXCollections.observableArrayList() ;
  
    
    
    public Doctor get() {
        return user ;
    }
    public void set(Doctor u) {
        user = u ;
    }
    
    public void setComboBox() {
        for(Patient Id: list) {
            patientIdComboBox.getItems().add(Id.getId()) ;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor") ;
        stage.show() ;
    
    }

    @FXML
    private void redugeeIdMouseOnClicked(MouseEvent event) {
         Patient Id = user.patientInfo(patientIdComboBox.getValue().toString(), list) ;
        if (Id != null) {
            ageLabel.setText(Id.getAge()) ;
            diseaseLabel.setText(Id.getDisease()) ;
            treatmentLabel.setText(Id.getTreatment()) ;
            checkupNoLabel.setText(Id.getCheckupNo().toString()) ;
            nameLabel.setText(Id.getName()) ;
            genderLabel.setText(Id.getGender()) ;
            ddLabel.setText(Id.getCheckupDate()) ;
            mmLabel.setText(Id.getCheckupDate().toString()) ;
            yyyyLabel.setText(Id.getCheckupDate().toString()) ;
            
        }
    }
    
}
