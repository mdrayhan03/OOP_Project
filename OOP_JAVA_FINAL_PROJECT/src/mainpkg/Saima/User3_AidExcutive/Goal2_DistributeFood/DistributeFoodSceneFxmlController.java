/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal2_DistributeFood;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rasel.CampManager.Goal5_Supply.Food;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;



/**
 * FXML Controller class
 *
 * @author HP
 */
public class DistributeFoodSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> foodNameComboBox;
    @FXML    private TextField foodQuantityTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TableView<Food> removeFoodTableView;
    @FXML    private TableColumn<Food, String> distributeIdTableColumn;
    @FXML    private TableColumn<Food, String> foodNameTableColumn;
    @FXML    private TableColumn<Food, String> foodQuantityTableColumn;
    @FXML    private TableColumn<Food, Date> distributeDateTableColumn;
    @FXML    private TableColumn<Food, String> distributeByTableColumn;

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
    private void backButtonOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/DashBoard6SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Aid Excutive DashBoard") ;
        stage.show() ;
    }
    }

    @FXML
    private void distributeOnMouseClicked(MouseEvent event) {
    }
    
}
