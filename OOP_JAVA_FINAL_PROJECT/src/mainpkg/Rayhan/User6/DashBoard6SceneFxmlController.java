package mainpkg.Rayhan.User6;

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
import mainpkg.Rayhan.User6.Goal1_Schedule.ScheduleSceneFxmlController;
import mainpkg.Rayhan.User6.Goal2_Teacher.TeacherSceneFxmlController;
import mainpkg.Rayhan.User6.Goal3_RequestVolunteer.RequestVolunteerSceneFxmlController;
import mainpkg.Rayhan.User6.Goal4_Student.StudentSceneFxmlController;
import mainpkg.Rayhan.User6.Goal5_Needs.NeedsSceneFxmlController;
import mainpkg.Rayhan.User6.Goal6_Progress.ProgressSceneFxmlController;
import mainpkg.Rayhan.User6.Goal7_Storage.StorageSceneFxmlController;
import mainpkg.Rayhan.User6.Goal8_Campaign.CampaignSceneFxmlController;
import mainpkg.Rayhan.User6.Profile.ProfileSceneFxmlController;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class DashBoard6SceneFxmlController implements Initializable {

    @FXML    private Label nameLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label idLabel;
    
    Alert alert ;
    EducationCoordinator user ;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
        public EducationCoordinator get() {
        return user ;
    }
    
    public void set(EducationCoordinator u) {
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
    private void profileOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Profile/ProfileSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ProfileSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void scheduleOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal1_Schedule/ScheduleSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ScheduleSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Schedule") ;
        stage.show() ;
    }

    @FXML
    private void teacherOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal2_Teacher/TeacherSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        TeacherSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Teacher") ;
        stage.show() ;
    }

    @FXML
    private void requestForVolunteerOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal3_RequestVolunteer/RequestVolunteerSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        RequestVolunteerSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Request for Volunteer") ;
        stage.show() ;
    }

    @FXML
    private void studentOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal4_Student/StudentSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        StudentSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Student") ;
        stage.show() ;
    }

    @FXML
    private void needsOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal5_Needs/NeedsSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        NeedsSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Request") ;
        stage.show() ;
    }

    @FXML
    private void progressOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal6_Progress/ProgressSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ProgressSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Schedule") ;
        stage.show() ;
    }

    @FXML
    private void storageOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal7_Storage/StorageSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        StorageSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Storage") ;
        stage.show() ;
    }

    @FXML
    private void CampaignOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Goal8_Campaign/CampaignSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        CampaignSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Campaign") ;
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
