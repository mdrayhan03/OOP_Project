/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal8_Complaints;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpkg.Rasel.Refugee.Goal5_Complaint.Complaint;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class ShowComplaintsSceneController implements Initializable {

    @FXML
    private TableColumn<Complaint, String> complaintsRefugeeIdTC;
    @FXML
    private TableColumn<Complaint, String> complaintsRefugeeNameTC;
    @FXML
    private TableColumn<Complaint, String> complaintsRefugeeDescriptionTC;
    @FXML
    private TableView<Complaint> complaintTV;

    private ObservableList<Complaint> complaintList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        printFromBin();
        complaintsRefugeeIdTC.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));
        complaintsRefugeeNameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        complaintsRefugeeDescriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
    }    

    @FXML
    private void refugeeComplaintsBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/CampManager/CampManagerDashboardScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }
    
    public void printFromBin(){
        
        File f = null;
        f = new File("src/File/Complaint.bin");
        if (f.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(f);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
                Complaint s;

                while (true) {
                    try {
                        s = (Complaint) objectIn.readObject();
                        complaintList.add(s);
                    } catch (EOFException e) {
                        break;
                    }
                }

                for (Complaint c : complaintList) {
                    complaintTV.getItems().add(new Complaint(c.getName(), c.getDescription(), c.getRefugeeID()));
                
                }
            
                objectIn.close();
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
            e.printStackTrace();
        }
      } else {
            System.out.println("Complaint file is not found");
        }
    } 
    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
}
