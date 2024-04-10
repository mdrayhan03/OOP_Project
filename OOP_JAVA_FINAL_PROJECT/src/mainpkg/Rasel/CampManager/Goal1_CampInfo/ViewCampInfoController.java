/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal1_CampInfo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class ViewCampInfoController implements Initializable {

    @FXML
    private PieChart refugeePieChart;
    @FXML
    private Label campCapacityLabel;
    @FXML
    private Label totalRefugeeLabel;
    @FXML
    private Label currentfoodStockLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void campInfoBackButton(ActionEvent event) {
    }
    
}
