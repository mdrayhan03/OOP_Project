/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal7_AllReports;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class ShowAllReportsSceneController implements Initializable {

    @FXML
    private TableView<?> showAllReportsTableView;
    @FXML
    private TableColumn<?, ?> showReportsUserTypeTC;
    @FXML
    private TableColumn<?, ?> showReportsSubjectTC;
    @FXML
    private TableColumn<?, ?> showReportsDescriptionTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showReportsBackButton(ActionEvent event) {
    }
    
}
