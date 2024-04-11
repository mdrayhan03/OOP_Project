package mainpkg.Rayhan.User6.Goal2_Teacher;

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

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rayhan.User6.DashBoard6SceneFxmlController;
import mainpkg.Rayhan.User6.EducationCoordinator;
/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class TeacherSceneFxmlController implements Initializable {


    @FXML    private Label showLabel;
    @FXML    private TextField nameTextField;
    @FXML    private TextField pNTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TableView<Teacher> teacherTableView;
    @FXML    private TableColumn<Teacher , String> idTableColumn;
    @FXML    private TableColumn<Teacher , String> nameTableColumn;
    @FXML    private TableColumn<Teacher , String> pNTableColumn;
    @FXML    private TableColumn<Teacher , Date> dojTableColumn;
    @FXML    private Label teacherLabel;
    
    ObservableList<Teacher> list = FXCollections.observableArrayList() ;
    EducationCoordinator user ;
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
        teacherTableView.setItems(list) ;
        teacherLabel.setText(Integer.toString(user.getTeacherAmount())) ;
        user.setTeacherAmount(list.size()) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name")) ;
        pNTableColumn.setCellValueFactory(new PropertyValueFactory<>("pN")) ;
        dojTableColumn.setCellValueFactory(new PropertyValueFactory<>("doj")) ;
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
    private void addTeacherOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String name = "" , pN = "" , sdd = "" , smm = "" , syyyy = "" ;
        int dd = 0 , mm = 0 , yyyy = 0 ;
        
        name = nameTextField.getText() ;
        if (name.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Name Error") ;
            alert.setContentText("Name must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        pN = pNTextField.getText() ;
        if (pN.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Phone No Error") ;
            alert.setContentText("Phone Number must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        
        if(sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        else {
            dd = Integer.parseInt(sdd) ;
            mm = Integer.parseInt(smm) ;
            yyyy = Integer.parseInt(syyyy) ;
        }
        
        Date doj = new Date(dd , mm , yyyy) ;
        if(doj.isValid() == false) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Date Error") ;
            alert.setContentText("Date is not Valid.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (rtn == true) {
            Teacher tc = user.addTeacher(name, pN, doj) ;
            showLabel.setText(tc.toString()) ;
        }
        
    }

}
