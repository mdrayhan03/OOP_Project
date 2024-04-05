package mainpkg.Rayhan.User8.Goal2_ManagementInfo;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ManagementInfoSceneFxmlController implements Initializable {

    @FXML    private TableView<?> campManagerTableView;
    @FXML    private TableColumn<?, ?> campIdTableColumn;
    @FXML    private TableColumn<?, ?> campNameTableColumn;
    @FXML    private TableColumn<?, ?> campPNTableColumn;
    @FXML    private TableColumn<?, ?> campEmailTableColumn;
    @FXML    private TableColumn<?, ?> campDoBTableColumn;
    @FXML    private TableView<?> aidTableView;
    @FXML    private TableColumn<?, ?> aidIdTableColumn;
    @FXML    private TableColumn<?, ?> aidNameTableColumn;
    @FXML    private TableColumn<?, ?> aidPNTableColumn;
    @FXML    private TableColumn<?, ?> aidEmailTableColumn;
    @FXML    private TableColumn<?, ?> aidDoBTableColumn;
    @FXML    private TableView<?> doctorTableView;
    @FXML    private TableColumn<?, ?> doctorIdTableColumn;
    @FXML    private TableColumn<?, ?> doctorNameTableColumn;
    @FXML    private TableColumn<?, ?> doctorPNTableColumn;
    @FXML    private TableColumn<?, ?> doctorEmailTableColumn;
    @FXML    private TableColumn<?, ?> doctorDoBTableColumn;
    @FXML    private TableView<?> volunteerTableView;
    @FXML    private TableColumn<?, ?> volunteerIdTableColumn;
    @FXML    private TableColumn<?, ?> volunteerNameTableColumn;
    @FXML    private TableColumn<?, ?> volunteerPNTableColumn;
    @FXML    private TableColumn<?, ?> volunteerEmailTableColumn;
    @FXML    private TableColumn<?, ?> volunteerDoBTableColumn;
    @FXML    private TableView<?> educationTableView;
    @FXML    private TableColumn<?, ?> educationIdTableColumn;
    @FXML    private TableColumn<?, ?> educationNameTableColumn;
    @FXML    private TableColumn<?, ?> educationPNTableColumn;
    @FXML    private TableColumn<?, ?> educationEmailTableColumn;
    @FXML    private TableColumn<?, ?> educationDoBTableColumn;
    @FXML    private TableView<?> securityTableView;
    @FXML    private TableColumn<?, ?> securityIdTableColumn;
    @FXML    private TableColumn<?, ?> securityNameTableColumn;
    @FXML    private TableColumn<?, ?> securityPNTableColumn;
    @FXML    private TableColumn<?, ?> securityEmailTableColumn;
    @FXML    private TableColumn<?, ?> securityDoBTableColumn;
    
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
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator") ;
        stage.show() ;
    }
    
}
