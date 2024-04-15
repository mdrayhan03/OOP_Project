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

    private List<String> rulesList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rulesList = new ArrayList<>();
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
        rulesList.add(newRule);
        saveRuleToFile(newRule);
    }

    private void saveRuleToFile(String newRule) {
        File file = new File("src/File/rules.txt");

        try {
            FileWriter fw = new FileWriter(file, true);

            if (!file.exists()) {
                for (String rule : rulesList) {
                    fw.write(rule + "\n");
                }
            }

            fw.write(newRule + "\n");

            fw.close();

            System.out.println("Rule saved successfully to file.");
        } catch (IOException e) {
            System.out.println("Error saving rule to file: " + e.getMessage());
        }
    }

    private void printRulesFromFile() {
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
                rulesTextArea.setText("Rules is not defined");
                System.out.println("Rules file is not found");
                
            }
            
        } catch (IOException e) {
            System.out.println("Error reading rules from file: " + e.getMessage());
        }
    }
    
    @FXML
    private void deleteRulesOnButtonClick(ActionEvent event) {
        File file = new File("src/File/rules.txt");

        if (file.exists()) {
            boolean deleted = file.delete();

            if (deleted) {
                showAlert(AlertType.INFORMATION, "File Deleted", "Rules file deleted successfully.");
            } else {
                showAlert(AlertType.ERROR, "Error", "Failed to delete rules file.");
            }
        }   
    }

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}   
