package mainpkg.Rasel.CampManager.Goal2_Security;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author Rasel
 */
public class SecuritySceneController implements Initializable {

    @FXML
    private TextArea emergencyAlertTextArea;
    @FXML
    private TextField subjectTextField;
    @FXML
    private DatePicker alertDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendAlertSecurityOnButtonClick(ActionEvent event) throws IOException {
    String subject = subjectTextField.getText();
    String notice = emergencyAlertTextArea.getText();
    String filename = "EmergencyNoticeSI.bin";
    
    LocalDate time = alertDate.getValue();
    
    
    EmergencyNotice noticeSI = new EmergencyNotice(subject, notice, time.toString());
    
    saveToBinFile(noticeSI, filename);
    
    System.out.println("Details:");
    System.out.println(noticeSI);

    resetUIFields();
    
    }

    private void resetUIFields() {
        emergencyAlertTextArea.clear();
        alertDate.setValue(null);
        subjectTextField.clear();

    }

    @FXML
    private void sendAlertVolunteerOnButtonClick(ActionEvent event) throws IOException {
    String subject = subjectTextField.getText();
    String notice = emergencyAlertTextArea.getText();
    String filename = "EmergencyNoticeVC.bin";
    
    LocalDate time = alertDate.getValue();
    
    
    EmergencyNotice noticeVC = new EmergencyNotice(subject, notice, time.toString());
    
    saveToBinFile(noticeVC, filename);
    
    System.out.println("Details:");
    System.out.println(noticeVC);

    resetUIFields();
        
    }

    @FXML
    private void AlertSystemBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/CampManager/CampManagerDashboardScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }
    
    public void saveToBinFile(EmergencyNotice notice, String filename) throws IOException {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

            f = new File("src/File/"+filename);
            if (f.exists()) {
            try {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SecuritySceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(notice);
            showAlert("Alert has been created", Alert.AlertType.INFORMATION);
    }
    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
