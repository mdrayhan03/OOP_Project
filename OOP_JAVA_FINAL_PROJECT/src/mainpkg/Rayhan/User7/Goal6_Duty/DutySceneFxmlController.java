package mainpkg.Rayhan.User7.Goal6_Duty;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rayhan.User7.SecurityIncharge;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class DutySceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> timeComboBox;
    @FXML    private ComboBox<String> placeComboBox;
    @FXML    private TextField amountTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TableView<Duty> dutyTableView;
    @FXML    private TableColumn<Duty , String> idTableColumn;
    @FXML    private TableColumn<Duty , String> timeTableColumn;
    @FXML    private TableColumn<Duty , String> placeTableColumn;
    @FXML    private TableColumn<Duty , String> dateTableColumn;
    @FXML    private TableColumn<Duty , String> amountTableColumn;
    @FXML    private Label tVLabel;
    @FXML    private Label fVLabel1;
    
    ObservableList<Duty> list = FXCollections.observableArrayList() ;
    SecurityIncharge user ;
    Alert alert ;
    Time_Place tp = new Time_Place() ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void set(SecurityIncharge u) {
        user = u ;
    }
    
    public void tableShow() {
        dutyTableView.setItems(list) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        timeComboBox.setItems(tp.getSecurityTime()) ;
        timeComboBox.setValue(tp.getSecurityTime().get(0)) ;
        placeComboBox.setItems(tp.getSecurityPlace()) ;
        placeComboBox.setValue(tp.getSecurityPlace().get(0)) ;
        tVLabel.setText(Integer.toString(user.getVolunteerAmount())) ;
        fVLabel1.setText(Integer.toString(user.getVolunteerFree())) ;
    }    

    @FXML
    private void backOnMouseCLick(MouseEvent event) throws IOException {
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
    private void dutyOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String time , place , sdd = "" , smm = "" , syyyy = "" ;
        Integer amount = 0 , dd = 0 , mm = 0 , yyyy = 0 ;
        
        time = timeComboBox.getValue() ;
        place = placeComboBox.getValue() ;
        
        amount = Integer.parseInt(amountTextField.getText()) ;
        
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        if(sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
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
        if(date.isValid() == false) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date is not Valid.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (rtn == true) {
            Duty du = user.setDuty(time , place , amount , date) ;
            list.add(du) ;
            amountTextField.clear() ;
            ddTextField.clear() ;
            mmTextField.clear() ;
            yyyyTextField.clear() ;
        }
        
    }
    
}
