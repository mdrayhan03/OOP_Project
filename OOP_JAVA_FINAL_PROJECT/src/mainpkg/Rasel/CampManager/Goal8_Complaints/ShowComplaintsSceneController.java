/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal8_Complaints;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class ShowComplaintsSceneController implements Initializable {

    @FXML
    private TableColumn<?, ?> complaintsRefugeeIdTC;
    @FXML
    private TableColumn<?, ?> complaintsRefugeeNameTC;
    @FXML
    private TableColumn<?, ?> complaintsRefugeeDescriptionTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void refugeeComplaintsBackButton(ActionEvent event) {
    }
    
}
