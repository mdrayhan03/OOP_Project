/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal1_AddFood;

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
import mainpkg.AbstractClass.User;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddFoodSceneFxmlController implements Initializable {

    @FXML
    private ComboBox<?> foodIdComboBox;
    @FXML
    private TableView<?> addFoodTableView;
    @FXML
    private TableColumn<?, ?> foodIdTableColumn;
    @FXML
    private TableColumn<?, ?> foodNameTableColumn;
    @FXML
    private TableColumn<?, ?> foodQuantityTableColumn;
    @FXML
    private TableColumn<?, ?> addedFoodDateTableColumn;
    @FXML
    private TableColumn<?, ?> foodNameTableColumn1;
    @FXML
    private TableColumn<?, ?> foodNameTableColumn2;
    @FXML
    private Label foodNameLabel;
    @FXML
    private Label foodQuantityLabel;
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

    
}
