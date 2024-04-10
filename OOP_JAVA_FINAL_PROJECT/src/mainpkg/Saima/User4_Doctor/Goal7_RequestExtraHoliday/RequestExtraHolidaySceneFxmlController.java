/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal7_RequestExtraHoliday;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.AbstractClass.Holiday;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
   

public class RequestExtraHolidaySceneFxmlController implements Initializable {

    @FXML
    private TextField startddTextField;
    @FXML
    private TextField startmmTextField;
    @FXML
    private TextField startyyyyTextField;
    @FXML
    private TextField ddTextField;
    @FXML
    private TextField mmTextField;
    @FXML
    private TextField yyyyTextField;
    @FXML
    private TextField endddTextField;
    @FXML
    private TextField endmmTextField;
    @FXML
    private TextField endyyyyTextField;
    @FXML
    private TableView<?> holidayTableView;
    @FXML
    private TableColumn<?, ?> idTableColumn;
    @FXML
    private TableColumn<?, ?> reasonTableColumn;
    @FXML
    private TableColumn<?, ?> sDTableColumn;
    @FXML
    private TableColumn<?, ?> eDTableColumn;
    @FXML
    private TableColumn<?, ?> dateTableColumn;
    @FXML
    private TableColumn<?, ?> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    Alert alert ;
    Doctor user ;
    ObservableList<Holiday> list = FXCollections.observableArrayList() ;
    
    
    public Doctor get() {
        return user ;
    }
    public void set(Doctor u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) {
    }
    
}
