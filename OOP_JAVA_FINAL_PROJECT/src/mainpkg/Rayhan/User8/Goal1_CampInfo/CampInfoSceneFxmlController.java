package mainpkg.Rayhan.User8.Goal1_CampInfo;

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
public class CampInfoSceneFxmlController implements Initializable {

    @FXML    private Label doctorLabel;
    @FXML    private Label totalRefugeeLabel;
    @FXML    private Label maleRefugeeLabel;
    @FXML    private Label femaleRefugeeLabel;
    @FXML    private Label teacherLabel;
    @FXML    private Label volunteerLabel;
    @FXML    private Label studentLabel;

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
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
//                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoardSceneFxml.fxml")) ;
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/DashBoardSceneFxml.fxml")) ;
                    root = (Parent) myLoader.load() ;
                    Scene myScene = new Scene(root) ;

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    stage.setScene(myScene) ;
                    stage.setTitle("NGO DashBoard") ;
                    stage.show() ;
    }
    
}
