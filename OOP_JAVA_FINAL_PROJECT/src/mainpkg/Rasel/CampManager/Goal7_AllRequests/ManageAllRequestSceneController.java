/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.CampManager.Goal7_AllRequests;

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
public class ManageAllRequestSceneController implements Initializable {

    @FXML
    private TableView<?> manageAllRequestsTableView;
    @FXML
    private TableColumn<?, ?> requestUserTypeTC;
    @FXML
    private TableColumn<?, ?> requestUserNameTC;
    @FXML
    private TableColumn<?, ?> requestUserItemTC;
    @FXML
    private TableColumn<?, ?> requestItemQuantityTC;
    @FXML
    private TableColumn<?, ?> manageRequestActionTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void manageRequestBackButton(ActionEvent event) {
    }
    
}
