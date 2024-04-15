package mainpkg.Rayhan.User5.Goal2_SIReport;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rayhan.User5.DashBoard5SceneFxmlController;
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;
import mainpkg.Rayhan.User5.Goal1_Volunteer.VolunteerInfoSceneFxmlController;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User7.SecurityIncharge;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class SecurityInchargeReportSceneFxmlController implements Initializable {

    @FXML    private TextField ddTextField;
    @FXML    private TextField subjectTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextArea reportBodyTextArea;
    @FXML    private TextField siIdTextField;
    @FXML    private ComboBox<Integer> idComboBox;
    
    VolunteerCoordinator user ;
    Alert alert ;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public VolunteerCoordinator get() {
        return user ;
    }
    
    public void set(VolunteerCoordinator u) {
        user = u ;
        setComboBox() ;
    }
    
    public void setComboBox() {
        ObservableList<SecurityIncharge> scList = fileRead() ;
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
        
        DashBoard5SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

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
                ObservableList<SecurityIncharge> scList = fileRead() ;
                for (SecurityIncharge sc: scList) {
                    SIReport si = user.reportToSecurityIncharge(subject , user.getId() , sc.getId() , des , doa) ;
                    fileWrite(si) ;
                }
            }
            else {
                SIReport si = user.reportToSecurityIncharge(subject , user.getId() , receiverId , des , doa) ;
                fileWrite(si) ;
        
                Parent root = null ;
                FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/Goal2_SIReport/ShowReportFxml.fxml")) ;
                root = (Parent) myLoader.load() ;
                Scene myScene = new Scene(root) ;
        
                ShowReportFxmlController src = myLoader.getController() ;
                src.set(si) ;

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
    
    private ObservableList<SecurityIncharge> fileRead() {
        ObservableList<SecurityIncharge> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/SecurityIncharge.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            SecurityIncharge st ;
            try {
                while(true){
                    st = (SecurityIncharge)ois.readObject();
//                    System.out.println(st);
                    studList.add(st) ;
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch     
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
        finally {
            try {
                
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
        
        return studList ;
    }
    
    private void fileWrite(SIReport stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/SIReport.bin");
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
            Logger.getLogger(VolunteerInfoSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(VolunteerInfoSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
    
    
}
