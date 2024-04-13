/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal1_AddMedicine;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rasel.CampManager.Goal5_Supply.Medicine;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddMedicineSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> medicineIdComboBox;
    @FXML    private TableView<Medicine> addMedicineTableView;
    @FXML    private TableColumn<Medicine, String> medicineIdTableColumn;
    @FXML    private TableColumn<Medicine, String> medicineNameTableColumn;
    @FXML    private TableColumn<Medicine, Integer> medicienAmountTableColumn;
    @FXML    private TableColumn<Medicine, Date> addedMedicineDateTableColumn;
    @FXML    private TableColumn<Medicine, Date> foodNameTableColumn1;
    @FXML    private TableColumn<Medicine, String> foodNameTableColumn2;
    @FXML    private Label medicineNameLabel;
    @FXML    private Label medicineAmountLabel;
    @FXML    private Label ddLabel;
    @FXML    private Label mmLabel;
    @FXML    private Label yyyyLabel;

    /**
     * Initializes the controller class.
     */
    
    Alert alert ;
    Doctor user ;
    
    ObservableList<Medicine> list = FXCollections.observableArrayList() ;
    
    
    
    public Doctor get() {
        return user ;
    }
    public void set(Doctor u) {
        user = u ;
    }
    
    public void setComboBox() {
        for(Medicine medi: list) {
            medicineIdComboBox.getItems().add(medi.getId()) ;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        medicineIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("medicineId")) ;
        medicineNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("medicineName")) ;
        medicienAmountTableColumn.setCellValueFactory(new PropertyValueFactory<>("medicineAmount")) ;
        addedMedicineDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("addMedicineDate")) ;
    
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor") ;
        stage.show() ;
    
    }

    @FXML
    private void medicineIdOnMouseClicked(MouseEvent event) {
        Medicine medi = user.medicineInfo(medicineIdComboBox.getValue(), list) ;
        if (medi != null) {
            medicineNameLabel.setText(medi.getName()) ;
            medicineAmountLabel.setText(medi.getAmount().toString()) ;
            ddLabel.setText(medi.getDate().toString()) ;
            mmLabel.setText(medi.getDate().toString()) ;
            yyyyLabel.setText(medi.getDate().toString()) ;
            
        }
    
    }
    
}
