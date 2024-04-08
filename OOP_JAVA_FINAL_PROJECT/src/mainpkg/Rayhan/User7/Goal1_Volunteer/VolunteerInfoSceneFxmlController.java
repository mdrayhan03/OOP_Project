package mainpkg.Rayhan.User7.Goal1_Volunteer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class VolunteerInfoSceneFxmlController implements Initializable {

    @FXML    private TableView<?> volunteerInfoTableView;
    @FXML    private TableColumn<?, ?> idTableColumn;
    @FXML    private TableColumn<?, ?> nameTableColumn;
    @FXML    private TableColumn<?, ?> pNTableColumn;
    @FXML    private TableColumn<?, ?> addedByTableColumn;
    @FXML    private TextField nameTextField;
    @FXML    private TextField pNTextField;

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
    private void backButtonOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge") ;
        stage.show() ;
    }

    @FXML
    private void addVolunteerOnMouseClick(MouseEvent event) {
    }
    
}
