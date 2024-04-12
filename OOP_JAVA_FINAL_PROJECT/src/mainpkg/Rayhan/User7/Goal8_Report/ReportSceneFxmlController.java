package mainpkg.Rayhan.User7.Goal8_Report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import mainpkg.Rayhan.User5.Goal8_Report.ShowReportFxmlController;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User7.DashBoard7SceneFxmlController;
import mainpkg.Rayhan.User7.SecurityIncharge;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class ReportSceneFxmlController implements Initializable {

    @FXML    private TextField ddTextField;
    @FXML    private TextField subjectTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextArea reportBodyTextArea;
    @FXML    private TextField siIdTextField;
    
    SecurityIncharge user ;
    Alert alert ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public SecurityIncharge get() {
        return user ;
    }
    
    public void set(SecurityIncharge u) {
        user = u ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitOnMouseClick(MouseEvent event) throws IOException {
        Boolean rtn = true ;
        Integer receiverId = null , dd = null , mm = null , yyyy = null ;
        String subject = "" , des = "" , sdd = "" , smm = "" , syyyy = "" ;
        
        receiverId = Integer.parseInt(siIdTextField.getText()) ;
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
            System.out.println(user.getId() + receiverId + re.getId());
            fileWrite(re) ;
        
            Parent root = null ;
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal8_Report/ShowReportFxml.fxml")) ;
            root = (Parent) myLoader.load() ;
            Scene myScene = new Scene(root) ;
        
            ShowReportFxmlController src = myLoader.getController() ;
            src.set(re) ;

            Stage stage = new Stage() ;
            stage.setScene(myScene) ;
            stage.getIcons().add(new Image("/image/campIcon.jpg")) ;
            stage.setTitle("Volunteer Coordinator Show Report") ;
            stage.show() ;
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
            Logger.getLogger(ReportSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ReportSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/DashBoard7SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard7SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge") ;
        stage.show() ;
    }
}
