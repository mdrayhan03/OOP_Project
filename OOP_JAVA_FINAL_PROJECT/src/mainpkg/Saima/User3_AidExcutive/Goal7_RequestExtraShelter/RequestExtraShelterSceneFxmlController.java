/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal7_RequestExtraShelter;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rasel.CampManager.Goal5_Supply.Shelter;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;

import mainpkg.Saima.User3_AidExcutive.Goal5_AddShelter.AddShelter;
import mainpkg.Saima.User3_AidExcutive.ShelterRequest;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RequestExtraShelterSceneFxmlController implements Initializable {

    @FXML
    private TextField shelterAmountTextField;
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
    private TableView<ShelterRequest> requestExtraShelterTableView;
    @FXML
    private TableColumn<ShelterRequest, String> requestIdTableColumn;
    @FXML
    private TableColumn<ShelterRequest, Integer> shelterAmountTableColumn;
    @FXML
    private TableColumn<ShelterRequest, Date> requestDateTableColumn;
    @FXML
    private TableColumn<ShelterRequest, Date> deadlineTableColumn;
    @FXML
    private TableColumn<ShelterRequest, String> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    Alert alert ;
    AidExcutive user ;

    ObservableList<ShelterRequest> list = FXCollections.observableArrayList() ;
    
    
    public AidExcutive get() {
        return user ;
    }
    public void set(AidExcutive u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        requestIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        shelterAmountTableColumn.setCellValueFactory(new PropertyValueFactory<>("shelterAmount"));
        requestDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        deadlineTableColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    
        // TODO
    }    

    @FXML
    private void backOnMouseClicked(MouseEvent event) throws IOException {
            Parent root = null ;
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/DashBoard6SceneFxml.fxml")) ;
            root = (Parent) myLoader.load() ;
            Scene myScene = new Scene(root) ;

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
            stage.setScene(myScene) ;
            stage.setTitle("Aid Excutive DashBoard") ;
            stage.show() ;
    }

    @FXML
    private void submitRequestOnMouseClicked(MouseEvent event) {
        int shelterAmount = Integer.parseInt(shelterAmountTextField.getText());
        int dd = Integer.parseInt(ddTextField.getText());
        int mm = Integer.parseInt(mmTextField.getText());
        int yyyy = Integer.parseInt(yyyyTextField.getText());
        int ddDeadline = Integer.parseInt(ddDeadlineTextField.getText());
        int mmDeadline = Integer.parseInt(mmDeadlineTextField.getText());
        int yyyyDeadline = Integer.parseInt(yyyyDeadlineTextField.getText());

        Date requestDate = new Date(dd, mm, yyyy);
        Date deadline = new Date(ddDeadline, mmDeadline, yyyyDeadline);

        ShelterRequest newShelterRequest = new ShelterRequest(shelterAmount, requestDate, deadline, "Pending");
    }
    
}
