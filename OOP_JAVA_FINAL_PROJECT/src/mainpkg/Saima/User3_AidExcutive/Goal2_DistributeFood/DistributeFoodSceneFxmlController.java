/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal2_DistributeFood;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;
import mainpkg.Saima.User3_AidExcutive.Goal1_AddFood.AddFood;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DistributeFoodSceneFxmlController implements Initializable {

    @FXML
    private ComboBox<?> foodNameComboBox;
    @FXML
    private TextField foodQuantityTextField;
    @FXML
    private TextField ddTextField;
    @FXML
    private TextField mmTextField;
    @FXML
    private TextField yyyyTextField;
    @FXML
    private TableView<?> removeFoodTableView;
    @FXML
    private TableColumn<?, ?> distributeIdTableColumn;
    @FXML
    private TableColumn<?, ?> foodNameTableColumn;
    @FXML
    private TableColumn<?, ?> foodQuantityTableColumn;
    @FXML
    private TableColumn<?, ?> distributeDateTableColumn;
    @FXML
    private TableColumn<?, ?> distributeByTableColumn;

    /**
     * Initializes the controller class.
     */ 
    Alert alert ;
    AidExcutive user ;
    ObservableList<AddFood> list = FXCollections.observableArrayList() ;
    
    
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
    private void distributeOnMouseClicked(MouseEvent event) {
    }
    
}
