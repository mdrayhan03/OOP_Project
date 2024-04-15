/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal8_Report;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class FoodReportSceneFxmlController implements Initializable {

    @FXML
    private TextField ddTextField;
    @FXML
    private TextField mmTextField;
    @FXML
    private TextField yyyyTextField;
    @FXML
    private TextField campManagerIdTextField;
    @FXML
    private TextField subjectTextField;
    @FXML
    private TextArea reportBodyTextArea;

    /**
     * Initializes the controller class.
     */
    
    AidExcutive user ;
    Alert alert ;
    ReportList sir ;
    
    public User get() {
        return user ;
    }
    
    public void set(AidExcutive u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClicked(MouseEvent event) throws IOException {
        
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Aid Excutive DashBoard") ;
        stage.show() ;
    
    }

    @FXML
    private void submitOnMouseClick(MouseEvent event) throws IOException {
                 Boolean rtn = true ;
        Integer receiverId = null , dd = null , mm = null , yyyy = null ;
        String subject = "" , des = "" , sdd = "" , smm = "" , syyyy = "" ;
        
        receiverId = Integer.parseInt(campManagerIdTextField.getText()) ;
        if (receiverId == null) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("ID Error") ;
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
            alert.setContentText("Subject must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (rtn == true) {
            Report re = user.report(subject , des , doa) ;
            System.out.println(user.getId() + receiverId + re.getId());
            sir = new ReportList(user.getId() , receiverId , re.getId()) ;    
        
            Parent root = null ;
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/Goal8_Report/ShowReportFxml.fxml")) ;
            root = (Parent) myLoader.load() ;
            Scene myScene = new Scene(root) ;
        
            ShowReportFxmlController src = myLoader.getController() ;
            src.set(re, sir) ;

            Stage stage = new Stage() ;
            stage.setScene(myScene) ;
            stage.getIcons().add(new Image("/image/campIcon.jpg")) ;
            stage.setTitle("Aid Excutive Show Report") ;
            stage.show() ;
        }
    
    }
    
}
