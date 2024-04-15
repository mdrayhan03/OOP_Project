/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.Refugee.Goal6_TrainingCenter;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.Rayhan.User5.Goal6_Campaign.SkillDevelopmentCenter;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class TrainingAndSkillSceneController implements Initializable {

    @FXML
    private TableView<SkillDevelopmentCenter> workShopTV;
    @FXML
    private TableColumn<SkillDevelopmentCenter, String> workshopNameTC;
    @FXML
    private TableColumn<SkillDevelopmentCenter, String> placeTC;
    @FXML
    private TableColumn<SkillDevelopmentCenter, String> eligibleAgeTC;
    @FXML
    private TableColumn<SkillDevelopmentCenter, String> durationTC;
    @FXML
    private TableColumn<SkillDevelopmentCenter, String> typeTC;

    ObservableList<SkillDevelopmentCenter> trainingList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        try {
//            SkillDevelopmentCenter training1 = new SkillDevelopmentCenter("Journey to Success", "Camp 12", "18-32", "Day Long", new Date(15, 04, 2024), "5 Hours" );
//            SkillDevelopmentCenter training2 = new SkillDevelopmentCenter("Improvement Teaching Technique", "Camp 7", "20-26", "Weekly", new Date(16, 04, 2024), "3 Hours");
//            SkillDevelopmentCenter training3 = new SkillDevelopmentCenter("Building Bright Futures", "Camp 17", "30-50", "Day Long", new Date(17, 04, 2024), "2 Hours");
//            SkillDevelopmentCenter training4 = new SkillDevelopmentCenter("Rising Stars Program", "Camp 1", "18-30", "Monthly", new Date(18, 04, 2024), "1 Hours");
//            saveToBinFile(training1);
//            saveToBinFile(training2);
//            saveToBinFile(training3);
//            saveToBinFile(training4);
            
            workshopNameTC.setCellValueFactory(new PropertyValueFactory<>("workshopName"));
            placeTC.setCellValueFactory(new PropertyValueFactory<>("place"));
            eligibleAgeTC.setCellValueFactory(new PropertyValueFactory<>("eligibleAge"));
            durationTC.setCellValueFactory(new PropertyValueFactory<>("duration"));
            typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
//        } catch (IOException ex) {
//            Logger.getLogger(TrainingAndSkillSceneController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        printFromBin();
        
    }    

    @FXML
    private void trainingSkillRegistrationButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/Refugee/Goal6_TrainingCenter/TrainingRegScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
        
    }

    @FXML
    private void trainingSkillSceneBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/Refugee/RefugeeDashboardScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }
    
    private void saveToBinFile(SkillDevelopmentCenter training) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
            f = new File("src/File/SkillDevelopmentCenter.bin");
        try {
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);           
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(training);
            
           } catch (IOException e) {
               System.out.println("Error reading file: " + e.getMessage());
                e.printStackTrace();
            }
            
        }
    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public void printFromBin(){
        
        File f = null;
        f = new File("src/File/SkillDevelopmentCenter.bin");
        if (f.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(f);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
                SkillDevelopmentCenter s;

                while (true) {
                    try {
                        s = (SkillDevelopmentCenter) objectIn.readObject();
                        trainingList.add(s);
                    } catch (EOFException e) {
                        break;
                    }
                }

                for (SkillDevelopmentCenter training : trainingList) {
                    workShopTV.getItems().add(training);
                
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
            System.out.println("Training file is not found");
        }
    }
    
}
