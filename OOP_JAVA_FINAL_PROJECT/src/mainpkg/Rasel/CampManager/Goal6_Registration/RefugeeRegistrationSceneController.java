/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal6_Registration;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class RefugeeRegistrationSceneController implements Initializable {

    @FXML
    private TextField refugeeNameTextField;
    @FXML
    private TextField refugeeFatherNameTextField;
    @FXML
    private TextField refugeeMotherNameTextField;
    @FXML
    private TextField refugeeSymboleText;
    @FXML
    private Label refugeeIDLabel;
    @FXML
    private TextArea refugeeDescriptionTextArea;
    @FXML
    private ComboBox<?> selectCampCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addrefugeeOnButtonClick(ActionEvent event) {
    }

    @FXML
    private void refugeeRegistrationBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/CampManager/CampManagerDashboardScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }
    
}
