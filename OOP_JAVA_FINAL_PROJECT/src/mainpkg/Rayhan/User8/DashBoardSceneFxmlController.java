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

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class DashBoardSceneFxmlController implements Initializable {

    @FXML    private Label nameLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label idLabel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profileOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
//                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoardSceneFxml.fxml")) ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/Profile/ProfileSceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("Education Coordinator") ;
                    stage.show() ;
    }

    @FXML
    private void campInfoOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void managementInfoOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void stockInfoOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void donationOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void educationOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void medicalOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void campaignOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void reportOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void signoutOnMouseClick(MouseEvent event) {
    }
    
}
