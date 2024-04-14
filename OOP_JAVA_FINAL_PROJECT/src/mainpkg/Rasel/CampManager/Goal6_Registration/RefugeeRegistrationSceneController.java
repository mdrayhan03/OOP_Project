package mainpkg.Rasel.CampManager.Goal6_Registration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import mainpkg.Rasel.Refugee.Refugee;


public class RefugeeRegistrationSceneController implements Initializable {

    @FXML
    private TextField refugeeNameTextField;
    @FXML
    private TextField refugeeFatherNameTextField;
    @FXML
    private TextField refugeeMotherNameTextField;
    @FXML
    private TextField refugeeSymboleText;
    @FXML
    private TextArea refugeeDescriptionTextArea;
    @FXML
    private ComboBox<Integer> selectCampCB;
    @FXML
    private DatePicker refugeeDobDatePicker;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private RadioButton othersRadioButton;
    @FXML
    private TextField refugeeIdTextField;
    
    ArrayList<Refugee> refugeeList = new ArrayList<>();

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for ( int i=1; i<50; i++ ){
            selectCampCB.getItems().add(i);
        }
        
        ToggleGroup tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        othersRadioButton.setToggleGroup(tg);
        
        refugeeIdTextField.setText(Integer.toString(generateRandomID()));
    }

    @FXML
    private void addrefugeeOnButtonClick(ActionEvent event) throws IOException {
    
    int refugeeID = Integer.parseInt(refugeeIdTextField.getText());
    String name = refugeeNameTextField.getText();
    String fatherName = refugeeFatherNameTextField.getText();
    String motherName = refugeeMotherNameTextField.getText();
    String symbole = refugeeSymboleText.getText();
    String description = refugeeDescriptionTextArea.getText();
    int campNo = selectCampCB.getValue();

    String gender = "";
    if (maleRadioButton.isSelected()) {
        gender = "Male";
    } else if (femaleRadioButton.isSelected()) {
        gender = "Female";
    } else if (othersRadioButton.isSelected()) {
        gender = "Others";
    }
    
    LocalDate dob = refugeeDobDatePicker.getValue();
    
    
    Refugee newRefugee = new Refugee(
            name,
            generatePassword(),
            gender,
            dob.toString(),
            fatherName,
            motherName,
            symbole,
            description,
            "Refugeee",
            refugeeID,
            campNo
    );
    saveToBinFile(newRefugee);
    
    System.out.println("New Refugee Details:");
    System.out.println(newRefugee);
        
        

        resetUIFields();
    }

    private void resetUIFields() {
    refugeeNameTextField.clear();
    refugeeFatherNameTextField.clear();
    refugeeMotherNameTextField.clear();
    refugeeSymboleText.clear();
    refugeeDescriptionTextArea.clear();
    selectCampCB.getSelectionModel().clearSelection();
    refugeeDobDatePicker.setValue(null);
    maleRadioButton.setSelected(false);
    femaleRadioButton.setSelected(false);
    othersRadioButton.setSelected(false);
    }
    
    @FXML
    private void refugeeRegistrationBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/CampManager/CampManagerDashboardScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }
    
    public int generateRandomID() {
        Random random = new Random();
        int min = 1000000;
        int max = 9999999;
        int refugeeID = random.nextInt(max - min + 1) + min;
        return refugeeID;
    }
    
    public String generatePassword() {
        String prefix = "refugee";
        String suffix = FourDigitNumber();
        String password = prefix + suffix;
        return password;
    }

    private String FourDigitNumber() {
        Random random = new Random();
        int min = 1000;
        int max = 9999;
        int randomNumber = random.nextInt(max - min + 1) + min;
        String fourDigitNumber = String.format("%04d", randomNumber);

        return fourDigitNumber;
    }

    
    public void saveToBinFile(Refugee newRefugee) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

            f = new File("src/File/RefugeeInfo.bin");
            if (f.exists()) {
            try {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RefugeeRegistrationSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newRefugee);
            showAlert("The data has been saved.", AlertType.INFORMATION);
    }
    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
