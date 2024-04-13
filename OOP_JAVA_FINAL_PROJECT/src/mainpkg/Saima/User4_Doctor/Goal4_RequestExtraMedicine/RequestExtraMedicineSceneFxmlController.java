/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal4_RequestExtraMedicine;

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

import mainpkg.Saima.User4_Doctor.Doctor;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class RequestExtraMedicineSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> requestMedicineNameComboBox;
    @FXML    private TextField requestMedicineQuantityTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextField ddDeadlineTextField;
    @FXML    private TextField mmDeadlineTextField;
    @FXML    private TextField yyyyDeadlineTextField;
    @FXML    private TableView<MedicineRequest> requestExtraMedicineTableView;
    @FXML    private TableColumn<MedicineRequest, String> requestIdTableColumn;
    @FXML    private TableColumn<MedicineRequest, String> medicineNameTableColumn;
    @FXML    private TableColumn<MedicineRequest, Integer> medicineQuantityTableColumn;
    @FXML    private TableColumn<MedicineRequest, Date> requestDateTableColumn;
    @FXML    private TableColumn<MedicineRequest, Date> deadlineTableColumn;
    @FXML    private TableColumn<MedicineRequest, String> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    
    Alert alert ;
    Doctor user ;
    ObservableList<MedicineRequest> list = FXCollections.observableArrayList() ;
    
    
    public Doctor get() {
        return user ;
    }
    public void set(Doctor u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        requestMedicineNameComboBox.getItems().addAll("Napa","Napa Extra","Doxin","Lumona 10","Finix","Adovas","tufnil","Imodium","Alaxan");
        requestIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        medicineNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        medicineQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("medicineAmount"));
        requestDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        deadlineTableColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        // TODO
    }    

    @FXML
    private void backOnMouseClicked(MouseEvent event) throws IOException {
            Parent root = null ;
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DashBoardSceneFxml.fxml")) ;
            root = (Parent) myLoader.load() ;
            Scene myScene = new Scene(root) ;

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
            stage.setScene(myScene) ;
            stage.setTitle("Doctor DashBoard") ;
            stage.show() ;
    
    }

    @FXML
    private void submitRequestOnMouseClicked(MouseEvent event) {
        String medicineName = (String) requestMedicineNameComboBox.getValue();
        int amount = Integer.parseInt(medicineQuantityTableColumn.getText());
        int dd = Integer.parseInt(ddTextField.getText());
        int mm = Integer.parseInt(mmTextField.getText());
        int yyyy = Integer.parseInt(yyyyTextField.getText());
        int ddDeadline = Integer.parseInt(ddDeadlineTextField.getText());
        int mmDeadline = Integer.parseInt(mmDeadlineTextField.getText());
        int yyyyDeadline = Integer.parseInt(yyyyDeadlineTextField.getText());
        
        Date requestDate = new Date(dd, mm, yyyy);
        Date deadline = new Date(ddDeadline, mmDeadline, yyyyDeadline);
        
        MedicineRequest newMedicneRequest = new MedicineRequest(medicineName, amount, requestDate, deadline, "Pending");
        
        list.add(newMedicneRequest);
        requestExtraMedicineTableView.setItems(list);
        
        clearFields();
    }
    
    private void clearFields() {
        requestMedicineNameComboBox.getSelectionModel().clearSelection();
        requestMedicineQuantityTextField.clear();
        ddTextField.clear();
        mmTextField.clear();
        yyyyTextField.clear();
        ddDeadlineTextField.clear();
        mmDeadlineTextField.clear();
        yyyyDeadlineTextField.clear();
    }
        
    }
    

