package mainpkg.Rasel.CampManager.Goal4_Job;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author Rasel
 */
public class AddJobSceneController implements Initializable {

    @FXML
    private TextField jobTitleTextField;
    @FXML
    private TextArea jobDescriptionTextArea;
    @FXML
    private TextField jobVacancyTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addJobOnButtonClick(ActionEvent event) throws IOException {
    String jobName = jobTitleTextField.getText();
    String description = jobDescriptionTextArea.getText();
    int vacancy = Integer.parseInt(jobVacancyTF.getText());
        
    PostJob job = new PostJob(generateRandomID(), jobName, description, vacancy);
    
    saveToBinFile(job);
    
    System.out.println("Details:");
    System.out.println(job);

    resetUIFields();
    }
    
    private void resetUIFields() {
        jobDescriptionTextArea.clear();
        jobTitleTextField.clear();
        jobVacancyTF.clear();

    }

    @FXML
    private void addJobsBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/CampManager/Goal4_Job/manageJobsScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }
    
    public void saveToBinFile(PostJob job) throws IOException {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

            f = new File("src/File/AddJob.bin");
            if (f.exists()) {
            try {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddJobSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(job);
            showAlert("Job has been posted", Alert.AlertType.INFORMATION);
    }
    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public int generateRandomID() {
        Random random = new Random();
        int min = 100000;
        int max = 999999;
        int id = random.nextInt(max - min + 1) + min;
        return id;
    }
    
}
