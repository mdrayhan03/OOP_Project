package mainpkg.Rayhan.User5.Goal4_VRequest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class VolunteerRequestSceneFxmlController implements Initializable {

    @FXML    private ComboBox<?> requestIdComboBox;
    @FXML    private TableView<?> requestTableView;
    @FXML    private TableColumn<?, ?> idTableColumn;
    @FXML    private TableColumn<?, ?> reasonTableColumn;
    @FXML    private TableColumn<?, ?> timeTableColumn;
    @FXML    private TableColumn<?, ?> placeTableColumn;
    @FXML    private TableColumn<?, ?> dateTableColumn;
    @FXML    private TableColumn<?, ?> amountTableColumn;
    @FXML    private TableColumn<?, ?> statusTableColumn;

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
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void acceptOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void rejectOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void acceptListOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal4_VRequest/AcceptLIstSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = new Stage() ;
        stage.setScene(myScene) ;
        stage.getIcons().add(new Image("/image/campIcon.jpg")) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }
    
}
