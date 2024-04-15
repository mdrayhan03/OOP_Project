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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.Rayhan.User5.Goal6_Campaign.SkillDevelopmentCenter;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class TrainingRegSceneController implements Initializable {

    @FXML
    private TextField trainingRegNameTF;
    @FXML
    private RadioButton trainingGenderMaleRadioButton;
    @FXML
    private RadioButton trainingGenderFemaleRadioButton;
    @FXML
    private TextField trainingRegRefugeeIdTF;
    @FXML
    private RadioButton trainingGenderOthersRadioButton;
    @FXML
    private ComboBox<String> selectTrainingCB;

    ObservableList<SkillDevelopmentCenter> trainingList = FXCollections.observableArrayList();
    ObservableList<TrainingRegistration> regList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        printFromBin();
        
    }    

    @FXML
    private void trainingRegBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/Refugee/Goal6_TrainingCenter/TrainingAndSkillScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }



    @FXML
    private void trainingRegistrationOnButtonClick(ActionEvent event) throws IOException {
        String name = trainingRegNameTF.getText();
        int refugeeID = Integer.parseInt(trainingRegRefugeeIdTF.getText());
        String workshopName = selectTrainingCB.getValue();
        String gender = "";
        
        if (trainingGenderMaleRadioButton.isSelected()){
            gender = "Male";
        } else if (trainingGenderFemaleRadioButton.isSelected()){
            gender = "Female";
        } else if (trainingGenderOthersRadioButton.isSelected()) {
            gender = "Others";
        } else {
            System.out.println("Something went wrong");
        }
            
        TrainingRegistration tr = new TrainingRegistration(refugeeID, name, workshopName, gender);
        saveToBinFile(tr);
        showAlert("Registration successfull", AlertType.INFORMATION);
        
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
                    selectTrainingCB.getItems().add(training.getWorkshopName());
                
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

    private void saveToBinFile(TrainingRegistration regList) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
            f = new File("src/File/TrainingRegistration.bin");
        try {
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);           
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(regList);
            
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

}
