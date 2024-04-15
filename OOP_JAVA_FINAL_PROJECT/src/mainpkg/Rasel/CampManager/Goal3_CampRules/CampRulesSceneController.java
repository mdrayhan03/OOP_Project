package mainpkg.Rasel.CampManager.Goal3_CampRules;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;

public class CampRulesSceneController implements Initializable {

    @FXML
    private TextArea rulesTextArea;

    CampRules cr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        printFromBin();
    }

    @FXML
    private void campRulesBackButton(ActionEvent event) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/CampManager/CampManagerDashboardScene.fxml"));
        Parent myPage = myLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene myScene = new Scene(myPage);
        stage.setScene(myScene);
        stage.show();
    }

    @FXML
    private void updateRulesButtonOnClick(ActionEvent event) throws IOException {
        String newRule = rulesTextArea.getText();
        
        String[] ruleLines = newRule.split("\n");

        CampRules cr;

        for (String line : ruleLines) {
            cr = new CampRules(line);
            saveToBinFile(cr);
        }
        
        showAlert("The data has been saved.", Alert.AlertType.INFORMATION);

    }
    
    @FXML
    private void deleteRulesOnButtonClick(ActionEvent event) {
        File file = new File("src/File/CampRules.bin");

        if (file.exists()) {
            boolean deleted = file.delete();

            if (deleted) {
                showAlert("Rules file deleted successfully.", AlertType.INFORMATION);
            } else {
                showAlert("Failed to delete rules file.", AlertType.ERROR);
            }
        }   
    }
    

    private void saveToBinFile(CampRules newRule) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

            f = new File("src/File/CampRules.bin");
            if (f.exists()) {
            try {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CampRulesSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newRule);
            
    }
    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public void printFromBin(){
        
        File f = null;
        f = new File("src/File/CampRules.bin");
        if (f.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(f);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
                ArrayList<CampRules> rulesList = new ArrayList<>();
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
                    rulesTextArea.appendText(rule.getNewRule()+"\n");
                
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
            rulesTextArea.appendText("Rule is not define");
            System.out.println("Rule file is not found");
        }
    }
    
}   
