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
public class SupplyMedicineSceneController implements Initializable {

    @FXML
    private ComboBox<?> selectMedicineCB;
    @FXML
    private ComboBox<?> selectDoctorUserCB;
    @FXML
    private TextField supplyMedicineQuantityCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supplyMedicineOnButtonClick(ActionEvent event) {
    }

    @FXML
    private void supplyMedicineBackButton(ActionEvent event) {
    }
    
}
