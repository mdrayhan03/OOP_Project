
package mainpkg.Saima.User3_AidExcutive;

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
import mainpkg.Login.LoginSceneFxmlController;
import mainpkg.Rayhan.User5.Goal8_Report.ReportSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Goal1_AddFood.AddFoodSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Goal2_DistributeFood.DistributeFoodSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Goal3_MacroFoodDistributionInfo.MacroFoodDistributionInfoSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Goal4_RequestExtraFood.RequestExtraFoodSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Goal5_AddShelter.AddShelterSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Goal6_AllocateShelter.AllocateShelterSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Goal7_RequestExtraShelter.RequestExtraShelterSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Profile.ProfileSceneFxmlController;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AidExcutiveDashBoardSceneFxmlController implements Initializable {

    @FXML    private Label nameLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label idLabel;
    
    Alert alert ;
    AidExcutive user ;

    /**
     * Initializes the controller class.
     */
    public User get() {
        return user ;
    }
    
     public void set(AidExcutive u) {
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
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Profile/ProfileSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ProfileSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;
        

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Aid Excutive Profile") ;
        stage.show() ;
    }

    @FXML
    private void addFoodOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Goal1_AddFood/AddFoodSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        AddFoodSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Add Food Info") ;
        stage.show() ;
    
    }

    @FXML
    private void distributeFoodOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Goal2_DistributeFood/DistributeFoodSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DistributeFoodSceneFxmlController psc = myLoader.getController() ;

        psc.set(user)  ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Distribute Food Info") ;
        stage.show() ;
    
    
    }

    @FXML
    private void macroFoodDistributionInfoOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Goal3_MacroFoodDistributionInfo/MacroFoodDistributionInfoSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        MacroFoodDistributionInfoSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Macro Food Distribution Info") ;
        stage.show() ;
    
    
    }

    @FXML
    private void requestExtraFoodOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Goal4_RequestExtraFood/RequestExtraFoodSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        RequestExtraFoodSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Extra Food Request") ;
        stage.show() ;
    }

    @FXML
    private void addShelterOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Goal5_AddShelter/AddShelterSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        AddShelterSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Add Shelter Info") ;
        stage.show() ;
    }

    @FXML
    private void allocateShelterOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Goal6_AllocateShelter/AllocateShelterSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        AllocateShelterSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Allocate Shelter") ;
        stage.show() ;
    }

    @FXML
    private void requestExtraShelterOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Goal7_RequestExtraShelter/RequestExtraShelterSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        RequestExtraShelterSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Extra Shelter Request") ;
        stage.show() ;
    }

    @FXML
    private void reportOnMouseClicked(MouseEvent event) throws IOException {
       
        
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Goal8_Report/ReportSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        ReportSceneFxmlController rc=myLoader.getController();
        rc.set(user);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Aid Excutive Report") ;
        stage.show() ;
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
    
}
