/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal5_AddShelter;

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
import mainpkg.Rasel.CampManager.Goal5_Supply.Shelter;

import mainpkg.Saima.User3_AidExcutive.AidExcutive;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddShelterSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> shelterIdComboBox;
    @FXML    private TableView<Shelter> addShelterInfoTableView;
    @FXML    private TableColumn<Shelter, String> shelterIdTableColumn;
    @FXML    private TableColumn<Shelter, Integer> shelterAmountTableColumn;
    @FXML    private TableColumn<Shelter, String> shelterStatusTableColumn;
    @FXML    private TableColumn<Shelter, Date> addedShelterDateTableColumn;
    @FXML    private Label familyMembersIdLabel;
    @FXML    private Label ddLabel;
    @FXML    private Label mmLabel;
    @FXML    private Label yyyyLabel;
    @FXML    private Label totalShelterLabel;
    @FXML    private Label emptyShelterLabel;
    @FXML    private Label shelterStatusLabel;

    /**
     * Initializes the controller class.
     */
    Alert alert ;
    AidExcutive user ;

    ObservableList<Shelter> list = FXCollections.observableArrayList() ;
    
    
    public AidExcutive get() {
        return user ;
    }
    public void set(AidExcutive u) {
        user = u ;
    }
    
    public void setComboBox() {
        for (Shelter sh : list) {
            shelterIdComboBox.getItems().add(sh.getId());
        }
    }
    @Override  
    public void initialize(URL url, ResourceBundle rb) {
        shelterIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        shelterAmountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        shelterStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        addedShelterDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) throws IOException {
        Parent root = null;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExecutive/AidExcutiveDashBoardSceneFxml.fxml"));
        root = (Parent) myLoader.load();
        Scene myScene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(myScene);
        stage.setTitle("Aid Executive");
        stage.show();
    }

    @FXML
    private void shelterIdOnMouseClicked(MouseEvent event) {
        Shelter sh = user.shelterInfo((String) shelterIdComboBox.getValue(), list);
        if (sh != null) {
            familyMembersIdLabel.setText(sh.getId());
            totalShelterLabel.setText(String.valueOf(sh.getAmount()));
            emptyShelterLabel.setText(sh.getStatus());
            ddLabel.setText(sh.getDate().toString());
            mmLabel.setText(sh.getDate().toString());
            yyyyLabel.setText(sh.getDate().toString());
        }
    }
    
}
