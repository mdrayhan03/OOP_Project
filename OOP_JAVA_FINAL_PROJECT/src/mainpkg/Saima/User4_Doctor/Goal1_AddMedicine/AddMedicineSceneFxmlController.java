/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal1_AddMedicine;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddMedicineSceneFxmlController implements Initializable {

    @FXML
    private ComboBox<?> medicineIdComboBox;
    @FXML
    private TableView<?> addMedicineTableView;
    @FXML
    private TableColumn<?, ?> medicineIdTableColumn;
    @FXML
    private TableColumn<?, ?> medicineNameTableColumn;
    @FXML
    private TableColumn<?, ?> medicineAmountTableColumn;
    @FXML
    private TableColumn<?, ?> addeMedicineDateTableColumn;
    @FXML
    private TableColumn<?, ?> foodNameTableColumn1;
    @FXML
    private TableColumn<?, ?> foodNameTableColumn2;
    @FXML
    private Label medicineNameLabel;
    @FXML
    private Label medicineAmountLabel;
    @FXML
    private Label ddLabel;
    @FXML
    private Label mmLabel;
    @FXML
    private Label yyyyLabel;

    /**
     * Initializes the controller class.
     */
    
    Alert alert ;
    Doctor user ;
    ObservableList<AddMedicine> list = FXCollections.observableArrayList() ;
    
    
    public Doctor get() {
        return user ;
    }
    public void set(Doctor u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) {
    }
    
}
