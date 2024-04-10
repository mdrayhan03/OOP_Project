/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal5_Supply;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class SupplyInstrumentsSceneController implements Initializable {

    @FXML
    private ComboBox<?> selectInstrumentsCB;
    @FXML
    private ComboBox<?> selectEducationUserCB;
    @FXML
    private TextField supplyInstrumentsQuantityCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supplyInstrumentsOnButtonClick(ActionEvent event) {
    }

    @FXML
    private void supplyMedicineBackButton(ActionEvent event) {
    }
    
}
