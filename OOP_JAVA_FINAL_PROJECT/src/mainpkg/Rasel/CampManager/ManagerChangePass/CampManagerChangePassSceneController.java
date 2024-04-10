/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.CampManager.ManagerChangePass;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class CampManagerChangePassSceneController implements Initializable {

    @FXML
    private Button managerChangePassButton;
    @FXML
    private PasswordField oldPassManagerTextField;
    @FXML
    private PasswordField newPassManagerTextField;
    @FXML
    private PasswordField retypePassManagerTextField;
    @FXML
    private Button managerChangePassBackButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
