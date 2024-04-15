/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal8_MedicalReport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rayhan.User5.Goal8_Report.Report; 
import mainpkg.Saima.User3_AidExcutive.Goal8_Report.ReportList;
import mainpkg.Saima.User3_AidExcutive.Goal8_Report.ShowReportFxmlController;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */

public class MedicalReportSceneFxmlController implements Initializable {

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
    Doctor user ;
    Alert alert ;
    ReportList sir ;
    
    public User get() {
        return user ;
    }
    
    public void set(Doctor u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DoctorDashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor DashBoard") ;
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
            Report re = user.report(user.getId() , receiverId , subject , des , doa) ;
            System.out.println(re.getApplyDate()) ;
            
            fileWrite(re) ;
            System.out.println(user.getId() + "," + receiverId + "," + re.getId()) ;
        
            Parent root = null ;
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/Goal8_Report/ShowReportFxml.fxml")) ;
            root = (Parent) myLoader.load() ;
            Scene myScene = new Scene(root) ;
        
            mainpkg.Rayhan.User5.Goal8_Report.ShowReportFxmlController src = myLoader.getController() ;
            src.set(re) ;

            Stage stage = new Stage() ;
            stage.setScene(myScene) ;
            stage.getIcons().add(new Image("/image/campIcon.jpg")) ;
            stage.setTitle("Doctor Show Report") ;
            stage.show() ;
            
            ddTextField.clear() ;
            subjectTextField.clear() ;
            mmTextField.clear() ;
            yyyyTextField.clear() ;
            reportBodyTextArea.clear() ;
            campManagerIdTextField.clear() ;
        }
    }
    
     private void fileWrite(Report stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/Report.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(stu);

        } catch (IOException ex) {
            Logger.getLogger(MedicalReportSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(MedicalReportSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
}


