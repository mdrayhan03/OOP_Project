/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal4_RequestExtraFood;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rasel.CampManager.Goal5_Supply.Food;

import mainpkg.Saima.User3.FoodRequest;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class RequestExtraFoodSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> requestfoodNameComboBox;
    @FXML    private TextField requestFoodQuantityTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextField ddDeadlineTextField;
    @FXML    private TextField mmDeadlineTextField;
    @FXML    private TextField yyyyDeadlineTextField;
    @FXML    private TableView<FoodRequest> requestExtraFoodTableView;
    @FXML    private TableColumn<FoodRequest, String> requestIdTableColumn;
    @FXML    private TableColumn<FoodRequest, String> foodNameTableColumn;
    @FXML    private TableColumn<FoodRequest, Integer> foodQuantityTableColumn;
    @FXML    private TableColumn<FoodRequest, Date> requestDateTableColumn;
    @FXML    private TableColumn<FoodRequest, Date> deadlineTableColumn;
    @FXML    private TableColumn<FoodRequest, String> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    Alert alert ;
    AidExcutive user ;
    ObservableList<FoodRequest> list = FXCollections.observableArrayList() ;
    
    
    public AidExcutive get() {
        return user ;
    }
    public void set(AidExcutive u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        requestfoodNameComboBox.getItems().addAll("Rice","Potato","Onion","Fish","Oil","Pulse","Milk","Egg","Chicken");
        requestIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        foodNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        foodQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("foodQuantity"));
        requestDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        deadlineTableColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    

        // TODO
    }    

    @FXML
    private void backOnMouseClicked(MouseEvent event) throws IOException {
            Parent root = null ;
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/DashBoardSceneFxml.fxml")) ;
            root = (Parent) myLoader.load() ;
            Scene myScene = new Scene(root) ;

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
            stage.setScene(myScene) ;
            stage.setTitle("Aid Excutive DashBoard") ;
            stage.show() ;
    }

    @FXML
    private void submitRequestOnMouseClicked(MouseEvent event) {
        String foodName = (String) requestfoodNameComboBox.getValue();
        int quantity = Integer.parseInt(requestFoodQuantityTextField.getText());
        int dd = Integer.parseInt(ddTextField.getText());
        int mm = Integer.parseInt(mmTextField.getText());
        int yyyy = Integer.parseInt(yyyyTextField.getText());
        int ddDeadline = Integer.parseInt(ddDeadlineTextField.getText());
        int mmDeadline = Integer.parseInt(mmDeadlineTextField.getText());
        int yyyyDeadline = Integer.parseInt(yyyyDeadlineTextField.getText());
        
        Date requestDate = new Date(dd, mm, yyyy);
        Date deadline = new Date(ddDeadline, mmDeadline, yyyyDeadline);
        
        FoodRequest newFoodRequest = new FoodRequest(foodName, quantity, requestDate, deadline, "Pending");
        
        list.add(newFoodRequest);
        requestExtraFoodTableView.setItems(list);
        
        clearFields();  
    }
    
    private void clearFields() {
        requestfoodNameComboBox.getSelectionModel().clearSelection();
        requestFoodQuantityTextField.clear();
        ddTextField.clear();
        mmTextField.clear();
        yyyyTextField.clear();
        ddDeadlineTextField.clear();
        mmDeadlineTextField.clear();
        yyyyDeadlineTextField.clear();
    }
   
}
