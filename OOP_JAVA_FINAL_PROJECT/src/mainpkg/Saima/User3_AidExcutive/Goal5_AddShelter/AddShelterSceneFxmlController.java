/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal5_AddShelter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddShelterSceneFxmlController implements Initializable {

    @FXML
    private ComboBox<?> shelterIdComboBox;
    @FXML
    private TableView<?> addShelterInfoTableView;
    @FXML
    private TableColumn<?, ?> shelterIdTableColumn;
    @FXML
    private TableColumn<?, ?> shelterAmountTableColumn;
    @FXML
    private TableColumn<?, ?> shelterStatusTableColumn;
    @FXML
    private TableColumn<?, ?> addedShelterDateTableColumn;
    @FXML
    private TableColumn<?, ?> foodNameTableColumn1;
    @FXML
    private TableColumn<?, ?> foodNameTableColumn2;
    @FXML
    private Label familyMembersIdLabel;
    @FXML
    private Label ddLabel;
    @FXML
    private Label mmLabel;
    @FXML
    private Label yyyyLabel;
    @FXML
    private Label totalShelterLabel;
    @FXML
    private Label emptyShelterLabel;
    @FXML
    private Label shelterStatusLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) {
    }
    
}
