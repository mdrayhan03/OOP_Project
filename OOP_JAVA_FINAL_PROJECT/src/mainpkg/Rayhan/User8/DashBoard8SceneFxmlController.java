package mainpkg.Rayhan.User8;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.Rayhan.User5.Goal6_Campaign.CampaignSceneFxmlController;
import mainpkg.Rayhan.User8.Goal1_CampInfo.CampInfoSceneFxmlController;
import mainpkg.Rayhan.User8.Goal2_ManagementInfo.ManagementInfoSceneFxmlController;
import mainpkg.Rayhan.User8.Goal3_StockInfo.StockInfoSceneFxmlController;
import mainpkg.Rayhan.User8.Goal4_Donation.DonationSceneFxmlController;
import mainpkg.Rayhan.User8.Goal5_Education.EducationFacilitiesSceneFxmlController;
import mainpkg.Rayhan.User8.Goal6_Medical.MedicalFacilitiesSceneFxmlController;
import mainpkg.Rayhan.User8.Goal8_Report.ReportSceneFxmlController;
import mainpkg.Rayhan.User8.Profile.ProfileSceneFxmlController;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class DashBoard8SceneFxmlController implements Initializable {

    @FXML    private Label nameLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label idLabel;
    
    NGOs user ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public NGOs get() {
        return user ;
    }
    
    public void set(NGOs u) {
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
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Profile/ProfileSceneFxml.fxml")) ;
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
    private void campInfoOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Goal1_CampInfo/CampInfoSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        CampInfoSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void managementInfoOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Goal2_ManagementInfo/ManagementInfoSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ManagementInfoSceneFxmlController psc = myLoader.getController() ;
//        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void stockInfoOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Goal3_StockInfo/StockInfoSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        StockInfoSceneFxmlController psc = myLoader.getController() ;
//        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void donationOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Goal4_Donation/DonationSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DonationSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void educationOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Goal5_Education/EducationFacilitiesSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        EducationFacilitiesSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void medicalOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Goal6_Medical/MedicalFacilitiesSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        MedicalFacilitiesSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void campaignOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Goal7_Campaign/CampaignSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        CampaignSceneFxmlController psc = myLoader.getController() ;
//        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void reportOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Goal8_Report/ReportSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ReportSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator Profile") ;
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
        stage.setTitle("Education Coordinator Profile") ;
        stage.show() ;
    }
    
}
