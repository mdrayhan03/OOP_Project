package mainpkg.Rayhan.User5.Goal4_VRequest;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class VolunteerRequestSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> requestIdComboBox;
    @FXML    private TableView<RequestedVolunteer> requestTableView;
    @FXML    private TableColumn<RequestedVolunteer, String> idTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> timeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> placeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Date> dateTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Integer> amountTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> statusTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> nameTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> uTypeTableColumn;
    
    ObservableList<RequestedVolunteer> list = FXCollections.observableArrayList() ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
//    public User get() {
//        return user ;
//    }
    public void set() {
        
    }
    
    public void tableShow() {
        requestTableView.setItems(list) ;
        for(RequestedVolunteer rv: list) {
            requestIdComboBox.getItems().add(rv.getId()) ;
        }
    }
    
    public void fileRead() {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<RequestedVolunteer,String>("id"));
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<RequestedVolunteer,String>("time"));
        placeTableColumn.setCellValueFactory(new PropertyValueFactory<RequestedVolunteer,String>("place"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<RequestedVolunteer,Date>("date"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<RequestedVolunteer,Integer>("amount"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<RequestedVolunteer,String>("status"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<RequestedVolunteer,String>("requesterId"));
        uTypeTableColumn.setCellValueFactory(new PropertyValueFactory<RequestedVolunteer,String>("userType"));
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
            if (rv.getId() == requestIdComboBox.getValue()) {
                rv.setStatus("Accepted");
//                user.setVolunteer(rv.getAmount()) ;
                break ;
            }
        }
    }

    @FXML
    private void rejectOnMouseClick(MouseEvent event) {
        for (RequestedVolunteer rv: list) {
            if (rv.getId() == requestIdComboBox.getValue()) {
                rv.setStatus("Rejected");
            }
        }
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
