/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.User;
import mainpkg.Saima.User4_Doctor.Goal1_AddMedicine.AddMedicineSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Goal2_MedicalRecords.MedicalRecordsSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Profile.ProfileSceneFxmlController;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DashBoardSceneFxmlController implements Initializable {

    @FXML    private Label nameLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label idLabel;

    /**
     * Initializes the controller class.
     */
    Alert alert ;
    Doctor user ;
    
    public User get() {
        return user ;
    }
    
    public void set(Doctor u) {
        user = u ;
        nameLabel.setText(user.getName());
        userTypeLabel.setText(user.getUserType());
        idLabel.setText(Integer.toString(user.getId()));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profileOnMouseClicked(MouseEvent event) throws IOException {
        Parent root=null;
        FXMLLoader myLoader=new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Profile/ProfileSceneFxml.fxml"));
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ProfileSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;
        

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor Profile") ;
        stage.show() ;
    }
   

    @FXML
    private void addMedicineOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Goal1_AddMedicine/AddMedicineSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        AddMedicineSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Add Medicine Info") ;
        stage.show() ;

    }

    @FXML
    private void medicalRecordsOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Goal2_MedicalRecords/MedicalRecordsSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        MedicalRecordsSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Add Medicine Info") ;
        stage.show() ;
    }

    @FXML
    private void checkupScheduleOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void requestExtraMedicineOnMouseClicked(MouseEvent event) {
    }


    @FXML
    private void requestExtraHolidayOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void medicialReportOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void signOutOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void requestMedicalCampaignOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void RequestVolunteerOnMouseClicked(MouseEvent event) {
    }
    
}
