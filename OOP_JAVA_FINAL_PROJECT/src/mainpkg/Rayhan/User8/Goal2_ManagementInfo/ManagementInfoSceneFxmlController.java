package mainpkg.Rayhan.User8.Goal2_ManagementInfo;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User6.EducationCoordinator;
import mainpkg.Rayhan.User7.SecurityIncharge;
import mainpkg.Rayhan.User8.NGOs;

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
    @FXML    private TableView<VolunteerCoordinator> volunteerTableView;
    @FXML    private TableColumn<VolunteerCoordinator, Integer> volunteerIdTableColumn;
    @FXML    private TableColumn<VolunteerCoordinator, String> volunteerNameTableColumn;
    @FXML    private TableColumn<VolunteerCoordinator, String> volunteerPNTableColumn;
    @FXML    private TableColumn<VolunteerCoordinator, String> volunteerEmailTableColumn;
    @FXML    private TableColumn<VolunteerCoordinator, Date> volunteerDoBTableColumn;
    @FXML    private TableView<EducationCoordinator> educationTableView;
    @FXML    private TableColumn<EducationCoordinator, Integer> educationIdTableColumn;
    @FXML    private TableColumn<EducationCoordinator, String> educationNameTableColumn;
    @FXML    private TableColumn<EducationCoordinator, String> educationPNTableColumn;
    @FXML    private TableColumn<EducationCoordinator, String> educationEmailTableColumn;
    @FXML    private TableColumn<EducationCoordinator, Date> educationDoBTableColumn;
    @FXML    private TableView<SecurityIncharge> securityTableView;
    @FXML    private TableColumn<SecurityIncharge, Integer> securityIdTableColumn;
    @FXML    private TableColumn<SecurityIncharge, String> securityNameTableColumn;
    @FXML    private TableColumn<SecurityIncharge, String> securityPNTableColumn;
    @FXML    private TableColumn<SecurityIncharge, String> securityEmailTableColumn;
    @FXML    private TableColumn<SecurityIncharge, Date> securityDoBTableColumn;
    
    NGOs user ; 
    ObservableList<VolunteerCoordinator> vcList = FXCollections.observableArrayList() ;
    ObservableList<EducationCoordinator> ecList = FXCollections.observableArrayList() ;
    ObservableList<SecurityIncharge> siList = FXCollections.observableArrayList() ;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public NGOs get() {
        return user ;
    }
    
    public void tableShow() {
        volunteerTableView.setItems(vcList) ;
        educationTableView.setItems(ecList) ;
        securityTableView.setItems(siList) ;
    }
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
