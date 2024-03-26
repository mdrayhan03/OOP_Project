/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rayhan.User6.Goal7_Storage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class StorageSceneFxmlController implements Initializable {

    @FXML    private Label gBoxDLabel;
    @FXML    private Label bookStockLabel;
    @FXML    private Label noteStockLabel;
    @FXML    private Label penStockLabel;
    @FXML    private Label pBoxStockLabel;
    @FXML    private Label rubberStockLabel;
    @FXML    private Label pencilStockLabel;
    @FXML    private Label gBoxStockLabel;
    @FXML    private Label bookDLabel;
    @FXML    private Label noteDLabel;
    @FXML    private Label penDLabel;
    @FXML    private Label pBoxDLabel;
    @FXML    private Label rubberDLabel;
    @FXML    private Label pencilDLabel;
    @FXML    private ComboBox<?> itemComboBox;
    @FXML    private TextField amountTextField;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void distributionOnMouseClick(MouseEvent event) {
    }
    
}
