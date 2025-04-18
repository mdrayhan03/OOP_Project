package mainpkg.Rasel.Refugee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mainpkg.AbstractClass.User;

/**
 * FXML Controller class
 *
 * @author Rasel
 */
public class RefugeeDashboardSceneController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label userTypeLabel;
    
    Alert alert ;
    Refugee user;
    
    public User get() {
        return user ;
    }
    
     public void set(Refugee u) {
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
    private void refugeeComplaintManagerSceneButtonClick(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Goal5_Complaint/RefugeeComplaintScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.setTitle(" Complaint To Camp Manager") ;
    stage.show();
    }

    @FXML
    private void goRefugeeRulesPageOnButtonClick(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Goal8_Rules/RefugeeRulesScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.setTitle("Camp Rules") ;
    stage.show();
    }

    @FXML
    private void skillAndTrainingPageOnButtonClick(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Goal6_TrainingCenter/TrainingAndSkillScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.setTitle("Training And Skill Center") ;
    stage.show();
    }

    @FXML
    private void goRefugeeJobPageOnButtonClick(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Goal7_Job/RefugeeJobsScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.setTitle("Job Opportunities") ;
    stage.show();
    }

    @FXML
    private void requestFoodOnButtonClick(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Goal1_FoodRequest/FoodRequestScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.setTitle("Request for food") ;
    stage.show();
    }

    @FXML
    private void campaignInfoPageOnButtonClick(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Goal4_CampaignInfo/CulturalCampaignScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.setTitle("Campaign Information") ;
    stage.show();
    }

    @FXML
    private void healthCarePageOnButtonClick(ActionEvent event) throws IOException {
    FXMLLoader mymyLoader = new FXMLLoader(getClass().getResource("Goal2_Healthcare/RefugeeHealthCareScene.fxml"));
    Parent myPage = mymyLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.setTitle("Healthcare Services") ;
    stage.show();
    }

    @FXML
    private void eduInfoPageOnButtonClick(ActionEvent event) throws IOException {
    FXMLLoader mymyLoader = new FXMLLoader(getClass().getResource("Goal3_EduInfo/RefugeeEducationScene.fxml"));
    Parent myPage = mymyLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.setTitle("Educational Information") ;
    stage.show();
    }

    @FXML
    private void refugeeChangePassOnButtonClick(ActionEvent event) throws IOException {
    FXMLLoader mymyLoader = new FXMLLoader(getClass().getResource("RefugeeChangePass/RefugeeChangePassScene.fxml"));
    Parent myPage = mymyLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.setTitle("Change Password") ;
    stage.show();
    }
    
}