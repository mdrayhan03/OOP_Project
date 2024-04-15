/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.Refugee.Goal1_FoodRequest;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.Saima.User3_AidExcutive.FoodRequest;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class FoodRequestSceneController implements Initializable {

    @FXML
    private TextField requestFoodRefugeeIdTF;
    @FXML
    private TextField foodQuantityTextField;
    @FXML
    private TextField requestFoodRefugeeNameTF;
    @FXML
    private ComboBox<String> selectFoodCB;
    @FXML
    private ComboBox<String> selectMeasurementCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] food = {"Rice", "Onion", "Pulse", "Potato", "Oil", "Fish", "Milk", "Egg", "Chicken"};
        
        for (String f: food){
            selectFoodCB.getItems().add(f);
        }
        
        selectMeasurementCB.getItems().add("Grams(g)");
        selectMeasurementCB.getItems().add("Kilograms(KG)");
        selectMeasurementCB.getItems().add("Litre(L)");
        selectMeasurementCB.getItems().add("Millilitres(mL)");
        
        
    }    

    @FXML
    private void requestFoodBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/Refugee/RefugeeDashboardScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }


    @FXML
    private void requestFoodSubmitButton(ActionEvent event) throws IOException {
        String refugeeID = requestFoodRefugeeIdTF.getText();
        int qty = Integer.parseInt(foodQuantityTextField.getText());
        String name = requestFoodRefugeeNameTF.getText();
        String food = selectFoodCB.getValue();
        String measure = selectMeasurementCB.getValue();
        
        FoodRequest fr = new FoodRequest(refugeeID, name, food, qty, measure);
        
        saveToBinFile(fr);
        
        showAlert("Your request has been submitted", AlertType.INFORMATION);
        
    }


    @FXML
    private void foodRequestStatusButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/Refugee/Goal1_FoodRequest/FoodRequestStatusScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
        
    }
    
    public void saveToBinFile(FoodRequest obj) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
            f = new File("src/File/FoodRequestRefugee.bin");
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
    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
