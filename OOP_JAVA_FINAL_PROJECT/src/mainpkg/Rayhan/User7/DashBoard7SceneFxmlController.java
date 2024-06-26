package mainpkg.Rayhan.User7;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.Rayhan.User7.Goal1_Volunteer.VolunteerInfoSceneFxmlController;
import mainpkg.Rayhan.User7.Goal2_Refugee.RefugeeInfoSceneFxmlController;
import mainpkg.Rayhan.User7.Goal3_Notice.GetNoticeSceneFxmlController;
import mainpkg.Rayhan.User7.Goal4_Needs.NeedsSceneFxmlController;
import mainpkg.Rayhan.User7.Goal5_CrimeFacts.CrimeFactsSceneFxmlController;
import mainpkg.Rayhan.User7.Goal6_Duty.DutySceneFxmlController;
import mainpkg.Rayhan.User7.Goal7_Holiday.HolidaySceneFxmlController;
import mainpkg.Rayhan.User7.Profile.ProfileSceneFxmlController;
import mainpkg.Rayhan.User7.Goal8_Report.ReportSceneFxmlController;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */

public class DashBoard7SceneFxmlController implements Initializable {

    @FXML    private Label nameLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label idLabel;
    
    SecurityIncharge user ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void set(SecurityIncharge u) {
        user = u ;
        nameLabel.setText(user.getName()) ;
        userTypeLabel.setText(user.getUserType()) ;
        idLabel.setText(Integer.toString(user.getId())) ;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profileOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Profile/ProfileSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ProfileSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge Profile") ;
        stage.show() ;
    }

    @FXML
    private void volunteerOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal1_Volunteer/VolunteerInfoSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        VolunteerInfoSceneFxmlController vsc = myLoader.getController() ;
        vsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge Volunteer") ;
        stage.show() ;
    }

    @FXML
    private void refugeeOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal2_Refugee/RefugeeInfoSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        RefugeeInfoSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge Refugee Info") ;
        stage.show() ;
    }


    @FXML
    private void noticeOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal3_Notice/GetNoticeSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        GetNoticeSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge Notice") ;
        stage.show() ;
    }

    @FXML
    private void holidayOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal7_Holiday/HolidaySceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        HolidaySceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge Holiday") ;
        stage.show() ;
    }

    @FXML
    private void dutyOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal6_Duty/DutySceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DutySceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge Duty Schedule") ;
        stage.show() ;
    }

    @FXML
    private void requestOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal4_Needs/NeedsSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        NeedsSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge Request") ;
        stage.show() ;
    }

    @FXML
    private void reportOnMouseClick(MouseEvent event) throws IOException ,LoadException{
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal8_Report/ReportSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ReportSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge Report") ;
        stage.show() ;
    }

    @FXML
    private void signoutOnMouseClick(MouseEvent event) throws IOException {
        user.setStatus("Deactive");
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
    private void crimeFactsOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal5_CrimeFacts/CrimeFactsSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        CrimeFactsSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge Report") ;
        stage.show() ;
    }
    
}
