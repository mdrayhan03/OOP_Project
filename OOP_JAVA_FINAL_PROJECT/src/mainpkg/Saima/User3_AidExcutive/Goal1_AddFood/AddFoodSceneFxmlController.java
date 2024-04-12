/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal1_AddFood;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.CampManager.Goal5_Supply.Food;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddFoodSceneFxmlController implements Initializable {

    @FXML
    private ComboBox<String> foodIdComboBox;
    @FXML
    private TableView<Food> addFoodTableView;
    @FXML
    private TableColumn<Food, String> foodIdTableColumn;
    @FXML
    private TableColumn<Food, String> foodNameTableColumn;
    @FXML
    private TableColumn<Food, String> foodQuantityTableColumn;
    @FXML
    private TableColumn<Food, Date> addedFoodDateTableColumn;
   
    @FXML    private Label foodNameLabel;
    @FXML    private Label foodQuantityLabel;
    @FXML    private Label ddLabel;
    @FXML    private Label mmLabel;
    @FXML    private Label yyyyLabel;

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
    public void setComboBox() {
        for(Food f: list) {
            foodIdComboBox.getItems().add(f.getId()) ;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        foodIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("foodId")) ;
        foodNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("foodName")) ;
        foodQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("foodQuantity")) ;
        addedFoodDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("foodDate")) ;
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Aid Excutive") ;
        stage.show() ;
    }

    @FXML
    private void foodIdOnMouseClicked(MouseEvent event) {
        Food f = user.foodInfo(foodIdComboBox.getValue(), list) ;
        if (f != null) {
            foodNameLabel.setText(f.getName()) ;
            foodQuantityLabel.setText(f.getQuantity().toString()) ;
            ddLabel.setText(f.getDate().toString()) ;
            mmLabel.setText(f.getDate().toString()) ;
            yyyyLabel.setText(f.getDate().toString()) ;
            
        }
    }

    
}
