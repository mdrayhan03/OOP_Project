/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Rasel.Refugee.Goal8_Rules;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpkg.Rasel.CampManager.Goal3_CampRules.CampRules;

/**
 * FXML Controller class
 *
 * @author synt4x_err0r
 */
public class RefugeeRulesSceneController implements Initializable {

    @FXML
    private TableView<CampRules> refugeeRulesTableView;
    @FXML
    private TableColumn<CampRules, String> refugeeRulesTC;
    
    private ObservableList<CampRules> rulesList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        printFromBin();
        refugeeRulesTC.setCellValueFactory(new PropertyValueFactory<>("newRule"));

    }    

    @FXML
    private void refugeeRulesBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/Refugee/RefugeeDashboardScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }
    
    
    public void printFromBin(){
        
        File f = null;
        f = new File("src/File/CampRules.bin");
        if (f.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(f);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                
                CampRules r;

                while (true) {
                    try {
                        r = (CampRules) objectIn.readObject();
                        rulesList.add(r);
                    } catch (EOFException e) {
                        break;
                    }
                }

                for (CampRules rule : rulesList) {
                    refugeeRulesTableView.getItems().add(new CampRules(rule+"\n"));
                
                }
            
                objectIn.close();
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
            e.printStackTrace();
        }
      } else {
            System.out.println("Rule file is not found");
        }
    }
    
}
