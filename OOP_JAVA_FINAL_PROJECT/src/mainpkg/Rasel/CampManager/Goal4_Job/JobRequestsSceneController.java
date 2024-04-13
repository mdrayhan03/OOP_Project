package mainpkg.Rasel.CampManager.Goal4_Job;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rasel
 */
public class JobRequestsSceneController implements Initializable {

    @FXML
    private TableView<?> jobRequestsTableView;
    @FXML
    private TableColumn<?, ?> jobRequestRefugeeIdTC;
    @FXML
    private TableColumn<?, ?> jobRequestRefugeNameTC;
    @FXML
    private TableColumn<?, ?> jobRequestDescriptionTC;
    @FXML
    private TableColumn<?, ?> jobRequestActionTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void jobRequestsBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/CampManager/Goal4_Job/manageJobsScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }
    
}
