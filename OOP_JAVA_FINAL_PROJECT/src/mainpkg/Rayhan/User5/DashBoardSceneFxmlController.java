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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class DashBoardSceneFxmlController implements Initializable {

    @FXML    private Label nameLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label idLabel;
    
    Alert alert ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        alert = new Alert(Alert.AlertType.CONFIRMATION) ;
//        alert.setHeaderText("Verification Confirmed.");
    }    

    @FXML
    private void profileOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Profile/ProfileSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator Profile") ;
        stage.show() ;
    }

    @FXML
    private void volunteerOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void getRequestOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void reportAidExecutiveOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void reportSecurityInchargeOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void scheduleOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void requestCampaignOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void emergencyRequestOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void reportOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void signoutOnMouseClick(MouseEvent event) {
    }
    
}
