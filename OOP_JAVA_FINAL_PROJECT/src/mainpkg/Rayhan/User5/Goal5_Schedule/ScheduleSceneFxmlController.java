package mainpkg.Rayhan.User5.Goal5_Schedule;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rayhan.User5.DashBoard5SceneFxmlController;
import mainpkg.Rayhan.User5.Goal4_VRequest.RequestedVolunteer;
import mainpkg.Rayhan.User5.VolunteerCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ScheduleSceneFxmlController implements Initializable {

    @FXML    private TableView<RequestedVolunteer> scheduleTableView;
    @FXML    private TableColumn<RequestedVolunteer , String> idTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> nameTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> uTypeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> timeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> placeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , Date> dateTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> amountTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , Integer> acceptedTableColumn;
    
    VolunteerCoordinator user ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public VolunteerCoordinator get() {
        return user ;
    }
    
    public void set(VolunteerCoordinator u) {
        user = u ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        placeTableColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("requesterId"));
        uTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("userType"));
        acceptedTableColumn.setCellValueFactory(new PropertyValueFactory<>("accepterId"));
        
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard5SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }
    
}
