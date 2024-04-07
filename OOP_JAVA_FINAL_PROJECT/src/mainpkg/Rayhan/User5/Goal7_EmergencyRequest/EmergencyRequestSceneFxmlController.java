package mainpkg.Rayhan.User5.Goal7_EmergencyRequest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rayhan.User5.Goal4_VRequest.RequestedVolunteer;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class EmergencyRequestSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> idComboBox;
    @FXML    private TableView<RequestedVolunteer> requestTableView;
    @FXML    private TableColumn<RequestedVolunteer, String> idTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> reasonTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> timeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> placeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Date> dateTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> amountTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> statusTableColumn;
    
    ObservableList<RequestedVolunteer> list = FXCollections.observableArrayList() ;

    /**
     * Initializes the controller class.
     */
    
    public void set() {
        
    }
    
    public void tableShow() {
        requestTableView.setItems(list) ;
        for(RequestedVolunteer rv: list) {
            idComboBox.getItems().add(rv.getId()) ;
        }
    }
    
    public void fileRead() {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoard5SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void acceptOnMouseClick(MouseEvent event) {
        for (RequestedVolunteer rv: list) {
            if (rv.getId() == idComboBox.getValue()) {
                rv.setStatus("Accepted");
//                user.setVolunteer(rv.getAmount()) ;
                break ;
            }
        }
    }
    
}
