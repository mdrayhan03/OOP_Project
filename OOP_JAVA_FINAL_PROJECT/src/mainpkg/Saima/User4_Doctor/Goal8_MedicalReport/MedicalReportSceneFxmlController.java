/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal8_MedicalReport;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.AbstractClass.User;
import mainpkg.Saima.User3_AidExcutive.Goal8_Report.ReportList;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */

public class MedicalReportSceneFxmlController implements Initializable {

    @FXML
    private TextField ddTextField;
    @FXML
    private TextField mmTextField;
    @FXML
    private TextField yyyyTextField;
    @FXML
    private TextField campManagerIdTextField;
    @FXML
    private TextField subjectTextField;
    @FXML
    private TextArea reportBodyTextArea;

    /**
     * Initializes the controller class.
     */
    Doctor user ;
    Alert alert ;
    ReportList sir ;
    
    public User get() {
        return user ;
    }
    
    public void set(Doctor u) {
        user = u ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClicked(MouseEvent event) {
    }
    
}
