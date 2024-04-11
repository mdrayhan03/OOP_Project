/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal4_RequestExtraFood;

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
import mainpkg.Rasel.CampManager.Goal5_Supply.Food;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class RequestExtraFoodSceneFxmlController implements Initializable {

    @FXML
    private ComboBox<?> requestfoodNameComboBox;
    @FXML
    private TextField requestFoodQuantityTextField;
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
    private TableView<?> requestExtraFoodTableView;
    @FXML
    private TableColumn<?, ?> requestIdTableColumn;
    @FXML
    private TableColumn<?, ?> foodNameTableColumn;
    @FXML
    private TableColumn<?, ?> foodQuantityTableColumn;
    @FXML
    private TableColumn<?, ?> requestDateTableColumn;
    @FXML
    private TableColumn<?, ?> deadlineTableColumn;
    @FXML
    private TableColumn<?, ?> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    Alert alert ;
    AidExcutive user ;
    ObservableList<Food> list = FXCollections.observableArrayList() ;
    
    
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
    private void backOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void submitRequestOnMouseClicked(MouseEvent event) {
    }
    
}
