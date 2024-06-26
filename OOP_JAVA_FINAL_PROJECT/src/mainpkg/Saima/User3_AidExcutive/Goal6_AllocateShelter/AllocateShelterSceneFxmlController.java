/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal6_AllocateShelter;

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rasel.CampManager.Goal5_Supply.Shelter;

import mainpkg.Rasel.CampManager.Goal5_Supply.Shelter;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class AllocateShelterSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> emptyShelterIdComboBox;
    @FXML    private Label familyMemberId1Label;
    @FXML    private Label familyMemberId2Label;
    @FXML    private Label familyMemberId3Label;
    @FXML    private Label familyMemberId4Label;
    @FXML    private Label familyMemberId5Label;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;

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
            emptyShelterIdComboBox.getItems().add(sh.getId());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) throws IOException {
        
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/AidExcutiveDashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Aid Excutive DashBoard") ;
        stage.show() ;
    
    }

    @FXML
    private void allocateButtonOnMouseClicked(MouseEvent event) {
        String selectedShelterId = emptyShelterIdComboBox.getValue();
   
        int dd = Integer.parseInt(ddTextField.getText());
        int mm = Integer.parseInt(mmTextField.getText());
        int yyyy = Integer.parseInt(yyyyTextField.getText());

        Date date = new Date(dd, mm, yyyy);

        Shelter allocatedShelter = user.allocateShelter(selectedShelterId, 1, date, "Allocated");

        if (allocatedShelter != null) {
            System.out.println("Shelter allocated successfully: " + allocatedShelter);
        } else {
            System.out.println("Failed to allocate shelter.");
        }

        ObservableList<Refugee> familyMembers = user.getFamilyMembersOfShelter(selectedShelterId);

        if (familyMembers != null && familyMembers.size() == 5) {

            familyMemberId1Label.setText(String.valueOf(familyMembers.get(0).getRefugeeID()));
            familyMemberId2Label.setText(String.valueOf(familyMembers.get(1).getRefugeeID()));
            familyMemberId3Label.setText(String.valueOf(familyMembers.get(2).getRefugeeID()));
            familyMemberId4Label.setText(String.valueOf(familyMembers.get(3).getRefugeeID()));
            familyMemberId5Label.setText(String.valueOf(familyMembers.get(4).getRefugeeID()));
        }
    }
    
}
