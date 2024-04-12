package mainpkg.Rayhan.User6.Goal3_RequestVolunteer;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rayhan.User5.Goal4_VRequest.RequestedVolunteer;
import mainpkg.Rayhan.User6.EducationCoordinator;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class RequestVolunteerSceneFxmlController implements Initializable {

    @FXML    private TextField reasonTextField;
    @FXML    private TextArea descriptionTextArea;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextField amountTextField;
    @FXML    private ComboBox<String> timeComboBox;
    @FXML    private ComboBox<String> placeComboBox;
    @FXML    private TableView<RequestedVolunteer> requestTableView;
    @FXML    private TableColumn<RequestedVolunteer , String> idTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> reasonTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> desTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> placeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> timeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , Date> dateTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , Integer> amountTableColumn;
    @FXML    private TableColumn<RequestedVolunteer , String> statusTableColumn;
   
    ObservableList<RequestedVolunteer> list = FXCollections.observableArrayList() ;
    EducationCoordinator user ;
    Time_Place tp = new Time_Place() ;
    Alert alert ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public EducationCoordinator get() {
        return user ;
    }
    
    public void set(EducationCoordinator u) {
        user = u ;
    }
    
    public void tableShow() {
        requestTableView.setItems(list) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        timeComboBox.setItems(tp.getCampaignTime()) ;
        timeComboBox.setValue(tp.getCampaignTime().get(0)) ;
        placeComboBox.setItems(tp.getCampaignPlace()) ;
        timeComboBox.setValue(tp.getCampaignPlace().get(0)) ;
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void requestOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String reason = "" , des = "" , sdd = "" , smm = "" , syyyy = "" , time = "" , place = "" ;
        int amount = 0 , dd = 0 , mm = 0 , yyyy = 0 ;
        
        reason = reasonTextField.getText() ;
        if (reason.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error");
            alert.setContentText("Reason must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        des = descriptionTextArea.getText() ;
        if (des.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error");
            alert.setContentText("Description must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        amount = Integer.parseInt(amountTextField.getText()) ;
        
        sdd = ddTextField.getText() ;
        smm = ddTextField.getText() ;
        syyyy = ddTextField.getText() ;
        if (sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error");
            alert.setContentText("Date must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        else {
            dd = Integer.parseInt(sdd) ;
            mm = Integer.parseInt(smm) ;
            yyyy = Integer.parseInt(syyyy) ;
        }
        
        Date date = new Date(dd , mm , yyyy) ;
        if (date.isValid() == false) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error");
            alert.setContentText("Date is not Valid.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (rtn == true) {
            RequestedVolunteer rq = user.requestForVolunteer(user.getId(), user.getName(), amount, reason, des, user.getUserType(), time, place, date) ;
            
        }
    }
    
}
