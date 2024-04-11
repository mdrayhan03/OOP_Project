/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal6_AllocateShelter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;
//import mainpkg.Saima.User3_AidExcutive.Goal5_AddShelter.AddShelter;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AllocateShelterSceneFxmlController implements Initializable {

    @FXML
    private ComboBox<?> emptyShelterIdComboBox;
    @FXML
    private Label familyMemberId1Label;
    @FXML
    private Label familyMemberId2Label;
    @FXML
    private Label familyMemberId3Label;
    @FXML
    private Label familyMemberId4Label;
    @FXML
    private Label familyMemberId5Label;
    @FXML
    private TextField ddTextField;
    @FXML
    private TextField mmTextField;
    @FXML
    private TextField yyyyTextField;

    /**
     * Initializes the controller class.
     */
    Alert alert ;
    AidExcutive user ;
//    ObservableList<AddShelter> list = FXCollections.observableArrayList() ;
    
    
    public AidExcutive get() {
        return user ;
    }
    public void set(AidExcutive u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void allocateButtonOnMouseClicked(MouseEvent event) {
    }
    
}
