/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.Refugee.Goal5_Complaint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class RefugeeComplaintSceneController implements Initializable {

    @FXML
    private TextArea complaintDescriptionTextArea;
    @FXML
    private TextField complaintManagerRefugeeNameTF;
    @FXML
    private TextField complaintManagerRefugeeIdTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void complaintManagerBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/Refugee/RefugeeDashboardScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }


    @FXML
    private void complaintManagerOnButtonClick(ActionEvent event) throws IOException {
        String name = complaintManagerRefugeeNameTF.getText();
        String description = complaintDescriptionTextArea.getText();
        String refugeeID = complaintManagerRefugeeIdTF.getText();
        
        Complaint c = new Complaint(name, description, refugeeID);
        saveToBinFile(c);
        showAlert("You successfuly complaint to Manager", AlertType.INFORMATION);
    }
  
    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public void saveToBinFile(Complaint obj) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
            f = new File("src/File/Complaint.bin");
        try {
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);           
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(obj);
            
           } catch (IOException e) {
               System.out.println("Error reading file: " + e.getMessage());
                e.printStackTrace();
            }
            
        }
    
}
