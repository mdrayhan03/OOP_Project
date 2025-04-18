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
import mainpkg.Saima.User4_Doctor.Goal5_RequestVolunteer.RequestVolunteerSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Goal2_MedicalRecords.MedicalRecordsSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Goal3_CheckupSchedule.CheckupScheduleSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Goal4_RequestExtraMedicine.RequestExtraMedicineSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Goal6_RequestMedicalCampaign.RequestMedicalCampaignSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Goal7_RequestExtraHoliday.RequestExtraHolidaySceneFxmlController;
import mainpkg.Saima.User4_Doctor.Goal8_MedicalReport.MedicalReportSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Profile.ProfileSceneFxmlController;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DoctorDashBoardSceneFxmlController implements Initializable {

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
         Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Profile/ProfileSceneFxml.fxml")) ;
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
        stage.setTitle("Medical Records Info") ;
        stage.show() ;
    }

    @FXML
    private void checkupScheduleOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Goal3_CheckupSchedule/CheckupScheduleSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        CheckupScheduleSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Checkup Schedule") ;
        stage.show() ;
    }

    @FXML
    private void requestExtraMedicineOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Goal4_RequestExtraMedicine/RequestExtraMedicineSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        RequestExtraMedicineSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Checkup Schedule") ;
        stage.show() ;
    }
    


    @FXML
    private void requestExtraHolidayOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Goal7_RequestExtraHoliday/RequestExtraHolidaySceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        RequestExtraHolidaySceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Holiday") ;
        stage.show(); 
    }

    @FXML
    private void medicialReportOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Goal8_MedicalReport/MedicalReportSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        MedicalReportSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Medical Report") ;
        stage.show(); 
    }

    @FXML
    private void signOutOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Login/LoginSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
      
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Login") ;
        stage.show() ;
        
    }

    @FXML
    private void requestMedicalCampaignOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Goal6_RequestMedicalCampaign/RequestMedicalCampaignSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        RequestMedicalCampaignSceneFxmlController rmcs = myLoader.getController() ;

        rmcs.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Medical Campaign") ;
        stage.show(); 
    }

    @FXML
    private void RequestVolunteerOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Goal5_RequestVolunteer/RequestVolunteerSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        RequestVolunteerSceneFxmlController psc = myLoader.getController() ;

//        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Request For Volunteer") ;
        stage.show() ;
    }
    
}
