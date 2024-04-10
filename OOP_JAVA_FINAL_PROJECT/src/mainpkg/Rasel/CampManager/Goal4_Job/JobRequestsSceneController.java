/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal4_Job;

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
public class JobRequestsSceneController implements Initializable {

    @FXML
    private TableView<?> jobRequestsTableView;
    @FXML
    private TableColumn<?, ?> jobRequestRefugeeIdTC;
    @FXML
    private TableColumn<?, ?> jobRequestRefugeNameTC;
    @FXML
    private TableColumn<?, ?> jobRequestDescriptionTC;
    @FXML
    private TableColumn<?, ?> jobRequestActionTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void jobRequestsBackButton(ActionEvent event) {
    }
    
}
