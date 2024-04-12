package mainpkg.Rayhan.User6.Goal1_Schedule;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rayhan.User5.Goal4_VRequest.RequestedVolunteer;
import mainpkg.Rayhan.User6.DashBoard6SceneFxmlController;
import mainpkg.Rayhan.User6.EducationCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ScheduleSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> teacherIdComboBox;
    @FXML    private ComboBox<String> courseidComboBox;
    @FXML    private ComboBox<String> timeComboBox;
    @FXML    private ComboBox<String> placeComboBox;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TableView<Schedule> scheduleTableView;
    @FXML    private TableColumn<Schedule , String> idTableColumn;
    @FXML    private TableColumn<Schedule , String> teacherNameTableColumn;
    @FXML    private TableColumn<Schedule , String> courseNameTableColumn;
    @FXML    private TableColumn<Schedule , String> timeTableColumn;
    @FXML    private TableColumn<Schedule , String> placeTableColumn;
    @FXML    private TableColumn<Schedule , Date> dateTableColumn;
    
    ObservableList<Schedule> list = FXCollections.observableArrayList() ;
    Time_Place tm = new Time_Place() ;
    Alert alert ;
    EducationCoordinator user ;

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
        scheduleTableView.setItems(list) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        timeComboBox.setItems(tm.getTuitionTime()) ;
        placeComboBox.setItems(tm.getTuitionPlace()) ;
        
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        teacherNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("teacherName")) ;
        courseNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseName")) ;
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<>("time")) ;
        placeTableColumn.setCellValueFactory(new PropertyValueFactory<>("place")) ;
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date")) ;
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoard6SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard6SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void scheduleOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String teacherId = "" , teacherName = "" , courseId = "" ,  courseName = "" , time = "" , place = "" , sdd = "" , smm = "" , syyyy = "" ;
        int dd = 0 , mm = 0 , yyyy = 0 ;
        
        teacherId = teacherIdComboBox.getValue() ;
        courseId = courseidComboBox.getValue() ;
        time = timeComboBox.getValue() ;
        place = placeComboBox.getValue() ;
        
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        
        if(sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date Must") ;
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
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date is not Valid.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (rtn == true) {
            Schedule sc = user.maintainSchedule(teacherId, teacherName, courseId, courseName, time, place, date) ;
//            fileWrite() ;
        }
        
    }
    
    
}
