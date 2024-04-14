package mainpkg.Rasel.CampManager.Goal3_CampRules;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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

public class CampRulesSceneController implements Initializable {

    @FXML
    private TextArea rulesTextArea;

    CampRules cr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        printRulesFromFile();
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
    private void updateRulesButtonOnClick(ActionEvent event) {
        String newRule = rulesTextArea.getText();
        cr = new CampRules(newRule);
        cr.addRule();
    }
    
    @FXML
    private void deleteRulesOnButtonClick(ActionEvent event) {
        File file = new File("src/File/rules.txt");

        if (file.exists()) {
            boolean deleted = file.delete();

            if (deleted) {
                showAlert("Rules file deleted successfully.", AlertType.INFORMATION);
            } else {
                showAlert("Failed to delete rules file.", AlertType.ERROR);
            }
        }   
    }
    
    public void printRulesFromFile() {
        File file = new File("src/File/rules.txt");

        try {
            if (file.exists()){
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                rulesTextArea.clear();
                String line;
                while ((line = br.readLine()) != null) {
                    rulesTextArea.appendText(line + "\n");
                }

            } else {
                rulesTextArea.setText("Rules are not defined");
                System.out.println("Rules file is not found");
                
            }
            
        } catch (IOException e) {
            System.out.println("Error reading rules from file: " + e.getMessage());
        }
    }

    private void showAlert(String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}   
