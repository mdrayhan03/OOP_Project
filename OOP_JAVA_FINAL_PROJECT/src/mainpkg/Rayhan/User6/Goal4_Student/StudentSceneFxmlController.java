/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rayhan.User6.Goal4_Student;

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
 * @author RayhaN
 */
public class StudentSceneFxmlController implements Initializable {

    @FXML
    private ComboBox<?> refugeeIdComboBox;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label pNLabel;
    @FXML
    private TableView<?> studentTableView;
    @FXML
    private TableColumn<?, ?> idTableColumn;
    @FXML
    private TableColumn<?, ?> nameTableColumn;
    @FXML
    private TableColumn<?, ?> pNTableColumn;
    @FXML
    private TableColumn<?, ?> emailTableColumn;
    @FXML
    private TableColumn<?, ?> courseIdTableColumn;
    @FXML
    private ComboBox<?> courseIdComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void addOnMouseClick(MouseEvent event) {
    }

    @FXML
    private void createOnMouseClick(MouseEvent event) {
    }
    
}
