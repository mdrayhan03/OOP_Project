package mainpkg.Rayhan.User5.Goal3_AEReport;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rayhan.User5.Goal3_AEReport.AEReport;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User7.SecurityIncharge;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class AidExecutiveReportSceneFxmlController implements Initializable {

    @FXML    private TextField ddTextField;
    @FXML    private TextField subjectTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextArea reportBodyTextArea;
    @FXML    private ComboBox<Integer> idComboBox;
    
    ObservableList<SecurityIncharge> scList = FXCollections.observableArrayList() ;
    VolunteerCoordinator user ;
    Alert alert ;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public User get() {
        return user ;
    }
    
    public void set(VolunteerCoordinator u) {
        user = u ;
    }
    
    public void setComboBox() {
        for (SecurityIncharge sc: scList) {
            idComboBox.getItems().add(sc.getId()) ;
        }
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
    private void submitOnMouseClick(MouseEvent event) throws IOException {
        Boolean rtn = true ;
        Integer receiverId , dd = null , mm = null , yyyy = null ;
        String subject = "" , des = "" , sdd = "" , smm = "" , syyyy = "" ;
        
        receiverId = idComboBox.getValue() ;
        if (receiverId == null) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Security Incharge ID Error") ;
            alert.setContentText("ID must.") ;
        }
        
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        
        if (sdd.length() != 0 || smm.length() != 0 || syyyy.length() != 0){
        
            dd = Integer.parseInt(sdd) ;
            mm = Integer.parseInt(smm) ;
            yyyy = Integer.parseInt(syyyy) ;
        }
        
        if (dd == null || mm == null || yyyy == null) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Date Error.") ;           
            alert.setContentText("DD/MM/YYYY Required.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        Date doa = new Date(dd , mm , yyyy) ;
        if (doa.isValid() == false) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Date Error.") ;
            alert.setContentText("Date is not Valid.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        subject = subjectTextField.getText() ;
        if (subject.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error.") ;
            alert.setContentText("Subject must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        des = reportBodyTextArea.getText() ;
        if (subject.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error.") ;
            alert.setContentText("Description must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (rtn == true) {
            if (receiverId == null) {
                for (SecurityIncharge sc: scList) {
                    AEReport ae = user.reportToAidExecutive(subject , user.getId() , sc.getId() , des , doa) ;
                }
            }
            else {
                AEReport ae = user.reportToAidExecutive(subject , user.getId() , receiverId , des , doa) ;
        
                Parent root = null ;
                FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal3_AEReport/ShowReportFxml.fxml")) ;
                root = (Parent) myLoader.load() ;
                Scene myScene = new Scene(root) ;
        
                ShowReportFxmlController src = myLoader.getController() ;
                src.set(ae) ;

                Stage stage = new Stage() ;
                stage.setScene(myScene) ;
                stage.getIcons().add(new Image("/image/campIcon.jpg")) ;
                stage.setTitle("Volunteer Coordinator ShowReport") ;
                stage.show() ;
            }
            alert = new Alert(Alert.AlertType.CONFIRMATION) ;
            alert.setHeaderText("Confirmation") ;
            alert.setContentText("Report submitted sucessfully.") ;
            alert.showAndWait() ;
        }
    }
    
}
