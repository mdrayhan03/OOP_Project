/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.Refugee.Goal2_Healthcare;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class RequestMedicineSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void requestMedicineBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/Refugee/Goal2_Healthcare/RefugeeHealthCareScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }

    @FXML
    private void requestMedicineRefugeeIdTF(ActionEvent event) {
    }

    @FXML
    private void medicineQuantityTextField(ActionEvent event) {
    }

    @FXML
    private void requestMedicineSubmitButton(ActionEvent event) {
    }

    @FXML
    private void requestMedicineRefugeeNameTF(ActionEvent event) {
    }

    @FXML
    private void selectMedicineCB(ActionEvent event) {
    }
    
}
