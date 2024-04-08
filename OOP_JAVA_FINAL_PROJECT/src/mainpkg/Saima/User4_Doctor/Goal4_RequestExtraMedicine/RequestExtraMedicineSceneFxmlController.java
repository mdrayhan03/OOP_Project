/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4.Doctor.Goal4_RequestExtraMedicine;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RequestExtraMedicineSceneFxmlController implements Initializable {

    @FXML
    private ComboBox<?> requestMedicineNameComboBox;
    @FXML
    private TextField requestMedicineQuantityTextField;
    @FXML
    private TextField ddTextField;
    @FXML
    private TextField mmTextField;
    @FXML
    private TextField yyyyTextField;
    @FXML
    private TextField ddDeadlineTextField;
    @FXML
    private TextField mmDeadlineTextField;
    @FXML
    private TextField yyyyDeadlineTextField;
    @FXML
    private TableView<?> requestExtraMedicineTableView;
    @FXML
    private TableColumn<?, ?> requestIdTableColumn;
    @FXML
    private TableColumn<?, ?> medicineNameTableColumn;
    @FXML
    private TableColumn<?, ?> medicineQuantityTableColumn;
    @FXML
    private TableColumn<?, ?> requestDateTableColumn;
    @FXML
    private TableColumn<?, ?> deadlineTableColumn;
    @FXML
    private TableColumn<?, ?> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void submitRequestOnMouseClicked(MouseEvent event) {
    }
    
}
