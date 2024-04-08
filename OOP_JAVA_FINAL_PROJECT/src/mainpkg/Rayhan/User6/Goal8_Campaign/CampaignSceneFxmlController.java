package mainpkg.Rayhan.User6.Goal8_Campaign;

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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;
import mainpkg.Rayhan.User5.VolunteerCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class CampaignSceneFxmlController implements Initializable {

    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private ComboBox<String> timeComboBox;
    @FXML    private ComboBox<String> placeComboBox;
    @FXML    private TextField reasonTextField;
    @FXML    private TextArea descriptionTextArea;
    @FXML    private TableView<Campaign> campaignTableView;
    @FXML    private TableColumn<Campaign, String> idTableColumn;
    @FXML    private TableColumn<Campaign, String> reasonTableColumn;
    @FXML    private TableColumn<Campaign, Date> dateTableColumn;
    @FXML    private TableColumn<Campaign, String> timeTableColumn;
    @FXML    private TableColumn<Campaign, String> placeTableColumn;
    @FXML    private TableColumn<Campaign, String> descriptionTableColumn;
    @FXML    private TableColumn<Campaign, String> statusTableColumn;
    
    VolunteerCoordinator user ;
    Alert alert ;
    Time_Place tp = new Time_Place() ;
    ObservableList<Campaign> table = FXCollections.observableArrayList() ;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void setTable() {
        campaignTableView.setItems(table) ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        timeComboBox.setItems(tp.getCampaignTime()) ;
        placeComboBox.setItems(tp.getCampaignPlace()) ;
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("id")) ;
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("reason")) ;
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,Date>("date")) ;
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("time")) ;
        placeTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("place")) ;
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("des")) ;
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<Campaign,String>("status")) ;
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoard6SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void applyOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String reason = "" , des = "" , time = "" , place = "" , sdd = "" , smm = "" , syyyy = "" ;
        int dd = 0 , mm = 0 , yyyy = 0 ;
        
        reason = reasonTextField.getText() ;
        if (reason.length() == 0){
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Reason must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        des = descriptionTextArea.getText() ;
        if (des.length() == 0){
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Description must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        time = timeComboBox.getValue() ;
        if (time.length() == 0){
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Time must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        place = placeComboBox.getValue() ;
        if (place.length() == 0){
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Place must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        if (sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Date must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        else {
            dd = Integer.parseInt(sdd) ;
            mm = Integer.parseInt(smm) ;
            yyyy = Integer.parseInt(syyyy) ;
        }
        Date date = new Date(dd , mm , yyyy) ;
            if (date.isValid() == false){
                alert = new Alert(Alert.AlertType.ERROR) ;
                alert.setHeaderText("Error") ;
                alert.setContentText("Invalid Date.") ;
                rtn = false ;
                alert.showAndWait() ;
        }            
        
        //File read to check is slot empty or not
        
        if (rtn == true) {
            Campaign cam = user.requestForCampaign(time,  place,  reason,  user.getUserType(), des, user.getName(), date, user.getId()) ;
        
            System.out.println("Pressed");
            alert = new Alert(Alert.AlertType.INFORMATION) ;
            alert.setHeaderText("Done") ;
            alert.setContentText("Apply for Campaign is sucessfull.") ;
            alert.showAndWait() ;
        }
    }
    
}
