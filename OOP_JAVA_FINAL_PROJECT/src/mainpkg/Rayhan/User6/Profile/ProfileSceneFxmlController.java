package mainpkg.Rayhan.User6.Profile;

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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.User;
import mainpkg.Rayhan.User6.DashBoard6SceneFxmlController;
import mainpkg.Rayhan.User6.EducationCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ProfileSceneFxmlController implements Initializable {

    @FXML    private Label statusLabel;
    @FXML    private Label nameLabel;
    @FXML    private Label idLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label pNLabel;
    @FXML    private Label emailLabel;
    @FXML    private Label genderLabel;
    
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
        statusLabel.setText(user.getStatus()) ;
        nameLabel.setText(user.getName()) ;
        idLabel.setText(Integer.toString(user.getId())) ;
        userTypeLabel.setText(user.getUserType()) ;
        pNLabel.setText(user.getPhoneNo()) ;
        emailLabel.setText(user.getEmail()) ;
        genderLabel.setText(user.getGender()) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoard6SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard6SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void changePWOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/Profile/ChangePWSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ChangePWSceneFxmlController cpc = myLoader.getController() ;
        cpc.set(user) ;

        Stage stage = new Stage() ;
        stage.setScene(myScene) ;
        stage.getIcons().add(new Image("/image/campIcon.jpg")) ;
        stage.setTitle("Volunteer Coordinator Change Password") ;
        stage.show() ;
    }
    
}