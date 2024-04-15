package mainpkg.Rayhan.User5;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static javax.swing.text.StyleConstants.Background;
import mainpkg.AbstractClass.User;
import mainpkg.Rayhan.User5.Goal1_Volunteer.VolunteerInfoSceneFxmlController;
import mainpkg.Rayhan.User5.Goal2_SIReport.SecurityInchargeReportSceneFxmlController;
import mainpkg.Rayhan.User5.Goal3_AEReport.AidExecutiveReportSceneFxmlController;
import mainpkg.Rayhan.User5.Goal4_VRequest.VolunteerRequestSceneFxmlController;
import mainpkg.Rayhan.User5.Profile.ProfileSceneFxmlController;
import mainpkg.Rayhan.User5.Goal5_Schedule.ScheduleSceneFxmlController;
import mainpkg.Rayhan.User5.Goal6_Campaign.CampaignSceneFxmlController;
import mainpkg.Rayhan.User5.Goal7_EmergencyRequest.EmergencyRequestSceneFxmlController;
import mainpkg.Rayhan.User5.Goal8_Report.ReportSceneFxmlController;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class DashBoard5SceneFxmlController implements Initializable {

    @FXML    private Label nameLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label idLabel;
    
    Alert alert ;
    VolunteerCoordinator user ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public VolunteerCoordinator get() {
        return user ;
    }
    
    public void set(VolunteerCoordinator u) {
        user = u ;
        System.out.println(user) ;
        nameLabel.setText(user.getName());
        userTypeLabel.setText(user.getUserType());
        idLabel.setText(Integer.toString(user.getId()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void profileOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Profile/ProfileSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ProfileSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;
        

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void volunteerOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal1_Volunteer/VolunteerInfoSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        VolunteerInfoSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Volunteer Info") ;
        stage.show() ;
    }

    @FXML
    private void getRequestOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal4_VRequest/VolunteerRequestSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        VolunteerRequestSceneFxmlController vrc = myLoader.getController() ;
        vrc.set(this.get()) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Volunteer Request") ;
        stage.show() ;
    }

    @FXML
    private void reportAidExecutiveOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal3_AEReport/AidExecutiveReportSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        AidExecutiveReportSceneFxmlController asc = myLoader.getController() ;
        asc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Aid Executive Report") ;
        stage.show() ;
    }

    @FXML
    private void reportSecurityInchargeOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal2_SIReport/SecurityInchargeReportSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        SecurityInchargeReportSceneFxmlController ssc = myLoader.getController() ;
        ssc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Security Incharge Report") ;
        stage.show() ;
    }

    @FXML
    private void scheduleOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal5_Schedule/ScheduleSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ScheduleSceneFxmlController ssc= myLoader.getController() ;
        ssc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Schedule") ;
        stage.show() ;
    }

    @FXML
    private void requestCampaignOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal6_Campaign/CampaignSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        CampaignSceneFxmlController ssc= myLoader.getController() ;
        ssc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Campaign") ;
        stage.show() ;
    }

    @FXML
    private void emergencyRequestOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal7_EmergencyRequest/EmergencyRequestSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        EmergencyRequestSceneFxmlController ssc= myLoader.getController() ;
        ssc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Campaign") ;
        stage.show() ;
    }

    @FXML
    private void reportOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal8_Report/ReportSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ReportSceneFxmlController ssc= myLoader.getController() ;
        ssc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Report") ;
        stage.show() ;
    }

    @FXML
    private void signoutOnMouseClick(MouseEvent event) throws IOException {
        user.setStatus("Deactive") ; 
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Login/LoginSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Login") ;
        stage.show() ;
    }
}